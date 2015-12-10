package regina;


import java.util.ArrayList;
import java.util.ListIterator;


/**
 * @author Adrien Agez
 * @author Sarah Wissocq
 */
public class Certificat extends ArrayList<Slice>{
	
	private int score = 0;

	private static final long serialVersionUID = -5613669017867118177L;

	public boolean verifie(Pizza pizza) {
        // Pizza size
        int r = pizza.getNbRows();
        int c = pizza.getNbCols();
        boolean[][] overlap = new boolean[r][c];
        for (int i = 0; i < r; i++) 
        	for (int j = 0; j < c; j++)
        		overlap[i][j] = false;
        
        ListIterator<Slice> mainIt = this.listIterator();
	
    masterLoop:
		while (mainIt.hasNext()) {
			Slice slice = mainIt.next();
			// Check slice size
			int row1 = slice.getRow1();
			int row2 = slice.getRow2();
			int col1 = slice.getCol1();
			int col2 = slice.getCol2();
			if (row2 >= r || col2 >= c 
					|| row1 < 0 || col1 < 0 
					|| slice.getSize() > pizza.getMaxSize())
				return false; // Slice to big or "out of pizza"
			
			for (int i = row1; i <= row2; i++) {
				for (int j = col1; j <= col2; j++) {
					if (overlap[i][j] == true)
						return false;
					overlap[i][j] = true;
				}
			}
			
			// Check if enough ham on slice
			int nbHam = 0;
			for (int i = row1; i <= row2; i++)
				for (int j = col1; j <= col2; j++)
					if (pizza.getCell(i, j) == 'H')
						if (++nbHam >= pizza.getMinHam())
							continue masterLoop; // Enough ham, next slice
			return false; // If not enough ham
		}
		return true;
    }
	
	public int score() {
		if (this.score == 0){
			for (Slice slice : this) {
				this.score += slice.getSize();
			}
		}
		return this.score;
	}
	
	@Override
	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append(this.size());
		build.append("\n");
		for (Slice slice : this) {
			build.append(slice.toString());
			build.append("\n");
		}
		return build.toString();
	}
	
	
    
    
}
