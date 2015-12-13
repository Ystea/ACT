package regina;

import java.io.FileNotFoundException;
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
    
    private List<Slice> allSlices;

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
		} catch (FileNotFoundException e) {
			System.out.println("Fichier de données " + filename + " non trouvé");
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
    
    public List<Slice> generateAllSlices() {
    	if (allSlices != null) {
    		return allSlices;
    	}
    	List<Slice> res = new ArrayList<Slice>();
    	for (int i1 = 0; i1 < getNbRows(); i1++) {
    		for (int j1 = 0; j1 < getNbCols(); j1++) {
    			for (int i2 = i1; i2 < getNbRows(); i2++) {
    				for (int j2 = j1; j2 < getNbCols(); j2++) {
    					Slice slice = new Slice(i1, i2, j1, j2);
    					int ham = 0;
    					if(slice.getSize() <= this.maxSize){
    						for (int i = slice.getRow1(); i <= slice.getRow2(); i++) {
    		        			for (int j = slice.getCol1(); j <= slice.getCol2(); j++) {
    		        				if (array[i][j] == 'H')
    		        					ham++;
    		        			}
    		        		}
    						if (ham >= minHam)
    							res.add(slice);
    					}
    				}
    			}
    		}
    	}
    	allSlices = res;
    	return res;
    }
    
    
    public Certificat random() {
    	int score = 0;
    	List<Slice> allSlices = generateAllSlices();
    	Collections.shuffle(allSlices);
    	boolean[][] overlap = new boolean[getNbRows()][getNbCols()];
        for (int i = 0; i < getNbRows(); i++) 
        	for (int j = 0; j < getNbCols(); j++)
        		overlap[i][j] = false;
    	
        Certificat res = new Certificat();
        masterLoop: 
        for (Slice slice : allSlices) {
    		for (int i = slice.getRow1(); i <= slice.getRow2(); i++) {
    			for (int j = slice.getCol1(); j <= slice.getCol2(); j++) {
    				if (overlap[i][j])
    					continue masterLoop;
    				
    			}
    		}
    		for (int i = slice.getRow1(); i <= slice.getRow2(); i++) {
    			for (int j = slice.getCol1(); j <= slice.getCol2(); j++) {
    				overlap[i][j] = true;
    				score++;
    			}
    		}
    		res.add(slice);
        }
        System.out.println(score);
    	return res;
    }
    
    public Certificat glouton() {
    	// Initialisation
    	Certificat res = new Certificat();
    	List<Slice> allSlices = generateAllSlices();
    	Collections.shuffle(allSlices);
    	Collections.sort(allSlices, Collections.reverseOrder());
    	int score = 0;
    	boolean[][] overlap = new boolean[getNbRows()][getNbCols()];
        for (int i = 0; i < getNbRows(); i++) 
        	for (int j = 0; j < getNbCols(); j++)
        		overlap[i][j] = false;
        
        masterLoop:
    	for (Slice slice : allSlices) {
    		for (int i = slice.getRow1(); i <= slice.getRow2(); i++) {
    			for (int j = slice.getCol1(); j <= slice.getCol2(); j++) {
    				if (overlap[i][j])
    					continue masterLoop;
    			}
    		}
    		for (int i = slice.getRow1(); i <= slice.getRow2(); i++) {
    			for (int j = slice.getCol1(); j <= slice.getCol2(); j++) {
    				overlap[i][j] = true;
    				score++;
    			}
    		}
    		res.add(slice);
    	}
        System.out.println(score);
    	return res;
    }
}
