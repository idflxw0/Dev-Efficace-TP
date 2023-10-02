package TP.TP3.tree;

// exo 1
public class LinkedBTreeOpt<T> implements BinaryTree<T> {
	
	private T value;
	private LinkedBTreeOpt<T> left;
	private LinkedBTreeOpt<T> right;
	
	private LinkedBTreeOpt() {
		value = null;
		left = right = null;
	}

	private static final LinkedBTreeOpt<?> EMPTY = new LinkedBTreeOpt<>();
	
	@SuppressWarnings("unchecked")
	public static <T> LinkedBTreeOpt<T> empty() {
		return (LinkedBTreeOpt<T>) EMPTY;
	}
	
	
	@SuppressWarnings("unchecked")
	public LinkedBTreeOpt(T v) {
		value = v;
		left = right = (LinkedBTreeOpt<T>) EMPTY;
	}

	public LinkedBTreeOpt(T v, LinkedBTreeOpt<T> left, LinkedBTreeOpt<T> right) {
		if (left == null || right == null)
			throw new NullPointerException();
		value = v;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public boolean isEmpty() {
		return this == EMPTY;
	}

	@Override
	public T getValue() {
		if (isEmpty()) 
			throw new IllegalStateException();
		return value;
	}
	
	@Override
	public BinaryTree<T> getLeft() {
		if (isEmpty()) 
			throw new IllegalStateException();
		return left;
	}
	
	@Override
	public BinaryTree<T> getRight() {
		if (isEmpty()) 
			throw new IllegalStateException();
		return right;
	}
	
	public String toString() {
		return format();
	}

	public static <T> LinkedBTreeOpt<T> convert(BinaryTree<T> t) {
		if (t.isEmpty())
			return LinkedBTreeOpt.empty();
		BinaryTree<T> left = t.getLeft();
		BinaryTree<T> right = t.getRight();
		if (left.isEmpty() && right.isEmpty())
			return new LinkedBTreeOpt<>(t.getValue());
		return new LinkedBTreeOpt<>(t.getValue(), convert(left), convert(right));
	}
}
