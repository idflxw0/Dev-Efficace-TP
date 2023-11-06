package DST;

public class Search {

    /**
     * On utilise binary search pour trouver X
     * @param tab : tableau
     * @param x : valuer à trouver dans le tab
     * @return : true : si on a trouvé sinon false
     */
    public static boolean recherche(int[] tab, int x){
        if (tab.length ==0) return false;
        if (x < 0) return false;
        for (int i = 0; i < tab.length;i ++) {
            if (tab[i] == x) return true;
        }
        return false;
    }
    /*
    QUESTION 2 :
        * meuilleur des cas: O(1) : middle = x, on retourne directement
        * le cas moyen : O(n) : c'est le binary search
        * le pire des cas : O(n) : cest pareil que le cas moyen
     */

    /**
     * Question 3 : Binary Search recursivité
     * @param t : tableau
     * @param x : valuer à trouver dans le tab
     * @param d : faible  :  left
     * @param f : fort  : right
     * @return true : si on a trouvé sinon false
     */
    public static boolean dichotomiRec(int[] t, int x, int d, int f) {
        if (d > f) return false;
        if (x < 0) return false;
        int middle = d + (f-d) / 2;

        if (t[middle] == x) return true;
        else if (t[middle] < x) {
            return dichotomiRec(t,x,middle+1,f);
        }
        else {
            f = middle - 1;
            return dichotomiRec(t,x,d,middle-1);
        }
    }
    /*
    QUESTION 3 :
        * meuilleur des cas: O(1) : middle = x, on retourne directement
        * le cas moyen : O(log(n)) : c'est le binary search
        * le pire des cas : O(log(n)) : cest pareil que le cas moyen
     */
    public static boolean dichotomie(int[] t, int x) {
        return dichotomiRec(t,x,0,t.length-1);
    }

    public static void main(String[] args) {
        int[] tab = {1,2,4,5,6,7,8,9};
        System.out.println(dichotomie(tab,1));
    }
}
