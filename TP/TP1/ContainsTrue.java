import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class ContainsTrue {
    final static int MIN = 100_000, MAX = 1_000_000, PAS = 1000;
    private static Random r = new Random();
    public static boolean contiansTrue(boolean[] tab) {
        boolean res = false;
        for (int i = 0; i < tab.length; i++) {
            res = res || tab[i];
        }
        return res;
    }

    public static boolean containsTrue2(boolean[] tab) {
        boolean res = false;
        int i = 0;
        while((!res) && (i < tab.length)) {
            res = (res || tab[i]);
            i++;
        }
        return res;
    }

    public static boolean[] genRandomBoolean(int n) {
        boolean[] b = new boolean[n];
        for(int i = 0; i < n; i ++) {
            b[i] = r.nextBoolean();
        }
        return b;
    }


    public static void main(String[] args) {
        List<Function<boolean[],Boolean>> functions = Arrays.asList(ContainsTrue::contiansTrue,ContainsTrue::containsTrue2);
        int NB = 100;
        for(int n = MIN; n < MAX; n += PAS) {
            HashMap<Function<boolean[],Boolean>,Double> tps = new HashMap<>();
            for (int i = 0; i < 100; i++) {
                boolean[] t = genRandomBoolean(n);
                for (Function<boolean[],Boolean> f : functions) {
                    double ac = tps.getOrDefault(f,0.);
                    tps.put(f,ac+SumSquare.getTime(f,t));
                }
            }
            System.out.print(n+ "\t");
            for (Function<boolean[], Boolean> f : functions) {
                System.out.print((tps.get(f)/NB) + "\t");
            }
            System.out.println();
        }
    }
}
