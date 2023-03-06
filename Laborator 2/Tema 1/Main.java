//import libraria principala polyglot din graalvm

import org.graalvm.polyglot.*;
import java.io.*;
import java.util.*;

//clasa principala - aplicatie JAVA
class Polyglot {
    //metoda privata pentru conversie low-case -> up-case folosind functia toupper() din R
    private static String RToUpper(String token){
        //construim un context care ne permite sa folosim elemente din R
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
        //folosim o variabila generica care va captura rezultatul excutiei funcitiei R, toupper(String)
        //pentru aexecuta instructiunea I din limbajul X, folosim functia graalvm polyglot.eval("X", "I");
        Value result = polyglot.eval("R", "toupper(\""+token+"\");");
        //utilizam metoda asString() din variabila incarcata cu output-ul executiei pentru a mapa valoarea generica la un String
        String resultString = result.asString();
        resultString = resultString.substring(1,resultString.length()-1);
        // inchidem contextul Polyglot
        polyglot.close();

        return resultString;
    }

    //metoda privata pentru evaluarea unei sume de control simple a literelor unui text ASCII, folosind PYTHON
    private static int SumCRC(String token){
        //construim un context care ne permite sa folosim elemente din PYTHON
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
        //folosim o variabila generica care va captura rezultatul excutiei functiei PYTHON, sum()
        //avem voie sa inlocuim anumite elemente din scriptul pe care il construim spre evaluare, aici token provine din JAVA, dar va fi interpretat de PYTHON
        Value result = polyglot.eval("python", "sum(ord(ch) for ch in '" + token + "')");
        //utilizam metoda asInt() din variabila incarcata cu output-ul executiei, pentru a mapa valoarea generica la un Int
        int resultInt = result.asInt();
        // inchidem contextul Polyglot
        polyglot.close();

        return resultInt;
    }
    private static int random20list(){
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
        polyglot.eval("python","import random");
        Value result = polyglot.eval("python", "random.randint(0, 20)");
        int resultInt = result.asInt();
        polyglot.close();
        return resultInt;
    }
    /*
    I HATE THIS
    private static double sortAndMed(List<Integer> list){
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
        polyglot.eval("R","rlist <- list()");
        for (int i = 0; i < list.size(); i++){
            polyglot.eval("R", "append(rlist," + list.get(i) + ")");
        }
        polyglot.eval("R", "rlist <- lapply(rlist,sort)");
        for(int i = 0; i < 20*20/100; i++){
            polyglot.eval("R", "rlist[[1]] = NULL");
            polyglot.eval("R", "rlist[length(rlist)] = NULL");
        }
        Value result = polyglot.eval("R", "mean(unlist(rlist))");
        System.out.println(result);
        double resultInt = result.asDouble();
        polyglot.close();
        return resultInt;
    */
    private static int sortAndMed(List<Integer> list) {
        System.out.println("");
        for (int i = 0; i < 20 * 20 / 100; i++) {
            list.remove(0);
            list.remove(list.size() - 1);
        }
        int sum = 0, avg;
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            sum = sum + list.get(i);
        }
        avg = sum / list.size();
        return avg;
    }
    private static void printList(List<Integer> list){
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
        for (int i = 0; i < list.size(); i++){
            polyglot.eval("js", "console.log(" + list.get(i) + ");");
        }
        polyglot.close();
    }

    public static void main(String[] args) {
        Context polyglot = Context.create();

        int sumctr = 2;
        boolean afis = false;
        Value array = polyglot.eval("js", "[\"OwO\",\"XDDD\",\"Sssssssss\",\"Hee-hee\",\"java\"];");
        for (int i = 0; i < array.getArraySize();i++){
            String element = array.getArrayElement(i).asString();
            String upper = RToUpper(element);
            int crc = SumCRC(upper);
            if (crc == sumctr) {
                afis = true;
                System.out.println(upper + " -> " + crc);
            }

        }
        if(afis == false) {
            System.out.println("niciun cuvant nu are suma de control precizata");
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(random20list());
        }
        printList(list);
        System.out.println(sortAndMed(list));
        polyglot.close();

    }
}
