package no.hvl.dat109.entities;

public class SnakeSquare extends Square {
    
    private int mapping;

    /**
     * Constructs a SnakeSquare-object which is mapped to
     * another square by its positional number.
     * @param number position of current square
     * @param mapping position of mapped square
     */
    public SnakeSquare(int number, int mapping) {
        super(number);
        this.mapping = mapping;
    }

    @Override
    public int getMapping() {
        return mapping;
    }

    @Override
    public void setMapping(int mapping) {
        this.mapping = mapping;
    }

    @Override
    public String toString() {
        return "snake";
    }
}
