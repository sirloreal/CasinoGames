package grp.projects.casinogames.roulette;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Class used to construct the various bins available in Roulette,
 * which can contain one or more outcomes
 * 
 * The class is responsible for constructing the necessary Outcomes
 * for all 38 individual result Bins on the Roulette wheel
 * 
 */
public class BinBuilder {
	
	//The numbers on the Roulette wheel which are red
	private static final Set<Integer> redNumbers = new HashSet<Integer>(
			Arrays.asList(1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36));
	
	
	/**
	 * Builder method to start construction
	 * 
	 * @param wheel The wheel which will contain the bins
	 */
	public static void buildBins(Wheel wheel){
	
		generateStraightBets(wheel);
		generateSplitBets(wheel);
		generateStreetBets(wheel);
		generateCornerBets(wheel);
		generateLineBets(wheel);
		generateDozenBets(wheel);
		generateColumnBets(wheel);
		generateEvenBets(wheel);
	}
	
	//Represent single numbers e.g. '1' or '2'
	private static void generateStraightBets(Wheel wheel) {
		
		//Add all numbers from 0 through to 36
		for(int i=0; i<37; i++) {
			wheel.addOutcomeToBin(i, new Outcome("Single " + Integer.toString(i), 35));
		}
		
		//Finally, 00 in the last bin
		wheel.addOutcomeToBin(37, new Outcome("Single 00", 35));
	}	
	
	//Split bets will be formed of a pair of numbers 
	//e.g. 1 and 2 or 21 and 24.
	private static void generateSplitBets(Wheel wheel) {
		
		//Iterate the twelve rows of the table. Since each number on the table
		//is 3 more than the preceding row, we use this as a multiplier, and then
		//add one to generate the outcome of betting a split on two numbers.
		//The Outcome is then added to two result bins - for example, the 10/11 split
		//bet Outcome would come from the result bin of 10 or 11.
		for(int i=0; i<12; i++) {
			
			//first/second column split bets
			int value = (3*i) + 1;
			Outcome outcome = new Outcome("Split " + 
					Arrays.toString(new int[]{value, value+1}), 17);
			
			wheel.addOutcomeToBin(value, outcome);			
			wheel.addOutcomeToBin(value+1, outcome);
			
			//second/third column split bets
			int value2 = (3*i) + 2;
			Outcome outcome2 = new Outcome("Split" +
					Arrays.toString(new int[]{value2, value2+1}), 17);
			
			//Outcome belongs to 2 result bins
			wheel.addOutcomeToBin(value2, outcome2);
			wheel.addOutcomeToBin(value2+1, outcome2);					
		}
		
		//Iterate the numbers 1-33, to generate the up/down split bets.
		//e.g. 13 and 16 or 27 and 30
		for(int i=0; i<33; i++) {
			
			//Just one up/down bet needed per count
			int value = i+1;
			Outcome outcome = new Outcome("Split" +
					Arrays.toString(new int[]{value, value+3}), 17);
			
			//Outcome belongs to 2 result bins
			wheel.addOutcomeToBin(value, outcome);
			wheel.addOutcomeToBin(value+3, outcome);
		}
		
		//Finally, add the '00-0-1-2-3' Outcome to each of the bins it applies to
		Outcome splitZero = new Outcome("Split 00-0-1-2-3", 6);
		wheel.addOutcomeToBin(0, splitZero);
		wheel.addOutcomeToBin(1, splitZero);
		wheel.addOutcomeToBin(2, splitZero);
		wheel.addOutcomeToBin(3, splitZero);
		wheel.addOutcomeToBin(37, splitZero);
	}
	
	//Street bets are three numbers in a single row e.g. 1,2,3.
	private static void generateStreetBets(Wheel wheel) {
		
		//Iterate each row of the table and generate a street bet
		//Outcome for that row. The Outcome then belongs to 3 result bins
		//e.g. 16, 17, 18
		for(int i=0; i<12; i++) {
			int value = (3*i) + 1;
			
			Outcome streetOutcome =  new Outcome("Street" +
					Arrays.toString(new int[]{value,value+1,value+2}), 11);
			
			//Put this outcome in the three result bins
			wheel.addOutcomeToBin(value, streetOutcome);
			wheel.addOutcomeToBin(value+1, streetOutcome);
			wheel.addOutcomeToBin(value+2, streetOutcome);
		}
	}
	
	//A corner bet is a square of 4 numbers e.g. 13/14/16/17.
	//There are 22 possible bets on a table and each number is a member
	//of one, two or four corner bets. A number in the centre column belongs to
	//four corner bets. Edge numbers are members of two corner bets. The
	//end numbers of 1,3,34,36 belong to just one corner bet
	private static void generateCornerBets(Wheel wheel) {
		
		//For all lines between rows
		for(int i=0; i<11; i++){
			
			//Create the first/second column corner bet Outcomes
			int value = (i*3) +1;			
			Outcome outcome = new Outcome("Corner" +
					Arrays.toString(new int[]{value,value+1,value+3,value+4}), 8);
			
			wheel.addOutcomeToBin(value, outcome);
			wheel.addOutcomeToBin(value+1, outcome);
			wheel.addOutcomeToBin(value+3, outcome);
			wheel.addOutcomeToBin(value+4, outcome);
			
			//create the second/third column corner Outcomes
			int value2 = (i*3) +2;
			Outcome outcome2 = new Outcome(
					Arrays.toString(new int[]{value2,value2+1,value2+3,value2+4}), 8);
			
			wheel.addOutcomeToBin(value2, outcome2);
			wheel.addOutcomeToBin(value2+1, outcome2);
			wheel.addOutcomeToBin(value2+3, outcome2);
			wheel.addOutcomeToBin(value2+4, outcome2);
			
		}
	}
	
	//Line bets are bets on the 11 lines between the 12 rows
	private static void generateLineBets(Wheel wheel) {
		
		//For all lines between rows
		for(int i=0; i<11; i++) {
			
			//There will be 6 numbers per line Outcome
			int value = (i*3) + 1;
			Outcome lineOutcome = new Outcome("Line" +
					Arrays.toString(new int[]{value, value+1,value+2, value+3, value+4, value+5}), 5);
			
			//Place the Outcome in the six result bins
			wheel.addOutcomeToBin(value, lineOutcome);
			wheel.addOutcomeToBin(value+1, lineOutcome);
			wheel.addOutcomeToBin(value+2, lineOutcome);
			wheel.addOutcomeToBin(value+3, lineOutcome);
			wheel.addOutcomeToBin(value+4, lineOutcome);
			wheel.addOutcomeToBin(value+5, lineOutcome);
		}		
	}
	
	//Three possible groups: 1 to 12, 13 to 24, 25 to 36 
	private static void generateDozenBets(Wheel wheel) {
		
		//For all dozens
		for(int i=0; i<3; i++){
			
			//Create a dozen Outcome
			Outcome dozenOutcome = new Outcome(
					("Dozen " + (i+1)), 2);
			
			//Then, for each number in this dozen, associate this
			//Outcome with that number's result bin
			for(int j=0; j<12; j++){
				//N.B. The first applicable result bin will be for the 
				//number 1. Index 0 on the wheel contains the '0' result
				int value = (12*i) + j + 1;
				wheel.addOutcomeToBin(value, dozenOutcome);
			}			
		}
	}
	
	//Each number is a member of one of three columns
	private static void generateColumnBets(Wheel wheel) {
		
		//for all columns
		for(int i=0; i<3; i++) {
			
			//Create a column Outcome
			Outcome columnOutcome = new Outcome(
					("Column " + (i+1)), 2);
			
			//Then for each row in that column, associate the Outcome
			//with the numbers in the column. The numbers will increase
			//by 3 at each  subsequent row
			for(int j=0; j<12; j++) {
				int value = (3*j) + i + 1;
				wheel.addOutcomeToBin(value, columnOutcome);
			}
		}
	}
	
	private static void generateEvenBets(Wheel wheel) {
		
		//Create the even bet Outcomes
		Outcome red = new Outcome("Red", 1);
		Outcome black = new Outcome("Black", 1);
		Outcome even = new Outcome("Even", 1);
		Outcome odd = new Outcome("Odd", 1);
		Outcome high = new Outcome("High", 1);
		Outcome low = new Outcome("Low", 1);
		
		//For all numbers, add the relevant Outcomes to their results bins
		for(int i=1; i<37; i++){
			
			//If lower than 19, use the low Outcome, otherwise the high
			if(i<19) {
				wheel.addOutcomeToBin(i, low);
			}
			else {
				wheel.addOutcomeToBin(i,  high);
			}
			
			//If divisible by 2, the number is even
			//Otherwise, give it the odd Outcome
			if(i%2 == 0) {
				wheel.addOutcomeToBin(i, even);
			}
			else {
				wheel.addOutcomeToBin(i, odd);
			}
			
			//If the number is in the list of red numbers, add red Outcome
			//Otherwise, it is a black number
			if(redNumbers.contains(i)) {
				wheel.addOutcomeToBin(i, red);
			}
			else {
				wheel.addOutcomeToBin(i, black);
			}
			
			
		}
	}
}
	