package DST;

import java.util.Stack;

public class ABR_char {
    /*Atrributs de classe*/
    private Character lettre;
    protected ABR_char filsgauche;
    protected ABR_char filsDroite;
    protected ABR_char pere;
    public ABR_char() {
        filsgauche = null;
        filsDroite = null;
        pere = null;
    }

    public void ajouter(char v) {
        if (lettre == null) {
            lettre = v;
        } else {
            int value_v = Character.getNumericValue(v);
            int value_lettre = Character.getNumericValue(lettre);
            if (value_v < value_lettre) {
                if (this.filsgauche == null) {
                    filsgauche = new ABR_char();
                    filsgauche.pere = this;
                }
                filsgauche.ajouter(v);
            }
            else {
                if (this.filsDroite == null) {
                    filsDroite = new ABR_char();
                    filsDroite.pere = this;
                }
                filsDroite.ajouter(v);
            }
        }
    }
    public static int nbNoeuds(ABR_char a) throws Exception {
        if (a == null) return 0;
        return 1 + nbNoeuds(a.filsgauche) + nbNoeuds(a.filsDroite);
    }

    public ABR_char oncle() {
        if (this.pere == null || this.pere.pere == null) return null;
        if (this.pere.pere.filsDroite == this.pere) return this.pere.pere.filsgauche;
        else return this.pere.pere.filsDroite;
    }

    public static boolean estABR(ABR_char a) {
        return estABRAux(a, null,null);
    }
    private static boolean estABRAux(ABR_char a, Character min, Character max) {
        if (a == null) return true;
        if ((min != null && a.lettre <= min) || (max != null && a.lettre >= max)) return false;
        return estABRAux(a.filsgauche, min, a.lettre) && estABRAux(a.filsDroite, a.lettre, max);
    }

    public static void main(String[] args) throws Exception {
        ABR_char etudiant = new ABR_char();
        String e = "informatique";
        for (int i = 0; i < e.length(); i++) {
            etudiant.ajouter(e.charAt(i));
        }
        System.out.println(nbNoeuds(etudiant));
        System.out.println(estABR(etudiant));
    }
}
