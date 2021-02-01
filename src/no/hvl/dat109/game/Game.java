package no.hvl.dat109.game;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import no.hvl.dat109.entities.Board;
import no.hvl.dat109.entities.Dice;
import no.hvl.dat109.entities.Player;

public class Game {
	
	private Player[] players;
	private Board board;
	private Dice die;
	private boolean isGameWon;
	Map<Integer, Integer> snakes = new HashMap<Integer, Integer>();
	Map<Integer, Integer> ladders = new HashMap<Integer, Integer>();
	
	/**
	 * Creates a new game
	 * @param playerCount 
	 */
	public Game() {
		board = new Board();
		die = new Dice(6);
		isGameWon = false;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	
	/**
	 * Run the game.
	 */
	public void run() {
		int turnCounter = 1;
		System.out.println("Game starting...");
		
		while (!isGameWon) {
			System.out.printf("----- ROUND %d -----\n", turnCounter);
			playTurn();
			turnCounter++;
		}
		
		String winner = findWinner();
		System.out.printf("***** %s won the game! *****\n", winner);
		
		System.out.println("Game ending...");
		System.exit(1);
	}
	
	/**
	 * Plays current turn for each player in the game.
	 */
	public void playTurn() {
		for (Player player: players) {
			player.doMove(die);
			if (player.getPiece().getSquare().isFinish()) {
				isGameWon = true;
				break;
			}
			System.out.println();
		}
	}
	
	/**
	 * Finds winning player.
	 * @return String name of winning player
	 */
	public String findWinner() {
		return Arrays.stream(players)
					.filter(s -> s.getPiece().getSquare().isFinish())
					.map(s -> s.getName())
					.collect(Collectors.joining());
	}
}
