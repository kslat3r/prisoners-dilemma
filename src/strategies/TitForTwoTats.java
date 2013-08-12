package strategies;

import java.util.Vector;

public class TitForTwoTats extends Strategy {

	public TitForTwoTats() {
		super("Tit For Two Tats", "nice");
	}

	public String play(Vector<String> _opponents_past_moves) {		
		String move = null;
		try {
			if (_opponents_past_moves.get(_opponents_past_moves.size() - 1) == "D" && _opponents_past_moves.get(_opponents_past_moves.size() - 2) == "D") {
				move = "D";			
			}		
			else {
				move = "C";
			}
		}
		catch (Exception e) {
			move = "C";
		}
		
		super.add_past_move(move);
		return move;
	}	
}