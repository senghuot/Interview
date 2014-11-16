package LinkedIn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* This class will be given a list of words (such as might be tokenized
* from a paragraph of text), and will provide a method that takes two
* words and returns the shortest distance (in words) between those two
* words in the provided text. 
* Example:
*   WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick"));
*   assert(finder.distance("fox","the") == 3);
*   assert(finder.distance("quick", "fox") == 1);
*/
public class WordDistanceFinder {
 
	private Map<String, List<Integer>> index; 
 
	public WordDistanceFinder (List<String> words) {
	    index = new HashMap<String, List<Integer>>();
	    int counter = 0;
	    for (String w: words) {
	        // in case the key haven't been added yet.
	        if (!index.containsKey(w))
	            index.put(w, new ArrayList<Integer>());
	        index.get(w).add(counter++);
	    }    
	 }

	 public int distance (String wordOne, String wordTwo) {
	     // base case where words cant be found
	     if (!index.containsKey(wordOne) || !index.containsKey(wordTwo))
	         return -1;
	     
	     int distance = Integer.MAX_VALUE;
	     List<Integer> l1 = index.get(wordOne);
	     List<Integer> l2 = index.get(wordTwo); 
	     int p1 = 0;
	     int p2 = 0;
	     
	     while (p1 < l1.size() && p2 < l2.size()) {
	         // updates the distance 
	         distance = Math.min(Math.abs(p1 - p2), distance);
	             
	         // move pointers
	         if (l1.get(p1) < l2.get(p2))
	             p1++;
	         else if (l2.get(p1) > l1.get(p2))
	             p2++;
	         else
	             return distance;
	     }
	
	     return distance;
	 }
}
