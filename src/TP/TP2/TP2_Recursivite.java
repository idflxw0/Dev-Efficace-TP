package TP.TP2;

public class TP2_Recursivite {
    private static int count_rec = 0;
    private static int count_iter = 0;
    private static Observer obs = new Observer();
    static class exo1 {
        public static int factorielleRec(int n) {
            if (n < 2) return 1;
            count_rec++;
            return factorielleRec(n-1) * n;
        }

        public static int factorielleIter(int n){
            if (n < 2) return 1;
            int f = 1;
            for (int i = 2; i <= n; i++) {
                count_iter++;
                f *= i;
            }
            return f;
        }

        public static void main(String[] args) {
            System.out.println(factorielleRec(10));
            System.out.println(factorielleIter(10));
            System.out.println("count iter : " + count_iter );
            System.out.println("count rec : " + count_rec);
        }
    }
    static class exo2 {
        public static int puissance(int n) {
            obs.enter();
            int r;
            if (n == 0){
                obs.exit();
                return 1;
            }
            else {
                r = 2*puissance(n-1);
                obs.operate();
            }
            obs.exit();
            return r;
        }

        public static int puissance2(int n){
            obs.enter();
            int r =0;
            if(n==0) {
                obs.exit();
                return 1;
            }
            else {
                r= puissance2(n-1) + puissance2(n-1);
                obs.operate();
            }
            obs.exit();;
            return r;
        }

        public static void main(String[] args) {
            obs = new Observer();
            puissance(10);
            System.out.println(obs);
            obs = new Observer();
            puissance2(10);
            System.out.println(obs);
        }
    }


}
