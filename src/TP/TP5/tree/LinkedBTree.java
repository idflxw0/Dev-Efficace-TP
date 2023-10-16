package TP.TP5.tree;

import java.util.Random;

public class LinkedBTree<T> implements BinaryTree<T> {
	
	protected static class Node<T> {
		T value;
		Node<T> left;
		Node<T> right;
		
		Node(T value, Node<T> left, Node<T> right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	protected Node<T> root;
	
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

	private static final Random r = new Random();
	private void insertLeafRandomly(T v) {
		if (root == null)
			root = new Node<>(v, null, null);
		else {
			if (r.nextBoolean()) {
				if (root.left == null)
					root.left = new Node<>(v, null, null);
				else
					((LinkedBTree<T>)getLeft()).insertLeafRandomly(v);
			}
			else
				if (root.right == null)
					root.right = new Node<>(v, null, null);
				else
					((LinkedBTree<T>)getRight()).insertLeafRandomly(v);
		}
	}
	
	public static LinkedBTree<Integer> generate(int n) {
		LinkedBTree<Integer> t = new LinkedBTree<>();
		for (int i = 1; i <= n; ++i)
			t.insertLeafRandomly(i);
		return t;
	}
}
