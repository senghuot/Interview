package LinkedIn;

public class Main {

	public static void main(String[] args) {
	    System.out.println("921");
	}

	// TODO: spends lots of time with this
	
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
}


