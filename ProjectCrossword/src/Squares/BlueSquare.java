package Squares;

import java.awt.Color;

public class BlueSquare extends AbstractSquare {
	

	private char blueValue;
	private char character;

	public BlueSquare(int xPosition, int yPosition, char blueValue) {
		super(xPosition, yPosition);
		this.blueValue = blueValue;
		this.character = ' ' ;
	}
	
	
	public char getBlueValue() {
		return blueValue;
	}

	public void setBlueValue(char blueValue) {
		this.blueValue = blueValue;
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}
	
	@Override
	public Color getColor() {
		return Color.blue;
	}

}
