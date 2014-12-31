package ixl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// There are some rooms for improvement in the previous given codes for StateUtils.
// There are lots of redundant codes, which make maintaining a bit harder.
// For example, pareSelectedStates & displayStateFullName methods each used to have 50 “if”
// statements. Each time you call of those methods, the worst case would have a running time 
// of would be O(50). We can improve it by introducing HashMaps. Assume HashMap have a good hash
// function each operation should be O(1). Therefore we could cut down 49 unnecessarily operations. 
//
// createStatementSelectList method should be utilize StringBuilder and our previous HashMaps. 
// Instead of writing out all the state name. I think it might be more efficient to iterate over our
// HashMap. This should help reduce human errors especially when one have to write out 50 state names.
//
// Lastly, I think it might be easier to pipe all the state information from a text into our 
// HashMap through parsing over a text file. Also, I think its a more suitable to split the logic 
// from the input information and gives our codes more flexible when we need to make changes to state name
// in the future.


public class StateUtils {	
	// store your file in relative directory
	public static final String FILENAME = "src/ixl/States.txt";
	private Map<String, String> abbrToFull;
	private Map<String, String> fullToAbbr;
	
	/**
	 * constructor, cache fullname to abbreviation bi-directionally via HashMaps.
	 */
	public StateUtils() {
		abbrToFull = new TreeMap<String, String>();
		fullToAbbr = new TreeMap<String, String>();
		try {
			Scanner console = new  Scanner(new File(FILENAME));
			while(console.hasNextLine()) {
				String[] token = console.nextLine().split("\t");
				String abbr = token[1];
				String full = token[0];
				
				abbrToFull.put(abbr, full);
				fullToAbbr.put(full, abbr);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}
	
	/**
	 * @return produce HTML select with state fullname
	 */
	public String createStateSelectList() {
		StringBuilder res = new StringBuilder();
		
		res.append("<select name=\"state\">\n");
		for (String key: fullToAbbr.keySet()) {
			res.append("<option value=\""+ key + "\">" + key + "</option>\n");
		}
		
		res.append("</select>\n");
	    return res.toString();
	}
	
	/**
	 * @param s, state fullname
	 * @return abbreviation based on param s, iff found. Otherwise, return "Unknown". 
	 */
	public String parseSelectedState(String s) {
		if (!fullToAbbr.containsKey(s))
			return "Unknown";
		return fullToAbbr.get(s);
	}
  
	/**
	 * @param abbr, state abbreviation
	 * @return state fullname based on param abbr, iff found.
	 * 			Otherwise, return "Unknown" 
	 */
	public String displayStateFullName(String abbr) {
		if (!abbrToFull.containsKey(abbr))
			return "Unknown";
		return abbrToFull.get(abbr);
	}  
}
