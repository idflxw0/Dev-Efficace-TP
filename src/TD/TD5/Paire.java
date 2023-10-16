package TD.TD5;


import TD.TD4.BinarySearchTree;
import TD.TD4.LinkedBSTree;
import TP.TP3.tree.BinaryTree;

import java.util.LinkedList;

public class Paire<T>{
    private enum Ordre {
        PRE,
        INF,
        POST
    };

    BinaryTree<T> arbre;
    Ordre ordre;
    Paire(BinaryTree<T> a) {
        this.arbre= a;
        this.ordre = Ordre.PRE;
    }

    public String mystereIter(BinaryTree<T> t) {
        StringBuilder sb =  new StringBuilder();
        LinkedList<Paire<T>> pile = new LinkedList<>();
        pile.push(new Paire<>(t));
        while(!pile.isEmpty()) {
            Paire<T> p = pile.peek();
            switch (p.ordre) {
                case PRE -> {
                    if (p.arbre.isEmpty()) {
                        sb.append("<>"); //PRE
                        pile.pop();
                    } else {
                        sb.append("<").append(arbre.getValue()).append(", "); //pre
                        p.ordre = Ordre.INF;
                        pile.push(new Paire<>(p.arbre.getLeft()));
                    }
                }
                case INF -> {
                    sb.append(", "); // INF
                    p.ordre = Ordre.POST;
                    pile.push(new Paire<>(p.arbre.getRight()));
                }
                case POST -> {
                    sb.append(">"); //POST
                    pile.pop();
                }
            }
        }
        return sb.toString();
    }

    public int mystereIterSize(BinaryTree<T> t) {
        int s = 0;
        LinkedList<Paire<T>> pile = new LinkedList<>();
        pile.push(new Paire<>(t));
        while(!pile.isEmpty()) {
            Paire<T> p = pile.peek();
            switch (p.ordre) {
                case PRE -> {
                    if (p.arbre.isEmpty()) {
                     //PRE
                        pile.pop();
                    } else {
                        ++s; //pre
                        p.ordre = Ordre.INF;
                        pile.push(new Paire<>(p.arbre.getLeft()));
                    }
                }
                case INF -> {
                    // INF
                    p.ordre = Ordre.POST;
                    pile.push(new Paire<>(p.arbre.getRight()));
                }
                case POST -> {
                     //POST
                    pile.pop();
                }
            }
        }
        return s;
    }

    public int mystereIterHeight(BinaryTree<T> t) {
        int height = 0;
        int depth = 0;
        LinkedList<Paire<T>> pile = new LinkedList<>();
        pile.push(new Paire<>(t));
        while(!pile.isEmpty()) {
            Paire<T> p = pile.peek();
            switch (p.ordre) {
                case PRE -> {
                    if (p.arbre.isEmpty()) {
                        pile.pop();
                    } else {
                        ++depth; //pre
                        height = Math.max(depth,height);
                        p.ordre = Ordre.INF;
                        pile.push(new Paire<>(p.arbre.getLeft()));
                    }
                }
                case INF -> {
                    // INF
                    p.ordre = Ordre.POST;
                    pile.push(new Paire<>(p.arbre.getRight()));
                }
                case POST -> {
                    //POST
                    --depth;
                    pile.pop();
                }
            }
        }
        return height;
    }


    public static void main(String[] args) {
        BinarySearchTree<Integer> t = new LinkedBSTree<>();
        int[] val = {20,10,30,27};
        for (int v : val) {
            t.add(v);
        }
    }
}
