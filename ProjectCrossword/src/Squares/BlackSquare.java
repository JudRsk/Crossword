package Squares;

import java.awt.Color;

public class BlackSquare extends AbstractSquare {

	public BlackSquare(int xPosition, int yPosition) {
		super(xPosition, yPosition);
		
	}
	
	@Override
	public Color getColor() {
		return Color.black;
	}

}
