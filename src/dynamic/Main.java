package dynamic;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		System.out.println(permutation("abc"));
	}
	
	// generating subset
	public static List<String> permutation(String word) {
		
		// simple base case
		if(word == null)
			return null;
         
		// store the result
		List<String> res = new ArrayList<String>();
		
		if(word.length() == 0) {
			res.add(word);
			return res;
		}
		
		char first = word.charAt(0);
		String rest = word.substring(1);
		
		List<String> words = permutation(rest);
		for (String w: words) {
			for (int i = 0; i <= w.length(); i++) {
				
				// construct our new String
				String start = w.substring(0, i);
				String end = w.substring(i);
				
				String result = start + first + end;
				res.add(result); // done
			}
		}
		return res;
	} 
	
}