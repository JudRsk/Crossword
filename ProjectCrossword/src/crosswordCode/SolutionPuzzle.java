package crosswordCode;

import java.util.ArrayList;

import Squares.CheckSquare;


public class SolutionPuzzle {

	private Puzzle puzzle;
	private String v = "";
	private String s = "";

	private ArrayList<CheckSquare>check = new ArrayList<>();

	public ArrayList<CheckSquare> getCheck() {
		return check;
	}

	public void setCheck(ArrayList<CheckSquare> check) {
		this.check = check;
	}

	public SolutionPuzzle(Puzzle puzzle) {
		this.puzzle = puzzle;

	}

	public void addCheckSquares(CheckSquare newSquare) {
		check.add(newSquare);		

	}

	public boolean checkSolution() {
		for (int i = 0; i < check.size(); i++) {
			String checkValue = String.valueOf(check.get(i).getCharacter());
			String checkSol = String.valueOf(check.get(i).getCheckValue());
			s = s.concat(checkValue);
			v = v.concat(checkSol);
			}
		if(v.equals(s)) {
			return true;
	
		}
		return false;
	}
	
	public boolean checkSolution2() {
		int h = 0;
						
		for (int i = 0; i < check.size(); i++ ) {
			if (check.get(i).checkCharacters() == true) {
			h++;
			}
		}
		
		if (h == check.size()) {
			return true;
		} else {
			return false;
		}
		
	}

	public Puzzle getPuzzle() {
		return puzzle;
	}

	public void setPuzzle(Puzzle puzzle) {
		this.puzzle = puzzle;
	}
}
	
