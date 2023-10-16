package TP.TP5.tree;

public interface BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
	void add(T v);
	boolean remove(T v);
	boolean contains(T v);
}
