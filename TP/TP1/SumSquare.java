package TP.TP1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class SumSquare {
    final static int MIN = 100_000, MAX = 1_000_000, PAS = 1000;
    private static int MILLISEC = 1000000;
    private static final int NB_METHODES = 3;
    public static int sumSquare1(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                res = res + i;
            }
        }
        return res;
    }

    public static int sumSquare2(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = res + i * i;
        }
        return res;
    }

    public static int sumSquare3(int n) {
        int res = 0;
        res = n * (n + 1) * (2 * n + 1) / 6;
        return res;
    }

    public static <T,R> double getTime(Function<T,R> function, T n) {
        long d = System.nanoTime();
        function.apply(n);
        double t = (System.nanoTime() - d) / 1E6;
//        System.out.println(t + "\t");
        return t;
    }

    public static void main(String arg[]){
//        //TODO
        List<Function<Integer,Integer>> functions = Arrays.asList(SumSquare::sumSquare1,SumSquare::sumSquare2,SumSquare::sumSquare3);
        for(int n = MIN; n < MAX; n += PAS) {
            System.out.print(n+ "\t");
            for (Function<Integer,Integer> f : functions) {
                double time = SumSquare.getTime(f,n);
                System.out.print(time + "\t");
            }
            System.out.println();
        }

    }
}