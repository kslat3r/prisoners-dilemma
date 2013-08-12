package strategies;

import java.util.Vector;

public class Random extends Strategy {

	public Random() {
		super("Random", "Random");
	}

	public String play(Vector<String> _opponents_past_moves) {		
		String move = null;
		double random = Math.random();		
		if (random < 0.5) {
			move = "C";
		}
		else {
			move = "D";
		}
		
		super.add_past_move(move);
		return move;
	}	
}