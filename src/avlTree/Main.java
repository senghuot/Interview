package avlTree;

public class Main {
	
	public static void main(String[] args) {
      int[] data = {5, 10, 20, 30, 35, 40 , 50};
		AvlTree t = new AvlTree(data);
      t.root.right = null;
      System.out.print(t.balance());
      
	}
	
	public static boolean duplicate(String word) {
		
		int storage = 0;
		for (int i=0; i<word.length(); i++) {
			int amountToShift = word.charAt(i) - 'a';
			if ((storage & 1 << amountToShift) != 0)
				return false;
			else
				storage = storage | 1 << amountToShift;
		}
		return true;
	} 
}
