package TP.TP5.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinkedBSTreeEquiped<T extends Comparable<T>> extends LinkedBSTree<T> {
	private static class NodeEq<T> extends Node<T> {
		int inbalance;

		NodeEq(T value) {
			super(value, null, null);
			inbalance = 0;
		}
	}

	public int getInbalance() {
		return root == null ? 0 : ((NodeEq<T>) root).inbalance;
	}

	@Override
	public void add(T v) {
		NodeEq<T> current = (NodeEq<T>)root;
		int cmp = 0;
		LinkedList<NodeEq<T>> path = new LinkedList<>();
		while (current != null) {
			path.push(current);
			cmp = current.value.compareTo(v);
			current = (NodeEq<T>)(cmp > 0 ? current.left : current.right);
		}
		NodeEq<T> n = new NodeEq<>(v);
		if (path.isEmpty())
			root = n;
		else if (cmp > 0)
			path.peek().left = n;
		else
			path.peek().right = n;

		//Mettre à jour les champs inbalance des sommets présents dans le path
		while(!path.isEmpty()) {
			 current = path.pop();
			 cmp = current.value.compareTo(v);
			 if (cmp > 0) {
				 ++current.inbalance;
				 if (current.inbalance <= 0)
					 break;
			 } else {
				 --current.inbalance;
				 if (current.inbalance >= 0)
					 break;
			 }


		}
	}
	// On se limite à la méthode add(). La solution pour la méthode remove() sera dans le corrigé.  	
	@Override
	public boolean remove(T v) {
		throw new UnsupportedOperationException();
	}

	public static LinkedBSTreeEquiped<Integer> generate(int n) {
		List<Integer> values = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
		Collections.shuffle(values);
		LinkedBSTreeEquiped<Integer> t = new LinkedBSTreeEquiped<>();
		for (int i : values)
			t.add(i);
		return t;
	}

	private static <T> boolean checkInbalance(NodeEq<T> n) {
		if (n != null) {
			LinkedBTree<T> t = new LinkedBTree<>();
			t.root = n;
			if (n.inbalance != t.inbalance())
				return false;
			if (!checkInbalance((NodeEq<T>)(n.left)))
				return false;
			if (!checkInbalance((NodeEq<T>)(n.right)))
				return false;
		}
		return true;
	}
	
	public boolean deepCheckInbalance() {
		return checkInbalance((NodeEq<T>)root);		
	}
}
