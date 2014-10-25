public class Main {
	
	// Starting out easy
	public static void main(String[] args) {
		String word = "Haealo";
		System.out.println(isUnique(word));
	}
	
	// Return the smallest number in an integer array
	public static int getSmallest(int[] array) {
		if (array.length == 0)
			throw new IllegalArgumentException("You passed an empty array.");
		
		int smallest = array[0];
		for(int i = 1; i < array.length; i++) {
			smallest = Math.min(smallest, array[i]);
		}
		return smallest;
	}
	
	// Return the largest number in an integer array
	public static int getLargest(int[] array) {
		if (array.length == 0)
			throw new IllegalArgumentException("You passed an empty array.");
		
		int largest = array[0];
		for(int i = 1; i < array.length; i++) {
			largest = Math.min(largest, array[i]);
		}
		return largest;
	}
	
	// unique character in String
	public static boolean isUnique(String word) {
		int[] chars = new int[256];
		for(int i = 0; i < word.length(); i++) {
			int index = word.charAt(i);
			chars[index]++;
			if(chars[index] > 1)
				return false;
		}
		
		return true;
	}
	
	
}