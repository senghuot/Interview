package ixl;

import java.util.*;

//QUESTION #2:

//Write a Java method that takes an array of "sets" of String objects,
//and determines whether _all_ sets in the array are equivalent.

//Each "set" in the input array is represented as an array of String objects, in 
//no particular order, and possibly containing duplicates. Nevertheless, when
//determining whether two of these "sets" are equivalent, you should disregard
//order and duplicates. For example, the sets represented by these arrays are
//all equivalent:

//{"a", "b"}
//{"b", "a"}
//{"a", "b", "a"}

//The signature for your method should be:

//public static boolean allStringSetsIdentical(String[ ][ ] sets)

//Examples of the method in operation:

//allStringSetsIdentical(new String[][] {{"a","b"},{"b","b","a"},{"b","a"}})
//returns true

//allStringSetsIdentical(new String[][] {{"a","b"},{"a"},{"b"}}) returns false

public class Question2 {
	public static boolean allStringSetsIdentical(String[][] sets) {
		if(sets == null)
			throw new IllegalArgumentException("Invalid input.");
		
		if (sets.length < 2)
			return true;
		
		// reading up on sets
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < sets[0].length; i++)
			set.add(sets[0][i]);

		Set<String> tmpSet = new HashSet<String>();
		for (int i = 1; i < sets.length; i++) {
			for (int j = 0; j < sets[i].length; j++) {
				tmpSet.add(sets[i][j]);
			}
			// compare really quick
			if (!set.equals(tmpSet))
				return false;
			tmpSet.removeAll(set);
		}
		
		return true;
	}
}
