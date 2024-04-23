package Squares;

import java.awt.Color;

public class GraySquare extends AbstractSquare {
	
	private char character;

	public GraySquare(int xPosition, int yPosition) {
		super(xPosition, yPosition);
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
		return Color.gray;
	}
	

}
