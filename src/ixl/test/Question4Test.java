package ixl.test;

import static org.junit.Assert.*;
import ixl.Question4;

import org.junit.Test;

public class Question4Test {

	@Test(expected = IllegalArgumentException.class)
	public void edgeCasesTest() {
		// null input string
		Question4.wrapText(null, 1);
		// input max zero
		Question4.wrapText("", 0);
	}
	
	@Test
	public void oneSetenceTest() {
		// input: "Hello World."; 20;
		// output: "Hello World."
		String input = "Hello World.";
		assertEquals(Question4.wrapText(input, 20), "Hello World.");
		
		// input: "Hello World."; 10;
		// output: "Hello/nWorld."
		assertEquals(Question4.wrapText(input, 10), "Hello\nWorld.");
	}
	
	@Test
	public void multipleSpacesTest() {
		// input: "Hello     World."; 20;
		// output: "Hello World."
		String input = "Hello     World.";
		assertEquals(Question4.wrapText(input, 20), "Hello World.");
		
		input = "   " + input + "   ";
		assertEquals(Question4.wrapText(input, 20), "Hello World.");
	}
	
	@Test
	public void multipleNewlinesTest() {
		// input: "Hello\nWorld."; 20;
		// output: "Hello\nWorld."
		String input = "Hello\nWorld.";
		assertEquals(Question4.wrapText(input, 20), "Hello\nWorld.");
		
		// input: "Hello\n\n\nWorld."; 20;
		// output: "Hello\n\n\nWorld."
		String input2 = "Hello\n\n\nWorld.";
		assertEquals(Question4.wrapText(input2, 20), "Hello\n\n\nWorld.");
	}
	
	@Test
	public void maxCharsPerLineTest() {
		// input: "optimistic"; 5;
		// output: "optim\nistic\n"
		String input = "optimistic";
		assertEquals(Question4.wrapText(input, 5), "optim\nistic\n");
		
		// since "ism" is only three character count so there no need for newline yet because
		// we could potentially fit more characters.
		// input: "optimisticism"; 5;
		// output: "optim\nistic\nism"
		String input2 = "optimisticism";
		assertEquals(Question4.wrapText(input2, 5), "optim\nistic\nism");
	}
	
}
