package TD.TD4;

import TD.TD3.BTree;
import TD.TD3.LinkedBTree;

public interface BinarySearchTree<T> extends BTree<T> {
        void add(T v);
        boolean contains (T v);
        boolean remove(T v);

}
