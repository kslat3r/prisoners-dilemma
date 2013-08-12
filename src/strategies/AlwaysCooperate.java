package strategies;

import java.util.Vector;

public class AlwaysCooperate extends Strategy {

	public AlwaysCooperate() {
		super("Always Co-operate", "Nice"); 
	}

	public String play(Vector<String> _opponents_past_moves) {
		super.add_past_move("C");
		return "C";
	}	
}