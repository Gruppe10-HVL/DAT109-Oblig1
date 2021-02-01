package no.hvl.dat109.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat109.entities.Board;
import no.hvl.dat109.entities.Dice;
import no.hvl.dat109.entities.Piece;
import no.hvl.dat109.entities.Player;
import no.hvl.dat109.entities.Square;
import no.hvl.dat109.game.Game;

class GameTest {
	
	private Board board;
	private Map<Integer, Square> grid;
	Piece piece;
	private Dice die;
	
	private final int GRID_SIZE = 100;
	private final Player player = new Player("Henrik");

	@BeforeEach
	public void setup() {
		board = new Board();
		player.setPiece(new Piece("", board));
		grid = board.getGrid();
		piece = new Piece("", board);
		die = new Dice(6);
	}

	@Test
	public void checkBoardGridSquares() {
		assertEquals(GRID_SIZE, grid.size());
	}
	


	@Test
	public void checkBoardSnakes() {
		assertEquals(6, grid.get(16).getMapping());
		assertEquals(26, grid.get(47).getMapping());
		assertEquals(11, grid.get(49).getMapping());
		assertEquals(53, grid.get(56).getMapping());
		assertEquals(18, grid.get(62).getMapping());
		assertEquals(60, grid.get(64).getMapping());
		assertEquals(24, grid.get(87).getMapping());
		assertEquals(73, grid.get(92).getMapping());
		assertEquals(78, grid.get(98).getMapping());
	}
	
	@Test
	public void checkBoardLadders() {
		assertEquals(38, grid.get(2).getMapping());
		assertEquals(14, grid.get(4).getMapping());
		assertEquals(31, grid.get(8).getMapping());
		assertEquals(42, grid.get(21).getMapping());
		assertEquals(84, grid.get(28).getMapping());
		assertEquals(67, grid.get(51).getMapping());
		assertEquals(91, grid.get(71).getMapping());
		assertEquals(100, grid.get(80).getMapping());
	}
	
	@Test
	public void checkPieceStartingPosition() {
		assertEquals(1, piece.getSquare().getNumber());
	}

	@Test
	public void playerDoesMove() {
		player.doMove(die);
		assertFalse(player.getPiece().getSquare().getNumber() == 1);
	}

	@Test
	public void checkIfPieceMoved() {
		piece.move(6);
		assertEquals(7, piece.getSquare().getNumber());
		
		piece.move(3);
		assertEquals(10, piece.getSquare().getNumber());
		
		piece.move(4);
		assertEquals(14, piece.getSquare().getNumber());
	}

	@Test
	public void checkIfPieceMovedNewPosition() {
		piece.moveToPosition(35);
		assertEquals(35, piece.getSquare().getNumber());

		piece.moveToPosition(12);
		assertEquals(12, piece.getSquare().getNumber());
	}
	
	@Test
	public void checkDiceValues() {
		for (int i = 0; i < 100; i++) {
			int value = die.roll();
			assertTrue(value >= 1 && value <= 6);
		}
	}
}
