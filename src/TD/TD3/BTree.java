package TD.TD3;

public interface BTree<T> {
    boolean isEmpty();
    T getValue();
    BTree<T> getLeft();
    BTree<T> getRight();
    default int getTotal(){
        if(isEmpty()) return 0;
        return 1 + getLeft().getTotal() + getRight().getTotal();
    }
   default String format() {
        if (isEmpty()) return "<>";
        BTree<T> left = getLeft();
        BTree<T> right = getRight();
        if (left.isEmpty() && right.isEmpty()) return "<" + getValue() + ", " + left.format() + ", " + right.format() + ">";
        return "<" + getValue() + ", " + getLeft().format() + ", " + getRight().format() + ">";
   }
}
