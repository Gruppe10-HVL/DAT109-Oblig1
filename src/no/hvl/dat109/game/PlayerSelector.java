package no.hvl.dat109.game;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import no.hvl.dat109.entities.Piece;
import no.hvl.dat109.entities.Player;

public class PlayerSelector {
	
	private Player[] players;
	private Game game;
	private final String[] PLAYER_AMOUNT_OPTIONS = {"2", "3", "4"};
	private final ArrayList<String> COLORS = new ArrayList<String>(Arrays.asList("Pink", "Black", "Yellow", "White"));
	
	public PlayerSelector(Game game) {
		this.game = game;
	}
	
	/**
	 * User selects the amount of players for the game. Each player must choose
	 * a name and a color. Creates the players and pieces and adds them to the game.
	 */
	public void selectPlayers() {
		JFrame frame = new JFrame("Welcome to Snakes & Ladders");
		JOptionPane.showMessageDialog(frame, "Welcome to Snakes & Ladders");
		int chosenAmountOfPlayers = JOptionPane.showOptionDialog(frame, "Choose amount of players", "Amount of players",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, PLAYER_AMOUNT_OPTIONS, PLAYER_AMOUNT_OPTIONS[0]);
		
		int playerCount = Integer.parseInt(PLAYER_AMOUNT_OPTIONS[chosenAmountOfPlayers]);
		players = new Player[playerCount];
		
		for (int i = 0; i < playerCount; i++) {
			String name = JOptionPane.showInputDialog("Name of player " + (i + 1) + ":");
			int colorChoice = JOptionPane.showOptionDialog(frame, "Choose color", "Chosen piece", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, COLORS.toArray(), COLORS.get(0));
			
			String color = COLORS.get(colorChoice);
			COLORS.remove(colorChoice);
			
			Player p = new Player(name);
			p.setPiece(new Piece(color, game.getBoard()));
			players[i] = p;
		}
		
		if (playerCount >= 2) {
			game.setPlayers(players);
		}
	}
}
