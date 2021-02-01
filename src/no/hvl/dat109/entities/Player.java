package no.hvl.dat109.entities;

public class Player {

	private String name;
	private Piece piece;
	private boolean canMove;
	
	/**
	 * Creates a new player.
	 * @param name name of the player
	 */
	public Player(String name) {
		this.name = name;
		this.canMove = true;
	}
	
	public String getName() {
		return name;
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	/**
	 * Simulates current turn for the player and its piece.
	 * @param die Dice-object
	 */
	public void doMove(Dice die) {
		int numSixes = 0;
		int dieRoll;
		
		do {
			dieRoll = die.roll();
			
			if (!canMove && dieRoll != 6) {
				System.out.printf("[%s] rolled %d | Has to roll a 6 to move piece.\n", name.toUpperCase(), dieRoll);
				break;
			} else if (!canMove && dieRoll == 6) {
				canMove = true;
			}
			
			piece.move(dieRoll);
			System.out.printf("[%s] rolled %d | MOVE %d -> %d\n", name.toUpperCase(), dieRoll, (piece.getSquare().getNumber() - dieRoll),
					(piece.getSquare().getNumber()));
			
			if (piece.getSquare() instanceof LadderSquare || piece.getSquare() instanceof SnakeSquare) {
				int newPosition = piece.getSquare().getMapping();
				System.out.printf("%d is a %s! MOVE %d -> %d\n", piece.getSquare().getNumber(), 
						(piece.getSquare().toString()), 
						piece.getSquare().getNumber(), newPosition);
					piece.moveToPosition(newPosition);
			}
			
			if (dieRoll == 6) {
				System.out.println("You rolled a 6! Roll again.");
				numSixes++;
				if (numSixes == 3) {
					piece.moveToPosition(1);
					canMove = false;
					System.out.printf("Three 6s in a row | %s moves back to start...\n", name.toUpperCase());
					break;
				}
			}
			
		} while (dieRoll == 6);
	}
}
