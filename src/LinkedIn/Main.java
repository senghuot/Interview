package LinkedIn;

public class Main {

	public static void main(String[] args) {
	    int[] a = {1, 5, 14, 15};
	    int[] b = {3, 13};
	    
	    System.out.print(smallDiff(a, b));
	}

	// return if the given string is a number
	// another way of doing this is by using regex
	public boolean isNum(String string) { 
		 // base case where string is null
		 if (string == null)
		     return false;
		 
		 int i = 0;
		 // testing for signs
		 char first = string.charAt(0);
		 if ( first == '+' || first == '-')
		     i = 1;
		
		 // testing if the string contains only '. - +'
		 if (string.length() == 1 && (first == '.' || first == '+' || first == '-'))
		     return false;
		 
		 // testing if the string contains only '+. -.'
		 if (string.length() == 2 && (first == '+' || first == '-') && string.charAt(1) == '.')
		         return false;
		 
		 int periodCounter = 0;
		 for (; i<string.length(); i++) {
		     char tmp = string.charAt(i);
		     if (tmp == '.')
		         periodCounter++;
		         
		     // grab out the current character then return false if any of the char 
		     // doesnt fit into our acceptance range
		     if (!(tmp == '.' || (tmp >= '0' && tmp < '9')) || periodCounter == 2)
		         return false;
		 }
	 return true;
	}
	
	// the array is sorted in ascending order
	public static int smallDiff(int[] a, int[] b) {
		int res = Integer.MAX_VALUE;
		int ap = 0; // array a pointer
		int bp = 0; // array b pointer
		
		while (ap < a.length && bp < b.length) {
			int diff = Math.abs(a[ap] - b[bp]);
			res = Math.min(res, diff);
			if (a[ap] < b[bp])
				ap++;
			else
				bp++;
		}
		
		return res;
	}
}


