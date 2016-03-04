package grp.projects.casinogames.roulette.tests;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import grp.projects.casinogames.roulette.Game;
import grp.projects.casinogames.roulette.Passenger57;
import grp.projects.casinogames.roulette.Table;
import grp.projects.casinogames.roulette.Wheel;

public class GameTests {

	/**
	 * Tests that the game can play a cycle of Roulette
	 */
	@Test
	public void testCycle() {
		
		//Use a seeded RNG so we know the results
		Wheel wheel = new Wheel(new Random(1)).init();
		Table table = new Table(300,10);
		Passenger57 passenger57 = new Passenger57(table, wheel);
		
		Game theGame = new Game(wheel, table);
		
		theGame.cycle(passenger57);
		
		//We know that the player will have bet on black
		//So a good test will be that they have lost for the 
		//first number - 25 (Red)
		assertEquals(990, passenger57.getTotalMoney());
		
		//Next is 18 (Red) - therefore a loss
		theGame.cycle(passenger57);
		assertEquals(980, passenger57.getTotalMoney());
		
		//Next is 17 (Black) - therefore a win
		theGame.cycle(passenger57);
		assertEquals(990, passenger57.getTotalMoney());
		
	}

}
