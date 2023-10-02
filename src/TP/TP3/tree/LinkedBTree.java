package TP.TP3.tree;

public class LinkedBTree<T> implements BinaryTree<T> {
	
	private static class Node<T> {
		T value;
		Node<T> left;
		Node<T> right;
		
		Node(T value, Node<T> left, Node<T> right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	private Node<T> root;
	
	private LinkedBTree(Node<T> r) {
		root = r;
	}
	
	public LinkedBTree() {
		this((Node<T>)null);
	}
	
	public LinkedBTree(T v) {
		this(new Node<>(v, null, null));
	}

	public LinkedBTree(T v, LinkedBTree<T> left, LinkedBTree<T> right) {
		this(new Node<>(v, left.root, right.root));
	}
	
	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public T getValue() {
		assert(!isEmpty());
		return root.value;
	}
	
	@Override
	public BinaryTree<T> getLeft() {
		assert(!isEmpty());
		return new LinkedBTree<>(root.left);
	}
	
	@Override
	public BinaryTree<T> getRight() {
		assert(!isEmpty());
		return new LinkedBTree<>(root.right);
	}
	
	public String toString() {
		return format();
	}
}
