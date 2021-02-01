package no.hvl.dat109.game;

public class GameController {

	public static void main(String[] args) {
		Game game = new Game();
		PlayerSelector ps = new PlayerSelector(game);
		
		ps.selectPlayers();
		game.run();
	}
}
