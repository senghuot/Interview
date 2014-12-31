package ixl;

//QUESTION #4:
//
//Write a Java method with the following method signature that takes a String and
//returns a String formatted so that it satisfies the requirements below.  It may
//need to insert newlines and/or delete spaces.
//
//Method Signature:
//public static String wrapText(String text, int maxCharsPerLine)
//
//Definitions and Assumptions:
//A word is a nonempty sequence of characters that contains no spaces and no newlines.
//Lines in the return String are separated by the newline character, '\n'.
//Words on each line are separated by spaces. Assume that the String argument does
//not contain any whitespace characters other than spaces and newlines.
//
//Requirements:
//1. Newlines in the String argument are preserved.
//
//2. Words in the return String are separated by either a single space or by one or
//more newlines.
//
//3. Lines in the return String do not start or end with any spaces.
//
//4. When constructing the return String from the String argument, each word in the 
//String argument with at most maxCharsPerLine characters should not be broken up. 
//Each word in the String argument with more than maxCharsPerLine characters should 
//be broken up so that all of the other requirements are satisfied.
//
//5. The String argument may contain lines longer than maxCharsPerLine. Newlines
//should be added so that each line in the return String has at most maxCharsPerLine
//characters. To determine where newlines should be added, try to fit as many words
//as possible on a line (while keeping line length at most maxCharsPerLine and
//satisfying the other requirements) before starting a new line.

import java.util.*;

public class Question4 {
	/**
	 * To reformatted a given paragraph
	 * @param text, a paragraph to be formatted
	 * @param maxCharsPerLine, number of maximum characters permitted in a sentence
	 * @throw IllegalArgumentException iff string input is null or
	 * 			 max is less than 1 
	 * @return formatted paragraph
	 */
	public static String wrapText(String text, int maxCharsPerLine) {
      if (text == null || maxCharsPerLine < 1)
         throw new IllegalArgumentException("Invalid inputs.");

      // split out the sentences from the paragraph.
      StringBuilder res = new StringBuilder();
      String[] sentences = text.split("\n");
      for (int i = 0; i < sentences.length; i++) {
         if (i > 0) res.append("\n");
         res.append(reformatSentence(sentences[i], maxCharsPerLine));
      }
      return res.toString();
	}
   
	/**
	 * reformat a sentence based on the rules given from requirment 1-5.
	 * @param sentence to be formatted
	 * @param max, maximum number of characters per sentence
	 * @return newly formatted sentence
	 */
	private static String reformatSentence(String sentence, int max) {
		// assuming that we're done checking edge cases.
		StringBuilder res = new StringBuilder();
		String[] words = sentence.split(" ");
		int count = -1; // remove initial space
		for(int i = 0; i < words.length; i++) {         
			int wordLen = words[i].length();
			// skip out white mutliple consecutive spaces
			if (wordLen == 0) continue;
         
			// add an extra space to accomudate for a space
			if (count + wordLen + 1 <= max) {
				if (count > -1) res.append(" ");
				res.append(words[i]);
				count += 1 + wordLen;
           
			// check if word is longer than max 
			} else if (wordLen > max) {
				Queue<String> q = splitString(words[i], max);
				// deqeue than append accordingly
				while (!q.isEmpty()) {
					String str = q.remove();
					if (str.length() == max) {
						res.append(str + "\n");
						count = -1;
					} else {
						res.append(str);
						count = str.length();
					}
				}
				count = -1;
			} else {
				res.append("\n");
				i--; // look at the current word again 
				count = -1;
			}
		}
		// return final result
		return res.toString();
	}
   
	/**
	 * helper method to break up a word based on max character count.
	 * @param text, a word to be broken up.
	 * @param max, max character count per word.
	 * @return a queue of words after broken up a longer word based on max.
	 */
	private static Queue<String> splitString(String text, int max) {
		Queue<String> res = new LinkedList<String>();
		for (int i = 0; i <= text.length() / max; i++) {
			int startIndex = i * max;
			int endIndex = Math.min((i + 1) * max, text.length());
			res.add(text.substring(startIndex, endIndex));
		}
		return res;
	}
}
