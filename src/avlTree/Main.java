package avlTree;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
      int[] data = {5, 10, 20, 30, 35, 40, 45, 50, 55};
		AvlTree t = new AvlTree(data);
      List<LinkedList<Integer>> r = t.createLevelList();
      
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
