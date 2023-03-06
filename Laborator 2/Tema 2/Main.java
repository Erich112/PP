import org.graalvm.polyglot.*;
import java.util.*;
class Polyglot {
    private static int[][] readData(){
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
        polyglot.eval("python", "file = open(\"/home/e/IdeaProjects/untitled/src/dataset.txt\", \"rt\")");
        polyglot.eval("python", "lines = file.readlines()");
        polyglot.eval("python", "x = lines[0].split(',')");
        Value lunglin = polyglot.eval("python", "len(x)");
        int lung = lunglin.asInt();
        int[][] matrix1 = new int[2][lung];
        for (int i = 0; i < lung; i++) {
            Value val = polyglot.eval("python", "int(x["+ i +"])");
            matrix1[0][i] = val.asInt();
        }
        polyglot.eval("python", "y = lines[1].split(',')");
        for (int i = 0; i < lung; i++) {
            Value val = polyglot.eval("python", "int(y["+ i +"])");
            matrix1[1][i] = val.asInt();
        }
        polyglot.close();
        return matrix1;
    }
    private static void regLinImg(String picName) {
        int[][] matric = readData();
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
        polyglot.eval("R", "xf <- vector()");
        for (int i = 0; i < matric[0].length; i++)
        {
            polyglot.eval("R", "xf <- append(xf, "+ matric[0][i] + ")");
        }
        polyglot.eval("R", "yf <- vector()");
        for (int i = 0; i < matric[1].length; i++)
        {
            polyglot.eval("R", "yf <- append(yf, "+ matric[1][i] + ")");
        }
        polyglot.eval("R","print(xf)");
        polyglot.eval("R","print(yf)");
        polyglot.eval("R", "relation <- lm(yf~xf)");
        picName = "/home/e/IdeaProjects/untitled/src/" + picName;
        polyglot.eval("R", "png(file = \"" + picName + "\")");
        polyglot.eval("R", "plot(yf,xf,col = \"blue\",main = \"Regresie Liniara\",abline(relation),cex = 1.3,pch = 16,xlab = \"X\",ylab = \"Y\")");
        polyglot.eval("R","dev.off()");
    }

    public static void main(String[] args) {
        System.out.println("Introduceti numele imaginii");
        Scanner input = new Scanner(System.in);
        Context polyglot = Context.create();
        String outPic = input.nextLine();
        System.out.println(outPic);
        regLinImg(outPic);
        polyglot.close();

    }
}
