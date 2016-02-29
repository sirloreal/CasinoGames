package grp.projects.casinogames.roulette.tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Random;

import org.junit.Test;

import grp.projects.casinogames.roulette.BinBuilder;
import grp.projects.casinogames.roulette.Wheel;

public class BinBuilderTests {
	
	@Test
	public void testBinBuilder() {
		
		Wheel testWheel = new Wheel(new Random());
		BinBuilder.buildBins(testWheel);
		
		//We expect there to be 38 bins - each should have outcomes
		for(int i=0; i<38; i++) {
			assertNotNull(testWheel.getBin(i));		
			assertTrue(testWheel.getBin(i).size()>0);
			System.out.println(i + ": " + testWheel.getBin(i).size());
			assertEquals("Check for bin index: " + i, binOutcomes.get(i).intValue(), testWheel.getBin(i).size());
		}
	}
	
	//Key = bin number
	//Value = number of expected outcomes for the bin number
	private static final HashMap<Integer,Integer> binOutcomes;
	static {
		
		binOutcomes = new HashMap<Integer, Integer>();
		binOutcomes.put(0, 2);
		binOutcomes.put(1, 12);
		binOutcomes.put(2, 14);
		binOutcomes.put(3, 12);
		binOutcomes.put(4, 14);
		binOutcomes.put(5, 17);
		binOutcomes.put(6, 14);
		binOutcomes.put(7, 14);
		binOutcomes.put(8, 17);
		binOutcomes.put(9, 14);
		binOutcomes.put(10, 14);
		binOutcomes.put(11, 17);
		binOutcomes.put(12, 14);
		binOutcomes.put(13, 14);
		binOutcomes.put(14, 17);
		binOutcomes.put(15, 14);
		binOutcomes.put(16, 14);
		binOutcomes.put(17, 17);
		binOutcomes.put(18, 14);
		binOutcomes.put(19, 14);
		binOutcomes.put(20, 17);
		binOutcomes.put(21, 14);
		binOutcomes.put(22, 14);
		binOutcomes.put(23, 17);
		binOutcomes.put(24, 14);
		binOutcomes.put(25, 14);
		binOutcomes.put(26, 17);
		binOutcomes.put(27, 14);
		binOutcomes.put(28, 14);
		binOutcomes.put(29, 17);
		binOutcomes.put(30, 14);
		binOutcomes.put(31, 14);
		binOutcomes.put(32, 17);
		binOutcomes.put(33, 14);
		binOutcomes.put(34, 11);
		binOutcomes.put(35, 13);
		binOutcomes.put(36, 11);
		binOutcomes.put(37, 2);
	}

}
