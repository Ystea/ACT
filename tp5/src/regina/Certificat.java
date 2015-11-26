package regina;

import java.util.LinkedList;

/**
 * @author Adrien Agez
 * @author Sarah Wissocq
 */
public class Certificat extends LinkedList<Slice> {

    // Eclipse generated serialVersionUID
	private static final long serialVersionUID = 2667187783214454685L;

	public boolean verifie(Pizza pizza) {
        // Pizza size
        int r = pizza.getArray().length;
        int c = pizza.getArray()[0].length;
        
	masterLoop:
		for (Slice slice : this) {
			// Slice size
			int row1 = slice.getRow1();
			int row2 = slice.getRow2();
			int col1 = slice.getCol1();
			int col2 = slice.getCol2();
			if (row2 >= r || col2 >= c 
					|| row1 < 0 || col1 < 0 
					|| slice.getSize() > pizza.getMaxSize())
				return false; // Slice to big or "out of pizza"
			
			// Check if enough ham on slice
			int nbHam = 0;
			for (int i = row1; i <= row2; i++) {
				for (int j = col1; j <= col2; j++) {
					if (pizza.getCell(i, j) == 'H')
						if (++nbHam >= pizza.getMinHam())
							continue masterLoop;
				}
			}
			return false; // If not enough ham
		}
		return true;
    }
    
    
    
}
