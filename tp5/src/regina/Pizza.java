package regina;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
    
    public Pizza(String filename) {
		try {
			Scanner donnee = new Scanner(new FileReader(filename));
			int height = donnee.nextInt();
			int width = donnee.nextInt();
			minHam = donnee.nextInt();
			maxSize = donnee.nextInt();
			array = new char[height][width];
			int l = 0;
			while(donnee.hasNext()) { 
				String line = donnee.next();
				array[l++] = line.toCharArray();
			}
			donnee.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }

    // ### GETTERS / SETTERS ###
    
    public char[][] getArray() {
        return this.array;
    }
    
    public char getCell(int x, int y) {
		return array[x][y];
	}
    
    public int getNbRows() {
    	return array.length;
    }
    
    public int getNbCols() {
    	return array[0].length;
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
    
    // ### OTHERS METHODS ###
    
    public List<Slice> generateAllSlice() {
    	List<Slice> res = new ArrayList<Slice>();
    	for (int i1 = 0; i1 < getNbRows(); i1++)
    		for (int j1 = 0; j1 < getNbCols(); j1++)
    			for (int i2 = i1; i2 < getNbRows(); i2++)
    				for (int j2 = j1; j2 < getNbCols(); j2++)
    					res.add(new Slice(i1, i2, j1, j2));
    	return res;
    }
    
    public Certificat random() {
    	List<Slice> allSlices = generateAllSlice();
    	Collections.shuffle(allSlices);
    	boolean[][] overlap = new boolean[getNbRows()][getNbCols()];
        for (int i = 0; i < getNbRows(); i++) 
        	for (int j = 0; j < getNbCols(); j++)
        		overlap[i][j] = false;
    	
        Certificat res = new Certificat();
        masterLoop: 
        for (Slice slice : allSlices) {
        	int ham = 0;
        	if (slice.getSize() <= maxSize) {
        		for (int i = slice.getRow1(); i <= slice.getRow2(); i++) {
        			for (int j = slice.getCol1(); j <= slice.getCol2(); j++) {
        				if (overlap[i][j])
        					continue masterLoop;
        				if (array[i][j] == 'H')
        					ham++;
        			}
        		}
        		if (ham >= minHam) {
        			res.add(slice);
        			for (int i = slice.getRow1(); i <= slice.getRow2(); i++)
            			for (int j = slice.getCol1(); j <= slice.getCol2(); j++)
            				overlap[i][j] = true;
        		}
        	}
        }
    	return res;
    }
    
    
}
