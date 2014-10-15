package avlTree;

public class Main {
	
	public static void main(String[] args) {
		AvlTree t = new AvlTree();
		t.add(10);
		t.add(20);
		t.add(9);
		t.add(8);
		t.add(10);
		t.add(7);
		t.add(30);
		
		t.root.height = 3;
		t.root.left.height = 2;
		t.root.right.height = 1;
		t.root.left.left.height = 1;
		
		
		
		System.out.println(t);
		t.verifyAVLTree();
		
		System.out.print("Done");
	}

	
}
