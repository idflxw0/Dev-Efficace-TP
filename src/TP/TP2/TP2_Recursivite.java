package TP.TP2;
import TP.TP1.SumSquare;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class TP2_Recursivite {
    final static int MIN = 100_000, MAX = 1_000_000, PAS = 1000;

    public static int factorielleRec(int n) {
        if (n < 2) return 1;
        return factorielleRec(n-1) * n;
    }

    public static int factorielleIter(int n){
        if (n < 2) return 1;
        int f = 1;
        for (int i = 2; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println(factorielleRec(10));
        System.out.println(factorielleIter(10));
//        List<Function<Integer,Integer>> functions = Arrays.asList(TP2_Recursivite::factorielleRec,TP2_Recursivite::factorielleIter);
//        for(int n = MIN; n < MAX; n += PAS) {
//            System.out.print(n+ "\t");
//            for (Function<Integer,Integer> f : functions) {
//                double time = SumSquare.getTime(f,n);
//                System.out.print(time + "\t");
//            }
//            System.out.println();
//        }
    }
}
