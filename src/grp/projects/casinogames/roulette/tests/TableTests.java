package grp.projects.casinogames.roulette.tests;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import grp.projects.casinogames.roulette.Bet;
import grp.projects.casinogames.roulette.InvalidBetException;
import grp.projects.casinogames.roulette.Outcome;
import grp.projects.casinogames.roulette.Table;

public class TableTests {

	@Test
	public void testPlaceBets() {
		
		//Create a table and some bets
		Table table = new Table(300, 10);
		
		Outcome red = new Outcome("Red", 1);
		Bet betOnRed = new Bet(10, red);
		
		Outcome black = new Outcome("Black", 1);
		Bet betOnBlack = new Bet(20, black);
		
		//Place the bets
		table.placeBet(betOnRed);
		table.placeBet(betOnBlack);
		
		//Make sure the table has the correct number of bets
		assertNotNull(table.getBets());
		assertEquals(2, table.getBets().size());
	}
	
	@Test
	public void testIsValidValidTable() {
		//Create a table and some bets
		Table table = new Table(300, 10);
		
		Outcome red = new Outcome("Red", 1);
		Bet minBetOnRed = new Bet(10, red); //This is min bet
		Bet betOnRed = new Bet(20, red);
		
		Outcome black = new Outcome("Black", 1);
		Bet maxBetOnBlack = new Bet(240, black);
		Bet betOnBlack = new Bet(20, black);
		//The sum of these bets should equal 300 (the table limit)
		
		//Place the bets
		table.placeBet(betOnRed);
		table.placeBet(betOnBlack);
		table.placeBet(minBetOnRed);
		table.placeBet(maxBetOnBlack);
		
		//We expect the IsValid method to exit gracefully
		try {
			table.isValid();
		} catch (InvalidBetException e) {
			fail("Unexpected exception raised: " +e.getMessage());
		}
	}
	
	@Test(expected=InvalidBetException.class)
	public void testIsValidBetBelowMinimum() throws InvalidBetException {
		
		//Create a table and some bets
		Table table = new Table(300, 10);
		
		Outcome red = new Outcome("Red", 1);
		Bet belowMinBetOnRed = new Bet(5, red);
		
		//Place an invalid bet (below minimum bet)
		table.placeBet(belowMinBetOnRed);
		
		//Ensure the InvalidBetException is raised
		table.isValid();
		
	}
	
	@Test(expected=InvalidBetException.class)
	public void testIsValidBetsExceedLimit() throws InvalidBetException {
		//Create a table and some bets
		Table table = new Table(300, 10);
		
		Outcome red = new Outcome("Red", 1);
		Bet overLimitBetOnRed = new Bet(310, red);
		
		//Place an invalid bet (below minimum bet)
		table.placeBet(overLimitBetOnRed);
		
		//Ensure the InvalidBetException is raised
		table.isValid();
	}
	
	@Test
	public void testClearBetsFromTable() {
		Table table = new Table(300, 10);
		
		Outcome red = new Outcome("Red", 1);
		Bet belowMinBetOnRed = new Bet(10, red);
		
		//Place a bet 
		table.placeBet(belowMinBetOnRed);
		
		//Just to make sure the bet is on the table
		assertNotNull(table.getBets());
		assertEquals(1, table.getBets().size());
		
		//Now clear the bets from the table
		table.clear();
		
		//And now make sure there are no bets - should be an empty list
		assertNotNull(table.getBets());
		assertEquals(0, table.getBets().size());
	}

}
