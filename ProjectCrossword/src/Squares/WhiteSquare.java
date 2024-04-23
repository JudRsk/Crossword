package Squares;

import java.awt.Color;

public class WhiteSquare extends AbstractSquare {
	
	private char character;

	public WhiteSquare(int xPosition, int yPosition) {
		super (xPosition, yPosition);
		this.character = ' ' ;
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}
	
	@Override
	public Color getColor() {
		return Color.white;
	}

}
