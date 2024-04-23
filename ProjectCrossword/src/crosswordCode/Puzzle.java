package crosswordCode;

import java.util.ArrayList;
import java.util.Arrays;

import Squares.AbstractSquare;

public class Puzzle {
	
	private int height;
	private int width;
	private ArrayList<AbstractSquare> squares = new ArrayList<AbstractSquare>();
	private ArrayList<String> panel = new ArrayList<String>();

	
	
	public Puzzle() {
		height = 0;
		width = 0;
	}

	public Puzzle (int width, int height) {
		this.height=height;
		this.width=width;
	}
	
	public void setWidthHeight (int width, int height) {
		this.height=height;
		this.width=width;
	}
	
	//addSquares to the Arraylist
	
	public void addSquares(AbstractSquare newSquare) {
		squares.add(newSquare);		

	}
	
	
	 /*private Square[] squares2;
	 public Square[] addSquares2(Square newSquare) {
		 Square[] newSquares = new Square[squares2.length+1];
		 for (int i = 0; i < squares2.length; i++) {
			 newSquares[i] = squares2[i];
		 }
		newSquares[squares2.length] = newSquare;
		 
		 return newSquares;
	 }
	 */
	 
	
	
	public ArrayList<AbstractSquare> getSquares() {
		return this.squares;
	}
	
	public AbstractSquare getSquare (int xPositie, int yPositie) {
		
		AbstractSquare possibleSquare = null;
		
		for (AbstractSquare square : squares) {
			if (square.getX() == xPositie && square.getY() == yPositie) {
				return square;
			}
		}
		return possibleSquare;
	
	}
	
	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public ArrayList<String> getPanel() {
		return this.panel;
	}

	public void addPanel(String text) {
		this.panel.add(text);
	}
	/*
	 * 	String[] newPanel = new String[this.panel.length+1];
		for (int i = 0; i < newPanel.length; i++ ) {	 
			 newPanel[i] = panel;
			 //System.out.println(Arrays.toString(newPanel));
	 */
		 
	 }
	

