import jdk.jshell.EvalException;
import org.graalvm.polyglot.*;
import java.util.*;
class Polyglot {
    private static void Binom() {
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
        Value nrarunc = polyglot.eval("python", "int(input(\"Nr aruncari = \"))");
        int nrAruncari = nrarunc.asInt();
        System.out.println("1 <= x <= Nr aruncari");
        Value x = polyglot.eval("python", "int(input(\" x = \"))");
        int x1 = x.asInt();
        System.out.println(polyglot.eval("R","dbinom(" + x1 +", size="+ nrAruncari +", prob=" + 0.5 + ")"));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Context polyglot = Context.create();
        Binom();
        polyglot.close();

    }
}
