package TP.TP5.tree;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinkedBSTree<T extends Comparable<T>> extends LinkedBTree<T> implements BinarySearchTree<T> {
	@Override
	public boolean contains(T v) {
		Node<T> current = root;
		int cmp = 0;
		while (current != null && (cmp = current.value.compareTo(v)) != 0)
			current = cmp > 0 ? current.left : current.right;
		return current != null;
	}

	@Override
	public void add(T v) {
		Node<T> current = root;
		Node<T> previous = null;
		int cmp = 0;
		while (current != null) {
			cmp = current.value.compareTo(v);
			previous = current;
			current = cmp > 0 ? current.left : current.right;
		}
		Node<T> n = new Node<>(v, null, null);
		if (previous == null)
			root = n;
		else if (cmp > 0)
			previous.left = n;
		else
			previous.right = n;
	}

	@Override
	public boolean remove(T v) {
		Node<T> current = root;
		Node<T> previous = null;
		int cmp;
		while (current != null && (cmp = current.value.compareTo(v)) != 0) {
			previous = current;
			current = cmp > 0 ? current.left : current.right;
		}
		if (current == null)
			return false;
		if (current.left != null && current.right != null)
			replace(current);
		else {
			Node<T> pending = current.left == null ? current.right : current.left;
			if (previous == null)
				root = pending;
			else if (previous.left == current)
				previous.left = pending;
			else
				previous.right = pending;
		}
		return true;
	}

	private static <T> void replace(Node<T> current) {
		Node<T> previous = current;
		Node<T> min = current.right;
		while (min.left != null) {
			previous = min;
			min = min.left;
		}
		if (previous == current)
			current.right = min.right;
		else
			previous.left = min.right;
		current.value = min.value;
	}

	public static LinkedBSTree<Integer> generate(int n) {
		List<Integer> values = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
		Collections.shuffle(values);
		LinkedBSTree<Integer> t = new LinkedBSTree<>();
		for (int i : values)
			t.add(i);
		return t;
	}
}
