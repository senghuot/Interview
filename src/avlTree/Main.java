package avlTree;

public class Main {
	
	public static void main(String[] args) {
		System.out.println(duplicate("hello"));
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
