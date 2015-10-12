package comparaisons;

import io.EcritureFichier;

public class ComparaisonRefs {

    static int[] sizes = {1, 2,10,20,30,40,50,100,150,200,300,400,500,1000,1500,2000,5000,10000,25000,50000,75000,100000,250000,500000};
    static FonctionsReference fr = new FonctionsReference(sizes);
    
    public static void main(String[] args) {
	
	/* Création des résultats (comparaison des fonctions de référence) /
	double[][] results = new double[7][];
	results[0] = fr.puissance(1);
	results[1] = fr.logarithme();
	results[2] = fr.nlog();
	results[3] = fr.exp();
	results[4] = fr.puissance(2);
	results[5] = fr.factorielle();
	results[6] = fr.npuissance();

	// Écriture du fichier de résultats
	EcritureFichier.output("data/comparaisons_refs.txt", results, sizes);
	/**/

	/* Création des résultats (limites graphiques) */
	double[][] results = new double[4][];
	results[0] = puissanceVsLog(1);
	results[1] = puissanceVsLog(0.5);
	results[2] = puissanceVsLog(0.2);
	results[3] = puissanceVsLog(0.1);

	// Écriture du fichier de résultats
	EcritureFichier.output("data/comparaisons_refs.txt", results, sizes);
	/**/



    }

    public static double[] puissanceVsLog(double epsilon) {
	double[] puissance = fr.puissance(epsilon);
	double[] log = fr.logarithme();
	double[] res = new double[sizes.length];

	for (int idx = 0; idx < sizes.length; idx++) {
	    res[idx] = puissance[idx] / log[idx];
	}
	return res;
    }
	
}
