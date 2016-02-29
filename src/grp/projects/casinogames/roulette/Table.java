package grp.projects.casinogames.roulette;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents the playing table, on which Players can place bets
 * @author gary_page
 *
 */
public class Table {

	//TODO: Make this class abstract for future games?
	
	//The betting limit for the table
	private int limit;
	//The minimum bet for the table
	private int minimum;
	//The currently active bets on the table
	private List<Bet> bets;
	
	public Table(int limit, int minimum){
		this.limit = limit;
		this.minimum = minimum;
		this.bets = new ArrayList<Bet>();
	}
	
	/**
	 * Places a bet
	 * @param bet the bet to place
	 */
	public void placeBet(Bet bet) {
		//TODO: for an interactive game, you would want to validate
		//each bet prior to placing it so as to feedback immediately
		//to the player.
		this.bets.add(bet);
	}
	
	/**
	 * Determines whether the bets on the table are valid or not.
	 * The table is valid if the following are true:
	 * 1) The sum of all bets (by one player) is less than or equal to the table limit 
	 * 2) All bet amounts are greater than or equal to the minimum bet
	 * 
	 * This method is designed (for now) as a one-fire check before 
	 * spinning the wheel. In future designs  it might make more sense
	 * to raise the Exception in the placeBet method, as the bet is placed
	 * 
	 * TODO: Re-visit the implementation of this method
	 * 
	 * @return true if all the bets are deemed valid, otherwise false
	 */
	public void isValid() throws InvalidBetException{
		int totalBets = 0;
		for(Bet b : bets) {
			if(this.minimum>b.getAmountBet()){
				throw new InvalidBetException("Amount bet is below the minimum bet");
			}
			else {
				totalBets += b.getAmountBet();
			}
		}
		
		//Finally, check that the sum of all bets is less than the limit
		if(totalBets > this.limit) {
			throw new InvalidBetException("Amount bet exceeds the table limit");
		}
		
		//Got this far so all was good
		
	}
	
	
	//TODO: Use an Iterator or just return the list?
	public List<Bet> getBets() {
		return this.bets;
	}
	
	/**
	 * Clears all the Bets from the table
	 */
	public void clear(){
		this.bets.clear();
	}
	
	@Override
	public String toString(){
		StringBuffer buff = new StringBuffer();
		this.bets.forEach(b -> {
			buff.append(b.toString());
			buff.append(" | ");
		});
		
		return buff.toString();
	}
	
}
