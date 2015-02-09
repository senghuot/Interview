public class Main {
	
	// Starting out easy
	public static void main(String[] args) {
     char[][] rec = {{'a', 'b', 'c', 'd'}, {'e','f','g','h'}, {'l','m','n','o'}, {'k','x','y','z'}};
     System.out.println(printArray(rec));
     rotate90(rec);
     System.out.println(printArray(rec));
	}
	
	public static String printArray(char[][] rec) {
		String res = "";
		for (int i=0; i<rec.length; i++) {
			for (int j=0; j<rec.length; j++) {
				res += " " + rec[i][j];
			}
			res += "\n";
		}
		
		return res;
	}
	
	public static void rotate90(char[][] rec) {
		int n = rec.length;
		for (int i=0; i<n/2; i++) {
			char[] cache = new char[n-i-i];
			
			// Cache the one array firrst
			int counter = 0;
			for (int j=i; j < n-i; j++)
				cache[counter++] = rec[i][j];
			
			// Replace right
         counter = 0;
			for (int j=0; j<cache.length; j++) {
				char tmp = rec[i+j][n-1-i];
				rec[i+j][n-1-i] = cache[counter];
				cache[counter++] = tmp;
			}
			
			// Replace bottom
         counter = cache.length - 1;
         char last = cache[counter];
			for (int j=i; j<n-i; j++) {
				char tmp = rec[n-1-i][j];
            rec[n-1-i][j] = cache[counter];
            cache[counter--] = tmp;
			}
         cache[++counter] = last;
         
			// Replace left
         counter = cache.length - 1;
         last = cache[counter];
 			for (int j=i; j<n-i; j++) {
 				char tmp = rec[j][i];
             rec[j][i] = cache[counter];
             cache[counter--] = tmp;
 			}
         cache[++counter] = last;
         
         // Replace top
         counter = cache.length - 1;
         for (int j=i; j<n-i; j++) {
            rec[i][n-1-j] = cache[counter--];
         }
		}
	}
	
   
	public static int countWay(int n) {
		if (n == 0)
			return 1;
   	 	if (n < 0)
   	 		return 0;
   	 	return countWay(n - 1) + countWay(n - 2)  + countWay(n -3);
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
	
	// assuming that whitespaces and case sensitive
	public static boolean permutation(String w1, String w2) {
		// if the two word aint the same then they can't be a permutation of
		// each other
		if(w1.length() != w2.length())
			return false;
		
		// building up a stock of characters
		int[] chars = new int[256];
		for(int i = 0; i < w1.length(); i++)
			chars[w1.charAt(i)]++;
			
		for(int i = 0; i < w2.length(); i++) {
			int index = w2.charAt(i);
			chars[index]--;
			if(chars[index] < 0)
				return false;
		}

		return true;
	}
	
	// binary search
	public static boolean binarySearch(int[] arr, int x) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (high - low) / 2 + low;
			if (arr[mid] > x) {
				// move the low
				high = mid -1;
			} else if (arr[mid] < x) {
				// move the high
				low = mid + 1;
			} else {
				return true;
			}
		}
		return false;
	}
	
}