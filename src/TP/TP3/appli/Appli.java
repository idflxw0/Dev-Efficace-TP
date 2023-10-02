package TP.TP3.appli;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import TP.TP3.tree.*;

public class Appli {
	public static void main(String[] args) {
		LinkedBTree<Integer> empty = new LinkedBTree<>();
		System.out.println(empty + " (" + empty.size() + ")");
		LinkedBTreeOpt<Integer> tr = LinkedBTreeOpt.convert(empty);
		System.out.println(tr + " (" + tr.size() + ")" + " (" + tr.maxDepth(tr) +")");
		
		LinkedBTree<Integer> t = new LinkedBTree<>(5);
		System.out.println(t + " (" + t.size() + ")" + " (" + tr.maxDepth(tr) +")");
		tr = LinkedBTreeOpt.convert(t);
		System.out.println(tr + " (" + tr.size() + ")" + " (" + tr.maxDepth(tr) +")");

		
		t = new LinkedBTree<>(2, new LinkedBTree<>(7), new LinkedBTree<>(2));
		System.out.println(t + " (" + t.size() + ")" + " (" + tr.maxDepth(tr) +")");
		tr = LinkedBTreeOpt.convert(t);
		System.out.println(tr + " (" + tr.size() + ")" + " (" + tr.maxDepth(tr) +")");
		
		t = new LinkedBTree<>(3, empty, t);
		System.out.println(t + " (" + t.size() + ")" + " (" + tr.maxDepth(tr) +")");
		tr = LinkedBTreeOpt.convert(t);
		System.out.println(tr + " (" + tr.size() + ")" + " (" + tr.maxDepth(tr) +")");
		
		t = getRandomTree(10);
		System.out.println(t + " (" + t.size() + ")" + " (" + tr.maxDepth(tr) +")");
		tr = LinkedBTreeOpt.convert(t);
		System.out.println(tr + " (" + tr.size() + ")");
	}

	private static Random r = new Random();

	private static LinkedBTree<Integer> getRandomTree(int n) {
		List<Integer> values = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
		Collections.shuffle(values);
		LinkedBTree<Integer> empty = new LinkedBTree<>();
		LinkedBTree<Integer> a = empty;
		for (Integer i : values)
			if (a.isEmpty())
				a = new LinkedBTree<>(i);
			else {
				int c = r.nextInt(4);
				switch (c) {
				case 0 : 
					a = new LinkedBTree<>(i, a, empty); 
					break;
				case 1 : 
					a = new LinkedBTree<>(i, empty, a); 
					break;
				case 2 : 
					a = new LinkedBTree<>(i, 
							new LinkedBTree<>(a.getValue(), (LinkedBTree<Integer>)a.getLeft(), empty), 
							(LinkedBTree<Integer>)a.getRight()); 
						break;
				default : // case 3 
					a = new LinkedBTree<>(i, 
							(LinkedBTree<Integer>)a.getLeft(), 
							new LinkedBTree<>(a.getValue(), empty, (LinkedBTree<Integer>)a.getRight())); 
						break;
				}
			}
		return a;
	}
}
