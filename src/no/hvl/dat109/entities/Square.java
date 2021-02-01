package no.hvl.dat109.entities;

public abstract class Square {
    
    protected int number;

    /**
     * Constructor for Square-object. A square has a
     * positional number of its current position.
     * @param number position of current square
     */
    public Square(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public abstract int getMapping();

    public abstract void setMapping(int mapping);

    public abstract String toString();

    /**
     * Checks if current square is finish square
     * @return true if finish square, else false
     */
    public boolean isFinish() {
        return number == 100;
    }
}
