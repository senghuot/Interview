package ixl.test;

import static org.junit.Assert.*;
import ixl.StateUtils;

import org.junit.Test;

public class StateUtils3Test {

	@Test
	public void abbrLookup() {
		StateUtils s = new StateUtils();
		assertEquals(s.displayStateFullName("AL"), "Alabama");
		assertEquals(s.displayStateFullName("NH"), "New Hampshire");
		assertEquals(s.displayStateFullName("WA"), "Washington");
		assertEquals(s.displayStateFullName("WV"), "West Virginia");
		assertEquals(s.displayStateFullName("WY"), "Wyoming");
		
		// unknown lookup
		assertEquals(s.displayStateFullName("NOT VALID"), "Unknown");
	}

	@Test
	public void fullnameLookup() {
		StateUtils s = new StateUtils();
		assertEquals(s.parseSelectedState("Alabama"), "AL");
		assertEquals(s.parseSelectedState("New Hampshire"), "NH");
		assertEquals(s.parseSelectedState("Washington"), "WA");
		assertEquals(s.parseSelectedState("West Virginia"), "WV");
		assertEquals(s.parseSelectedState("Wyoming"), "WY");
		
		// unknown lookup
		assertEquals(s.parseSelectedState("NOT VALID"), "Unknown");
	}
	
	@Test
	public void createStringTest() {
		StateUtils s = new StateUtils();
		StringBuilder res = new StringBuilder();
		res.append("<select name=\"state\">\n");
		res.append("<option value=\"Alabama\">Alabama</option>\n");
		res.append("<option value=\"Alaska\">Alaska</option>\n");
		res.append("<option value=\"Arizona\">Arizona</option>\n");
		res.append("<option value=\"Arkansas\">Arkansas</option>\n");
		res.append("<option value=\"California\">California</option>\n");
		res.append("<option value=\"Colorado\">Colorado</option>\n");
		res.append("<option value=\"Connecticut\">Connecticut</option>\n");
		res.append("<option value=\"Delaware\">Delaware</option>\n");
		res.append("<option value=\"Florida\">Florida</option>\n");
		res.append("<option value=\"Georgia\">Georgia</option>\n");
		res.append("<option value=\"Hawaii\">Hawaii</option>\n");
		res.append("<option value=\"Idaho\">Idaho</option>\n");
		res.append("<option value=\"Illinois\">Illinois</option>\n");
		res.append("<option value=\"Indiana\">Indiana</option>\n");
		res.append("<option value=\"Iowa\">Iowa</option>\n");
		res.append("<option value=\"Kansas\">Kansas</option>\n");
		res.append("<option value=\"Kentucky\">Kentucky</option>\n");
		res.append("<option value=\"Louisiana\">Louisiana</option>\n");
		res.append("<option value=\"Maine\">Maine</option>\n");
		res.append("<option value=\"Maryland\">Maryland</option>\n");
		res.append("<option value=\"Massachusetts\">Massachusetts</option>\n");
		res.append("<option value=\"Michigan\">Michigan</option>\n");
		res.append("<option value=\"Minnesota\">Minnesota</option>\n");
		res.append("<option value=\"Mississippi\">Mississippi</option>\n");
		res.append("<option value=\"Missouri\">Missouri</option>\n");
		res.append("<option value=\"Montana\">Montana</option>\n");
		res.append("<option value=\"Nebraska\">Nebraska</option>\n");
		res.append("<option value=\"Nevada\">Nevada</option>\n");
		res.append("<option value=\"New Hampshire\">New Hampshire</option>\n");
		res.append("<option value=\"New Jersey\">New Jersey</option>\n");
		res.append("<option value=\"New Mexico\">New Mexico</option>\n");
		res.append("<option value=\"New York\">New York</option>\n");
		res.append("<option value=\"North Carolina\">North Carolina</option>\n");
		res.append("<option value=\"North Dakota\">North Dakota</option>\n");
		res.append("<option value=\"Ohio\">Ohio</option>\n");
		res.append("<option value=\"Oklahoma\">Oklahoma</option>\n");
		res.append("<option value=\"Oregon\">Oregon</option>\n");
		res.append("<option value=\"Pennsylvania\">Pennsylvania</option>\n");
		res.append("<option value=\"Rhode Island\">Rhode Island</option>\n");
		res.append("<option value=\"South Carolina\">South Carolina</option>\n");
		res.append("<option value=\"South Dakota\">South Dakota</option>\n");
		res.append("<option value=\"Tennessee\">Tennessee</option>\n");
		res.append("<option value=\"Texas\">Texas</option>\n");
		res.append("<option value=\"Utah\">Utah</option>\n");
		res.append("<option value=\"Vermont\">Vermont</option>\n");
		res.append("<option value=\"Virginia\">Virginia</option>\n");
		res.append("<option value=\"Washington\">Washington</option>\n");
		res.append("<option value=\"West Virginia\">West Virginia</option>\n");
		res.append("<option value=\"Wisconsin\">Wisconsin</option>\n");
		res.append("<option value=\"Wyoming\">Wyoming</option>\n");
		res.append("</select>\n");
		
		assertEquals(s.createStateSelectList(), res.toString());
	}
}
