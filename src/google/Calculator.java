package google;

import java.util.Scanner;

public class Calculator {

	private String expression;
	private int index;
	
	public Calculator(String expression) {
		this.expression = expression;
		index = 0;
	}
	
	public void set(String expresstion) {
		reset();
		this.expression = expression;
	}
	
	public void reset() {
		expression = "";
		index = 0;
	}
	
	
	public int read() {
		if (index == expression.length())
			return 1;
		
		switch (expression.charAt(index++)) {
			case '*':
				return 4;
			case '+':
				return 3;
			default:
				return 2;
		}
	}
	
	public int getInt() {
		return expression.charAt(index - 1) - 48;
	}
	
}
