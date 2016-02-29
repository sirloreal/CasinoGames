package grp.projects.casinogames.roulette.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import grp.projects.casinogames.roulette.Bet;
import grp.projects.casinogames.roulette.Outcome;

public class BetTests {

	@Test
	public void testSingleNumberBet() {
			
		//e.g. Bet on the number '30'
		Outcome singleNumber = new Outcome("30", 35);
		Bet singleNumberBet = new Bet(10, singleNumber); //Bet 10 on number 30
		
		//35*10 + 10
		assertEquals(360, singleNumberBet.winAmount());
		assertEquals(10, singleNumberBet.loseAmount());
		
	}
	
	@Test
	public void testBetOnEven() {
		
		//e.g Bet on Red
		Outcome red = new Outcome("Red", 1);
		Bet betOnRed = new Bet(10, red);
		
		//1*10 + 10 (e.g. double your money)
		assertEquals(20, betOnRed.winAmount());
		assertEquals(10, betOnRed.loseAmount());		
	}

}
