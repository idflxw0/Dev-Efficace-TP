package TD.TD4;

public class Appli {
	public static void main(String[] args) {
		LinkedBSTree<Integer> t = new LinkedBSTree<>();
		System.out.println(t);
		
		t.add(22);
		System.out.println(t);

		t.add(12);
		System.out.println(t);
		
		t.add(18);
		System.out.println(t);
		
		t.add(6);
		System.out.println(t);
	}

}
