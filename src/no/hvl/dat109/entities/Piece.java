package no.hvl.dat109.entities;

public class Piece {
	
	private String color;
	private Square square;
	private Board board;
	
	/**
	 * Constructor for a player piece.
	 * @param color piece identifier
	 * @param board	the board the piece belongs to
	 */
	public Piece(String color, Board board) {
		this.color = color;
		this.square = board.getGrid().get(1);
		this.board = board;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Square getSquare() {
		return square;
	}
	
	public void setSquare(Square square) {
		this.square = square;
	}
	
	/**
	 * Move the piece forward by die roll.
	 * @param roll squares to move
	 */
	public void move(int roll) {
		if (square.getNumber() + roll <= 100) {
			Square newSquare = board.getGrid().get(square.getNumber() + roll);
			setSquare(newSquare);
		} else {
			System.out.println("Roll too high. Try again!");
		}
	}
	
	/**
	 * Move the piece to a new position.
	 */
	public void moveToPosition(int position) {
		Square newSquare = board.getGrid().get(position);
		setSquare(newSquare);
	}
}
