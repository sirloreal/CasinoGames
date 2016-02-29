package grp.projects.casinogames.roulette;

import java.util.HashSet;

public class Bin extends HashSet<Outcome> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString(){
		StringBuffer buff = new StringBuffer();		
		this.forEach(item -> {
			buff.append(item);
			buff.append(", ");		
		});
		buff.append("\n");
		
		return buff.toString();
	}

}
