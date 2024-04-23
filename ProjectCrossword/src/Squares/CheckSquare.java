package Squares;

import java.awt.Color;

public class CheckSquare extends AbstractSquare {
	
	private char character;
	private char checkValue;

	public CheckSquare(int xPosition, int yPosition, char checkValue) {
		super(xPosition, yPosition);
		this.character = ' ' ;
		this.checkValue = checkValue;
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public char getCheckValue() {
		return checkValue;
	}

	public void setCheckValue(char checkValue) {
		this.checkValue = checkValue;
	}
	
	public boolean checkCharacters() {
		if (Character.toUpperCase(checkValue) == Character.toUpperCase(character)) {
			return true;
		} else
			return false;
	}
	
	@Override
	public Color getColor() {
		return Color.gray;
	}
	

}
