import strategies.Strategy;

public class Tournament {
	
	public void compete(Strategy _strategy1, Strategy _strategy2) {
		Strategy strategy1 = _strategy1;
		Strategy strategy2 = _strategy2;
		String move1 = null;
		String move2 = null;
		
		for (int i=0; i<200; i++) {		
			move1 = strategy1.play(strategy2.get_past_moves());
			move2 = strategy2.play(strategy1.get_past_moves());	
		
			//reward
			if (move1 == "C" && move2 == "C") {
				strategy1.increment_score(3);
				strategy2.increment_score(3);
			}
			
			//sucker's payoff
			if (move1 == "C" && move2 == "D") {
				strategy1.increment_score(0);
				strategy2.increment_score(5);
			}
			
			//temptation
			if (move1 == "D" && move2 == "C") {
				strategy1.increment_score(5);
				strategy2.increment_score(0);
			}
			
			//punishment
			if (move1 == "D" && move2 == "D") {
				strategy1.increment_score(1);
				strategy2.increment_score(1);
			}	
		}
		
		strategy1.add_past_score(strategy1.get_score());
		strategy2.add_past_score(strategy2.get_score());
	}
}