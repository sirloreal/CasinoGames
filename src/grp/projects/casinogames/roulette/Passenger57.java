package grp.projects.casinogames.roulette;

//Stub class- this guy always bets on black!
public class Passenger57 {
	
	private Outcome black;	
	private Table table;
	
	int totalMoney = 1000; //to start with
	
	public Passenger57(Table table, Wheel wheel){
		this.table = table;
		this.black = wheel.getOutcome("Black");
	}
	
	public void placeBets(){
		Bet bet = new Bet(10, black);
		this.totalMoney -= bet.getAmountBet();
		table.placeBet(bet);
	}
	
	//Notification that the player won
	public void win(Bet bet){
		this.totalMoney += bet.winAmount();
	}
	
	//Notification that the player lost
	public void lose(Bet bet){
		//Money has already been taken... maybe have a little cry?
	}
	
	public int getTotalMoney(){
		return this.totalMoney;
	}

}
