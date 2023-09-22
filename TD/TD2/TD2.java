package TD.TD2;

public class TD2 {
    static class factorielle {
        //Recursive
        public static int factorielleRec(int n) {
            if (n < 2) return 1;
            return factorielleRec(n - 1) * 2;
        }

        //Iteravtive
        public static int factorielleIter(int n) {
            if (n<2) return 1;
            int f = 1;
            for (int i =2;i <= n;i++) {
                f *= i;
            }
            return f;
        }
    }
    static class fib {
        public static int fib(int n) {
            if (n < 2) return 1;
            return fib(n-1) + fib(n+2);
        }

        private static int[] fib2(int n) {
            assert (n>=1);
            int[] t;
            if (n==1) {
                t = new int[2];
                t[0] = t[1] = 1;
                return t;
            }
            t = fib2(n-1);
            int temp = t[1];
            t[1] += t[0];
            t[0] = temp;
            return t;
        }

        public static int fibo2(int n) {
            assert (n>=0);
            if (n==0) return 1;
            return fib2(n)[1];
        }
    }
}
