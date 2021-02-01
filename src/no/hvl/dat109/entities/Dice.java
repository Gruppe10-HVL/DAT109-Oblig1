package no.hvl.dat109.entities;

import java.util.Random;

public class Dice {
	
	private Random r;
	private int faces;
	
	/**
	 * Creates a new die
	 * @param faces number of faces on the die
	 */
	public Dice(int faces) {
		r = new Random();
		this.faces = faces;
	}
	
	/**
	 * Throw the die
	 * @return int die value
	 */
	public int roll() {
		return r.nextInt(faces) + 1;
	}
}
