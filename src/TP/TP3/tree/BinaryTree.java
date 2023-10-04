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

	default int maxDepth() {
		if (this.isEmpty()) return 0;
		return 1+ Math.max(this.getLeft().maxDepth(),this.getLeft().maxDepth());
	}

	default int maxDepth(BinaryTree<T> root) {
		if (root.isEmpty()) return 0;
		return 1+ Math.max(maxDepth(root.getLeft()),maxDepth(root.getRight()));
	}

	default int unbalancedTree(){
		if (this.isEmpty()) return 0;
		return this.getLeft().maxDepth() - this.getRight().maxDepth();
	}
	default int unbalancedTree(BinaryTree<T> root){
		if (root.isEmpty()) return 0;
		return maxDepth(root.getLeft()) - maxDepth(root.getRight());
	}

	default boolean isbalanced() {
		if (this.isEmpty()) return false;
		if (this.unbalancedTree() > 1 || this.unbalancedTree() < -1) return false;
		//this.unbalancedTree() > 1 || this.unbalancedTree() < -1
		// 0 || -1
		return this.getLeft().isbalanced() && this.getRight().isbalanced();
	}

	default int isBalanceOrHeight(){
		if (this.isEmpty()) return 0;
		int hl = this.getLeft().isBalanceOrHeight();
		if (hl == -1) return -1;
		int hr = this.getRight().isBalanceOrHeight();
		if (hr == -1) return -1;
		if (Math.abs(hl-hr) > 1) return -1;
		return Math.max(hl,hr) + 1;
	}

}