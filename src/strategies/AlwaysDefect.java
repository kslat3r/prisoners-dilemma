package strategies;

import java.util.Vector;

public class AlwaysDefect extends Strategy {

	public AlwaysDefect() {
		super("Always Defect", "nasty");
	}

	public String play(Vector<String> _opponents_past_moves) {		
		super.add_past_move("D");
		return "D";
	}	
}