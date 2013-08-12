package strategies;

import java.util.Vector;

public class TitForTat extends Strategy {

	public TitForTat() {
		super("Tit For Tat", "nice");
	}

	public String play(Vector<String> _opponents_past_moves) {		
		String move = null;
		try {
			if (_opponents_past_moves.get(_opponents_past_moves.size() - 1) == "D") {
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