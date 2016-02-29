package grp.projects.casinogames.roulette;

/**
 * Contains information relating to a Bet made on Roulette
 * @author gary_page
 *
 */
public class Bet {
	
	private int amountBet; 
	//The outcome on which the bet has been placed (e.g. Split 7-8)
	private Outcome outcome; 
	
	public Bet(int amountBet, Outcome outcome) {
		this.amountBet = amountBet;
		this.outcome = outcome;
	}
	
	/**
	 * Calculates the amount won for a winning Bet.
	 * The Outcome's win amount multiplies the amountBet by the odds,
	 * and this is added to the original amount bet
	 * @return amount won by the Bet
	 */
	public int winAmount(){
		return this.amountBet + this.outcome.winAmount(amountBet);
	}
	
	/**
	 * Returns the amount lost for a losing Bet.
	 * This is, in essence, the amount of the Bet placed.
	 * @return amountBet
	 */
	public int loseAmount(){
		return getAmountBet();
	}
	
	public int getAmountBet() {
		return this.amountBet;
	}
	
	
	public Outcome getOutcome(){
		return this.outcome;
	}
	
	@Override
	public String toString(){
		return "Bet: " + this.amountBet +
				" on: " +this.outcome.toString();
	}

}
