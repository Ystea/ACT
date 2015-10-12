package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EcritureFichier {

	private EcritureFichier () {};

	/** Enregistre dans un fichier les valeurs contenues dans le tableau a deux dimension
	 *  res en faisant preceder chaque ligne de la taille de donnee contenue dans sizes[].
	 *  Les tableaux res[j] pour j verifiant 0 <= j < res.length sont ainsi affiches en
	 *  colonnes successives apres la colonne de sizes[]. */
	public static void output (String filename, double[][] res, int[] sizes) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			
			for (int i = 0 ; i < res[0].length ; i++) {
				bw.write("" + sizes[i]);
				for (int j = 0 ; j < res.length ; j++) {
					bw.write(" "+res[j][i]);
				}
				bw.newLine();
			}
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** Enregistre dans un fichier les valeurs contenues dans le tableau res en faisant
	 *  preceder chaque ligne de la taille de donnee contenue dans sizes[]. */
	public static void output (String filename, double[] res, int[] sizes) {
		double[][] resDouble = new double[1][];
		resDouble[0] = res;
		EcritureFichier.output(filename, resDouble, sizes);
	}
}
