package gui;

import javax.swing.JButton;

import Squares.AbstractSquare;

public class CrosswordButton extends JButton {
	
	private AbstractSquare square;
	
	public CrosswordButton(AbstractSquare square) {
		this.square = square;
	}

	public AbstractSquare getSquare() {
		return square;
	}

	public void setSquare(AbstractSquare square) {
		this.square = square;
	}
	

}
