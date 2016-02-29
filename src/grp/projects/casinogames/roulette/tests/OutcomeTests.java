package grp.projects.casinogames.roulette.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import grp.projects.casinogames.roulette.Outcome;

public class OutcomeTests {

	@Test
	public void testAreEqual() {
		//2 objects same name, should be equal
		Outcome o1 = new Outcome("Black", 2);
		Outcome o2 = new Outcome("Black", 2);
		assertEquals(o1, o2);
	}
	
	@Test
	public void testAreNotEqual() {
		//2 objects, different names, should not be equal
		Outcome o1 = new Outcome("Black", 2);
		Outcome o2 = new Outcome("Red", 2);
		//No assertNotEqual in Junit
		assertTrue(o1!=o2);
	}
	
	@Test
	public void testEqualHashCode(){
		//2 objects same name, should have same hashCode
		Outcome o1 = new Outcome("Black", 2);
		Outcome o2 = new Outcome("Black", 2);
		assertEquals(o1.hashCode(), o2.hashCode());
	}
	
	@Test
	public void testNotEqualHashCode() {
		//2 objects different names, should have different hashCodes
		Outcome o1 = new Outcome("Black", 2);
		Outcome o2 = new Outcome("Red", 2);
		assertTrue(o1.hashCode()!=o2.hashCode());
	}
	
	@Test
	public void testWinAmount() {
		//Tests the calculation of the win amount works as expected
		Outcome o1 = new Outcome("Black", 2);
		assertEquals(2000, o1.winAmount(1000)); //2:1 odds
		
		Outcome o2 = new Outcome("30", 35);
		assertEquals(35000, o2.winAmount(1000)); //35:1 odds
	}

}
