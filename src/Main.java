import java.util.*;

public class Main {
	
	// Starting out easy
	public static void main(String[] args) {
		System.out.println(permutation("a"));
	}

   // getting string permutation
   public static List<String> permutation(String str) {
      
      // base case 0
      if (str == null)
         return null;
      
      List<String> perm = new ArrayList<String>();   
      // base case 1
      if (str.length() == 0) {
         perm.add("");
         return perm;
      }
      
      char first = str.charAt(0);
      String remainder = str.substring(1);
      List<String> words = permutation(remainder);
      for (String word: words) {
         for (int j = 0; j <= word.length(); j++) {
            String s = insertCharAt(word, first, j);
            perm.add(s);
         }
      }
      
      return perm;
   }
   
   // insert char in the ith position
   private static String insertCharAt(String word, char c, int i) {
      String start = word.substring(0, i);
      String end = word.substring(i);
      return start + c + end;
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