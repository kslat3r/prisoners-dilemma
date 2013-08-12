package strategies;

import java.util.Vector;

public abstract class Strategy {

	private int score;
	private String name;
	private String type;
	private Vector<String> past_moves;
	private Vector<Integer> past_scores;
	
	public Strategy(String _name, String _type) {
		this.name = _name;
		this.type = _type;
		this.past_moves = new Vector<String>();
		this.past_scores = new Vector<Integer>();
		//this.past_scores.add(0);
	}
	
	public abstract String play(Vector<String> _opponents_past_moves);
	
	public void increment_score(int _score) {		
		this.score += _score;		
	}
	
	public int get_score() {
		return this.score;
	}
	
	public String get_name() {
		return this.name;
	}
	
	public String get_type() {
		return this.type;
	}
	
	public void add_past_move(String _move) {		
		this.past_moves.add(_move);
	}
	
	public Vector<String> get_past_moves() {
		return this.past_moves;
	}
	
	public void add_past_score(int _score) {
		this.past_scores.add(this.get_score());
	}
	
	public Vector<Integer> get_past_scores() {
		return this.past_scores;
	}	
}