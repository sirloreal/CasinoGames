package grp.projects.casinogames.roulette;

public class Outcome {
	
	private String name;
	private int odds;
	
	public Outcome(String name, int odds) {
		this.name = name;
		this.odds = odds;
	}
	
	//TODO: Do we need getters or setters?
	
	//Multiplies the (bet) amount by the odds
	public int winAmount(int amount) {
		return amount * odds;
	}
	
	public String getName(){
		return this.name;
	}
	
	@Override
	public boolean equals(Object other) {
		return other instanceof Outcome && 
				this.name == ((Outcome)other).name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return name + " (" + odds + ":1)";
	}
}
