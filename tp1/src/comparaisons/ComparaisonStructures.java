package comparaisons;

import datastructures.Tableau;
import io.EcritureFichier;

public class ComparaisonStructures {

	public static void main(String[] args) {
		// Les valeurs de x à tester pour tracer nos courbes
		int[] sizes = {2,10,20,30,40,50,100,150,200,300,400,500,1000,1500,2000,5000,10000,25000,50000,75000,100000,250000,500000};
		double[] results = new double[sizes.length];
		
		// Création des résultats
		for (int idx=0 ; idx<sizes.length ; idx++) {
			Tableau l = new Tableau(sizes[idx]);
			results[idx] = Mesures.mesureAlea(l);
		}
		
		// Écriture du fichier de résultats
		EcritureFichier.output("data/alea_tableau_1.txt", results, sizes);
	}
	
}
