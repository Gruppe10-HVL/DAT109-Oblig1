package no.hvl.dat109.entities;

import java.util.HashMap;
import java.util.Map;

public class Board {

	private final int GRID_SIZE = 100;
	private Map<Integer, Square> board;

	/**
	 * Constructs a new board.
	 */
	public Board() {
		board = new HashMap<>();

		for (int i = 0; i < GRID_SIZE; i++) {
			board.put(i + 1, new RegularSquare(i + 1));
		}

		addSnakesAndLadders();
	}

	public Map<Integer, Square> getGrid() {
		return board;
	}

	/**
	 * Add snakes and ladders to grid at given positions
	 */
	private void addSnakesAndLadders() {
		// snakes
		board.put(16, new SnakeSquare(16, 6));
		board.put(47, new SnakeSquare(47, 26));
		board.put(49, new SnakeSquare(49, 11));
		board.put(56, new SnakeSquare(56, 53));
		board.put(62, new SnakeSquare(62, 18));
		board.put(64, new SnakeSquare(64, 60));
		board.put(87, new SnakeSquare(87, 24));
		board.put(92, new SnakeSquare(92, 73));
		board.put(98, new SnakeSquare(98, 78));
		
		// ladders
		board.put(2, new LadderSquare(2, 38));
		board.put(4, new LadderSquare(4, 14));
		board.put(8, new LadderSquare(8, 31));
		board.put(21, new LadderSquare(21, 42));
		board.put(28, new LadderSquare(28, 84));
		board.put(51, new LadderSquare(51, 67));
		board.put(71, new LadderSquare(71, 91));
		board.put(80, new LadderSquare(80, 100));
	}
}

