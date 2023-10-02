package TP.TP3.tree;

public interface BinaryTree<T> {
	boolean isEmpty();
	T getValue();
	BinaryTree<T> getLeft();
	BinaryTree<T> getRight();
	
	default int size() {
		if (isEmpty())
			return 0;
		return 1 + getLeft().size() + getRight().size();
	}
	
	default void format(StringBuilder sb) {
		if (isEmpty())
			sb.append("<>");
		else {
			sb.append("<" + getValue());
			BinaryTree<T> left = getLeft();
			BinaryTree<T> right = getRight();
			if (!left.isEmpty() || !right.isEmpty()) {
				sb.append(", ");
				left.format(sb);
				sb.append(", ");
				right.format(sb);
			}
			sb.append(">");
		}
	}

	default String format() {
		StringBuilder sb = new StringBuilder();
		format(sb);
		return sb.toString();
	}

	default int maxDepth(BinaryTree<T> root) {
		if (root.isEmpty()) return 0;
		return 1+ Math.max(maxDepth(root.getLeft()),maxDepth(root.getRight()));
	}



}