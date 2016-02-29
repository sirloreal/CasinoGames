package grp.projects.casinogames.roulette.tests;

import static org.junit.Assert.*;

import grp.projects.casinogames.roulette.*;

import org.junit.Test;

public class BinTests {

	@Test
	public void testAddOutcomeToBin() {
		
		//Create some Outcomes
		Outcome doubleZero = new Outcome("00-0-1-2-3", 6);
		Outcome twelve = new Outcome("12", 35);
		Outcome eleven = new Outcome("11", 35);
		Outcome red = new Outcome("Red", 2);
		Outcome black = new Outcome("Black", 2);
		Outcome firstTwelve = new Outcome("firstTwelve", 3);
		
		//Add them to the bin
		Bin b1 = new Bin();
		b1.add(doubleZero);
		b1.add(twelve);
		b1.add(red);
		b1.add(firstTwelve);		
		
		//Verify that the bin was created with 4 items
		assertTrue(4 == b1.size());
		
		//Verify that the bin has the outcomes in
		assertTrue(b1.contains(doubleZero));
		assertTrue(b1.contains(twelve));
		assertTrue(b1.contains(red));
		assertTrue(b1.contains(firstTwelve));
		
		//Now do another!
		Bin b2 = new Bin();
		b2.add(eleven);
		b2.add(black);
		b2.add(firstTwelve);
		
		//Verify that the bin was created with 3 items
		assertTrue(3 == b2.size());
		
		//Verify that the bin has the outcomes in
		assertTrue(b2.contains(eleven));
		assertTrue(b2.contains(black));
		assertTrue(b2.contains(firstTwelve));
	}

}
