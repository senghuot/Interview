public class Main {
	
	// Starting out easy
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1};
		System.out.println(getSmallest(array));
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
}