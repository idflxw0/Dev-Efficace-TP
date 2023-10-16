package TP.TP5.tree;

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
		
	default int height() {
		if (isEmpty())
			return 0;
		return 1 + Math.max(getLeft().height(), getRight().height());
	}
	
	default int inbalance() {
		if (isEmpty())
			return 0;
		return getLeft().height() - getRight().height();
	}
	
	default boolean isBalanced() {
		if (isEmpty())
			return true;
		int hl = getLeft().height();
		int hr = getRight().height();
		if (Math.abs(hr - hl) > 1)
			return false;
		return getLeft().isBalanced() && getRight().isBalanced();
	}
	
	static final int INBALANCED = -1;
	default int isInbalancedOrHeight() {
		if (isEmpty())
			return 0; // balanced -> height
		int hl = getLeft().isInbalancedOrHeight();
		if (hl == INBALANCED)
			return INBALANCED; 
		int hr = getRight().isInbalancedOrHeight();
		if (hr == INBALANCED || Math.abs(hr - hl) > 1)
			return INBALANCED; 
		return 1 + Math.max(hl, hr); // balanced -> height
	}

	default boolean isBalancedOpt() {
		return isInbalancedOrHeight() != INBALANCED;
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
}