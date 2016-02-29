package grp.projects.casinogames.roulette;

/**
 * Exception which can be raised as necessary in response to invalid
 * bets being placed. Such an examlpe would be a Player exceeding 
 * the table limit with a bet.
 * 
 * @author gary_page
 *
 */
public class InvalidBetException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidBetException(String message){
		super(message);
	}
}
