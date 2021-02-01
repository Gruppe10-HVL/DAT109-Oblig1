package no.hvl.dat109.entities;

public class RegularSquare extends Square{
	
	public RegularSquare(int number) {
		super(number);
	}
	
	@Override
	public int getMapping() {
		return number;
	}

	@Override
	public void setMapping(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "regular square";
	}
}
