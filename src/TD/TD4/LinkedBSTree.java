package TD.TD4;

import TD.TD3.LinkedBTree;

public class LinkedBSTree <T extends Comparable<T>> extends LinkedBTree<T> implements BinarySearchTree<T>{
    public LinkedBSTree() {
        super();
    }
    public LinkedBSTree(T node, LinkedBTree<T> left, LinkedBTree<T> right) {
        super(node,left,right);
    }
    @Override
    public boolean contains(T v) {
        if (this.isEmpty()) return false;
        Node<T> c = this.root;
        while(c != null) {
            int cmp = v.compareTo(c.node);
            if (cmp == 0) return true;
            if (cmp < 0) c = c.left;
            else c = c.right;
        }
        return false;
    }

    @Override
    public void add(T v) {
        Node<T> n =  new Node<>(v,null,null);
        if (this.isEmpty()) {
            this.root = n;
            return;
        } else {
            Node<T> c = this.root;
            int cmp = v.compareTo(c.node);
            while(cmp < 0 && c.left != null || cmp >= 0 && c.right != null) {
                c = cmp < 0 ? c.left : c.right;
                cmp = v.compareTo(c.node);
            }
//            if (cmp > 0 || cmp == 0) {
//                if (c.right == null) {
//                    c.right = n;
//                    return;
//                }
//                c = c.right;
//
//            }
//            else {
//                if (c.left == null){
//                    c.left = n;
//                    return;
//                }
//                c = c.left;
//            }
            if(cmp < 0) c.left = n;
            else c.right = n;
        }

    }

    @Override
    public boolean remove(T v) {
        Node<T> current = this.root;
        Node<T> prev = null;
        int cmp = 0;
        while (current != null && (cmp = v.compareTo(current.node)) != 0) {
            prev = current;
            current = cmp < 0 ? current.left : current.right;
        }
        if (current == null) return false;

        if (current.left != null && current.right != null) {
            replace(current);
        } else {
            Node<T> reste = current.left == null ? current.right : current.left;
            if (prev == null) {
                this.root = reste; // le cas ou on rentre pas dans le boucle while.
            }
            else if (v.compareTo(prev.node) < 0) {
                prev.left = reste;
            } else {
                prev.right = reste;
            }
        }
        return true;
    }

    private void replace(Node<T> current) {
        Node<T> min = current.right;
        Node<T> prev = current;

        while(min.left != null) {
            prev = min;
            min = min.left;
        }
        if (prev == current) {
            prev.right = min.right;
        } else prev.left =min.right;
        current.node = min.node;
    }



//    public boolean remove(T v) {
//        if (this.isEmpty()) return false;
//        Node<T> current = this.root;
//        Node<T> prev = null;
//        int cmp;
//        while(current != null) {
//            cmp = v.compareTo(current.node);
////            current = cmp >= 0 ? current.right : current.left;
//            if (cmp > 0) {
//                prev = current;
//                current = current.right;
//            } else if (cmp < 0) {
//                prev =current;
//                current = current.right;
//            }
//
//            if (cmp == 0 && current.left == null && current.right == null && prev != null) {
//                if (v.compareTo(prev.node) > 0) {
//                    prev.right= null;
//                    return true;
//                }
//                if (v.compareTo(prev.node) < 0){
//                    prev.left = null;
//                    return true;
//                }
//            }
//
//            if (cmp == 0 && (current.left == null || current.right == null)) {
//                if (current.left == null && current.right != null) {
//                }
//            }
//
//        }
//        return false;
//    }

}


