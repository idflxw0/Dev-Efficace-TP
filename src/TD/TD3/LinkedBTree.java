package TD.TD3;

public class LinkedBTree<T> implements BTree{
    private static class Node<T> {
        T node;
        Node<T> left;
        Node<T> right;
        public  Node(T node) {
            this.node = node;
            this.left  = this.right = null;
        }
        public Node(T node, Node<T> left, Node<T> right) {
            this.node = node;
            this.left = left;
            this.right = right;
        }
    }
    private Node<T> root;
    public LinkedBTree() {
        this.root = null;
    }
    public LinkedBTree(T value) {
        this.root = new Node<>(value);
    }
    public LinkedBTree(T value, LinkedBTree<T> left, LinkedBTree<T> right) {
        this.root = new Node<>(value, left.root, right.root);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }
    @Override
    public Object getValue() {
        assert(!isEmpty());
        return root.node;
    }

    @Override
    public BTree<T> getLeft() {
       LinkedBTree<T> t = new LinkedBTree<>();
       t.root = this.root.left;
       return t;
    }

    @Override
    public BTree<T> getRight() {
        LinkedBTree<T> t = new LinkedBTree<>();
        t.root = this.root.right;
        return t;
    }


//    public int getTotal(BTree root){
//        if (root.isEmpty()) return 0;
//        return this.getTotal(root.getLeft()) + this.getTotal(root.getRight()) + 1;
//    }
    


    public static void main(String[] args) {
        BTree<Integer> a = new LinkedBTree<>(1,
                new LinkedBTree<>(2),
                new LinkedBTree<>(3,new LinkedBTree<>(4),new LinkedBTree<>()));
        System.out.println(a.getTotal());

        System.out.println(a.format());
    }
}
