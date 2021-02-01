package no.hvl.dat109.entities;

public class LadderSquare extends Square {
    
    private int mapping;

    /**
     * Constructs a LadderSquare-object which is mapped to
     * another square by its positional number.
     * @param number position of current square
     * @param mapping position of mapped square
     */
    public LadderSquare(int number, int mapping) {
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
        return "ladder";
    }
}
