package TP.TP5.appli;

import TP.TP5.tree.LinkedBSTreeEquiped;

public class Appli {
	public static void main(String[] args) {
		LinkedBSTreeEquiped<Integer> t = new LinkedBSTreeEquiped<>();
		System.out.println(t + " (" + t.inbalance() + ", " + t.getInbalance() + ")");

		int[] val = { 20, 10, 30, 27 , 28 };
		for (int v : val) {
			t.add(v);
			System.out.println(v + " : " + t + " (" + t.inbalance() + ", " + t.getInbalance() + ")");
		}
		
		if (!t.deepCheckInbalance())
			System.out.println("PROBLEME");
	}
}
