package grp.projects.casinogames.roulette;

import java.util.Random;

public class Main {

	public static void main(String[] args) throws InterruptedException{
		// Run a few goes at the Roulette game
		
		Wheel wheel = new Wheel(new Random()).init();
		Table table = new Table(300, 10);
		
		Passenger57 player =
				new Passenger57(table, wheel);
		
		Game game = new Game(wheel, table);
		
		System.out.println("Starting game");
		
		while(player.getTotalMoney()>0){
			System.out.println("Spinning the wheel!");
			System.out.println("No more bets please!");
			Thread.sleep(5000);
			Bin win = game.cycle(player);
			
			System.out.println("Winning bets are: " + win.toString());
			
			System.out.println("Player money: " + player.getTotalMoney());
			System.out.println("Place your bets now!");
			
			Thread.sleep(5000); //Have a little sleep
		}
		
		System.out.println("Player is out of money!");

	}

}
