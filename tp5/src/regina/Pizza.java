package regina;

/**
 * @author Adrien Agez
 * @author Sarah Wissocq
 */
public class Pizza {

    private char[][] array;

    private int maxSize;
    private int minHam;

    public Pizza(char[][] pizza, int maxSize, int minHam) {
        this.array = pizza;
        this.maxSize = maxSize;
        this.minHam = minHam;
    }

    public char[][] getArray() {
        return this.array;
    }
    
    public char getCell(int x, int y) {
		return array[x][y];
	}

    public int getMaxSize() {
        return this.maxSize;
    }
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getMinHam() {
        return this.minHam;
    }
    public void setMinHam(int minHam) {
        this.minHam = minHam;
    }

}
