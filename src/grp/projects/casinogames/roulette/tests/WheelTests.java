package grp.projects.casinogames.roulette.tests;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.Test;

import grp.projects.casinogames.roulette.Bin;
import grp.projects.casinogames.roulette.Outcome;
import grp.projects.casinogames.roulette.Wheel;

public class WheelTests {

	@Test
	public void testCreateWheel() {
		//Create a wheel - don't care about seeding right now
		Wheel wheel = new Wheel(new Random());
		
		//Should have initialised with 38 bins
		for(int i=0; i< 38; i++) {
			assertNotNull("Bin at position " + i + " was null",
					wheel.getBin(i));
		}
	}
	
	@Test
	public void testaddOutcomeToBins() {
		
		//Create some Outcomes
		Outcome doubleZero = new Outcome("00-0-1-2-3", 6);
		Outcome twelve = new Outcome("12", 35);
		Outcome eleven = new Outcome("11", 35);
		Outcome red = new Outcome("Red", 2);
		Outcome black = new Outcome("Black", 2);
		Outcome firstTwelve = new Outcome("firstTwelve", 3);

		//Create a wheel - don't care about seeding right now
		//Add some outcomes to its bins
		Wheel wheel = new Wheel(new Random());		
		wheel.addOutcomeToBin(0, doubleZero);
		wheel.addOutcomeToBin(1,  twelve);
		wheel.addOutcomeToBin(1,  red);
		wheel.addOutcomeToBin(37, eleven);
		wheel.addOutcomeToBin(37, black);
		wheel.addOutcomeToBin(37, firstTwelve);
		
		//Check outcomes are in the right place
		assertNotNull(wheel.getBin(0));
		assertTrue(wheel.getBin(0).size() == 1);
		assertTrue(wheel.getBin(0).contains(doubleZero));
		
		assertNotNull(wheel.getBin(1));
		assertTrue(wheel.getBin(1).size() == 2);
		assertTrue(wheel.getBin(1).contains(twelve));
		assertTrue(wheel.getBin(1).contains(red));
		
		assertNotNull(wheel.getBin(37));
		assertTrue(wheel.getBin(37).size() == 3);
		assertTrue(wheel.getBin(37).contains(eleven));
		assertTrue(wheel.getBin(37).contains(black));
		assertTrue(wheel.getBin(37).contains(firstTwelve));
		
	}
	
	/**
	 * Testing the spinning of a wheel, with a seeded random number generator.
	 * Using a known seed means we can predict the results
	 * This generates the following 'random' numbers:
	 * 25,18,17,21,0,24,10,14,28,18
	 * In my opinion, we probably don't need to mock the random number
	 * generator as it would require a further class that returns some
	 * pre-determined list of values, which is what custom seeding does anyway.
	 */
	@Test
	public void testWheelSpin() {
		
		//Create some Outcomes
		Outcome doubleZero = new Outcome("00-0-1-2-3", 6);
		Outcome twelve = new Outcome("12", 35);
		Outcome eleven = new Outcome("11", 35);
		Outcome twentyFive = new Outcome("25", 35);
		Outcome four = new Outcome("4", 35);
		Outcome thirty = new Outcome("30", 35);
		
		Outcome red = new Outcome("Red", 2);
		Outcome black = new Outcome("Black", 2);
		Outcome firstTwelve = new Outcome("firstTwelve", 3);
				
		//Create a wheel:
		//Using a known seed means we can predict the results
		Wheel wheel = new Wheel(new Random(1));
		wheel.addOutcomeToBin(25, doubleZero);
		wheel.addOutcomeToBin(18, twelve);
		wheel.addOutcomeToBin(18, red);
		wheel.addOutcomeToBin(18, firstTwelve);
		wheel.addOutcomeToBin(17, eleven);
		wheel.addOutcomeToBin(17, black);
		wheel.addOutcomeToBin(21,  twentyFive);
		wheel.addOutcomeToBin(21, red);
		wheel.addOutcomeToBin(0, four);
		wheel.addOutcomeToBin(0, black);
		wheel.addOutcomeToBin(0, firstTwelve);
		wheel.addOutcomeToBin(24, thirty);
		wheel.addOutcomeToBin(24, red);
		
		//Now 'randomly' select some bins and check results
		Bin firstResult = wheel.next();
		assertNotNull(firstResult);
		assertEquals(wheel.getBin(25), firstResult);
		assertTrue(firstResult.size() == 1);
		assertTrue(firstResult.contains(doubleZero));
		
		Bin secondResult = wheel.next();
		assertNotNull(secondResult);
		assertEquals(wheel.getBin(18), secondResult);
		assertTrue(secondResult.size() == 3);
		assertTrue(secondResult.contains(twelve));
		assertTrue(secondResult.contains(red));
		assertTrue(secondResult.contains(firstTwelve));
		
		Bin thirdResult = wheel.next();
		assertNotNull(thirdResult);
		assertEquals(wheel.getBin(17), thirdResult);
		assertTrue(thirdResult.size() == 2);
		assertTrue(thirdResult.contains(eleven));
		assertTrue(thirdResult.contains(black));
		
		
		Bin fourthResult = wheel.next();
		assertNotNull(fourthResult);
		assertEquals(wheel.getBin(21), fourthResult);
		assertTrue(fourthResult.size() == 2);
		assertTrue(fourthResult.contains(twentyFive));
		assertTrue(fourthResult.contains(red));
		
		Bin fifthResult = wheel.next();
		assertNotNull(fifthResult);
		assertEquals(wheel.getBin(0), fifthResult);
		assertTrue(fifthResult.size() == 3);
		assertTrue(fifthResult.contains(four));
		assertTrue(fifthResult.contains(black));
		assertTrue(fifthResult.contains(firstTwelve));
		
		Bin sixthResult = wheel.next();
		assertNotNull(sixthResult);
		assertEquals(wheel.getBin(24), sixthResult);
		assertTrue(sixthResult.size() == 2);
		assertTrue(sixthResult.contains(thirty));
		assertTrue(sixthResult.contains(red));
	}
	
	@Test
	public void testOutcomeNameMapping() {
		//Tests that the list of all Outcomes is correctly
		//held by the Wheel and returns the correct item when
		//we request it.
		
		//Create some Outcomes
		Outcome red = new Outcome("Red", 2);
		Outcome black = new Outcome("Black", 2);
		Outcome firstTwelve = new Outcome("firstTwelve", 3);
		Outcome singleOne = new Outcome("Single 1", 35);
		Outcome singleTwo = new Outcome("Single 2", 35);
		Outcome singleThree = new Outcome("Single 3", 35);
		
		//Add them to the Wheel
		Wheel wheel = new Wheel(new Random());
		wheel.addOutcomeToBin(0,singleOne);
		wheel.addOutcomeToBin(1,singleTwo);
		wheel.addOutcomeToBin(2,singleThree);
		
		wheel.addOutcomeToBin(0,red);
		wheel.addOutcomeToBin(1,black);
		wheel.addOutcomeToBin(2,firstTwelve);
		
		//Now try to get Outcomes by name
		assertEquals(singleOne, wheel.getOutcome("Single 1"));
		assertEquals(singleTwo, wheel.getOutcome("Single 2"));
		assertEquals(singleThree, wheel.getOutcome("Single 3"));
		assertEquals(red, wheel.getOutcome("Red"));
		assertEquals(black, wheel.getOutcome("Black"));
		assertEquals(firstTwelve, wheel.getOutcome("firstTwelve"));
		
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testInvalidOutcomeNameMapping(){
		
		//Create a couple of Outcomes
		Outcome red = new Outcome("Red", 2);
		Outcome black = new Outcome("Black", 2);
		
		//Add them to the wheel
		Wheel wheel = new Wheel(new Random());
		wheel.addOutcomeToBin(0,red);
		wheel.addOutcomeToBin(1,black);
		
		//Now try to get one that doesn't exist
		//We expect the function to throw a NoSuchElementException
		wheel.getOutcome("Nothing!");
	}	

}
