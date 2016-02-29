package grp.projects.casinogames.roulette;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Wheel {
	
	private Bin[] bins;
	private Random numberPicker;
	
	private List<Outcome> allOutcomes;
	
	public Wheel(Random numberPicker){
		this.bins = new Bin[38];
		this.numberPicker = numberPicker;	
		this.allOutcomes = new ArrayList<Outcome>();
		setupBins();
	}
	
	public Wheel init(){
		BinBuilder.buildBins(this);
		return this;
	}
	
	/**
	 * Add an Outcome to the given bin, identified by index.
	 * The method also adds the given Outcome to an internal list of 
	 * all possible Outcomes. 
	 * 
	 * @TODO Determine if there is a better way of maintaining this list  of allOutcomes
	 * 
	 * @param binIndex
	 * @param outcome
	 */
	public void addOutcomeToBin(int binIndex, Outcome outcome) {
		bins[binIndex].add(outcome);
		if(!this.allOutcomes.contains(outcome)){
			this.allOutcomes.add(outcome);
		}		
	}
	
	
	/**
	 * Get an Outcome corresponding to the given name
	 * @param name
	 * @return
	 */
	public Outcome getOutcome(String name){
		return allOutcomes.stream()
		.filter(oc-> oc.getName().contains(name))
		.findFirst()
		.get();
	}
	
	/**
	 * Randomly selects the next Bin (e.g. a spin of the wheel)
	 * @return The Bin that was selected (in real life the bin that
	 * the ball-bearing would have landed in)
	 */
	public Bin next() {
		return bins[numberPicker.nextInt(38)];
	}
	
	public Bin getBin(int binIndex) {
		return bins[binIndex];
	}
	
	private void setupBins(){
		for(int i=0; i<bins.length; i++) {
			bins[i] = new Bin();
		}
	}
}
