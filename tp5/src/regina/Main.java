package regina;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
	
	
	public static void main(String[] args) {
		if (args.length < 1)
			System.out.println("java TestPizza  file");
		else {
			Pizza pizza = new Pizza(args[0]);
			int maxScore = 0;
			while (true) {
				Certificat cert = pizza.glouton();
				int score = cert.score();
				if (score > maxScore) {
					maxScore = score;
					extractResultat(cert);
				}
			}

		}

	}
	
	
	
	private static void extractResultat(Certificat cert) {
		File f = new File("resultat_" + cert.score() + ".txt");
		try {
			FileWriter fw = new FileWriter(f);
			fw.write(cert.toString());
			fw.close();
		} catch (IOException e) {
			System.out.println("Erreur lors de l'écruture du fichier :" + e.getMessage());
			e.printStackTrace();
		}
	}
}
