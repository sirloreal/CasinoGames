package grp.projects.casinogames.roulette;

/**
 * Simulates the sequence of events involved in a game of
 * Roulette
 * @author gary_page
 *
 */
public class Game {
	
	private Wheel wheel;
	private Table table;
	
	public Game(Wheel wheel, Table table){
		this.wheel = wheel;
		this.table = table;
	}
	
	/**
	 * Plays a round. This method:
	 * 1. Calls the Player's placeBets() method to get bets;
	 * 2. Calls the wheel's next() method to get the winning Bin;
	 * 3. Iterates over the Table's bets to determine winning/losing bets
	 * @param player
	 */
	public Bin cycle(Passenger57 player){
		//Get bets
		player.placeBets();
		
		//Get the next number
		Bin winningBin = this.wheel.next();
		
		//Go through each bet on the table
		//If it's in the winning bin, then notify the player of the
		//winning bet. Otherwise, notify them of the losing bet
		for(Bet bet: this.table.getBets()){
		  if(winningBin.contains(bet.getOutcome())){
			player.win(bet);
		  }
		  else{
			  player.lose(bet);
		  }
			
		}
		
		//Now clear all the bets from the table, ready to go again
		this.table.clear();
		
		return winningBin;
		
	}

}
