package TP.TP1;

import java.util.Random;
public class main {
    public static boolean containsTrue1(boolean tab[]){
        boolean res = false;
        for(int i = 0; i < tab.length; i++){
            res = res || tab[i];
        }
        return res;
    }

    public static boolean containsTrue2(boolean tab[]){
        boolean res = false;
        int i = 0;
        while((!res) && (i < tab.length)){
            res = (res || tab[i]);
            i++;
        }
        return res;
    }

    public static boolean[] tabAleatoire(int taille) {
        boolean tab[] = new boolean[taille];
        Random r = new Random();
        for (int i = 0; i < taille; i++) {
            tab[i] = r.nextBoolean();
        }
        return tab;
    }

    public static boolean moyenne(boolean[] containsTrue) {
        return false;
    }
}