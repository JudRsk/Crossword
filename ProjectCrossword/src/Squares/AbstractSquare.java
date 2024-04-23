package Squares;

public abstract class AbstractSquare implements Square {
	
	protected int xPosition;
	protected int yPosition;
	protected char character;
	
	public AbstractSquare(int xPosition, int yPosition) {
		this.xPosition=xPosition;
		this.yPosition=yPosition;
	}

	public int getX() {
		return xPosition;
	}

	public void setX(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getY() {
		return yPosition;
	}

	public void setY(int yPosition) {
		this.yPosition = yPosition;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

		
	//not necessary to implement an interface in an abstract superclass

}
