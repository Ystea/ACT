package regina;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {
	
	
	public static void main(String[] args) {
		if (args.length < 1)
			System.out.println("java TestPizza  file");
		else {
			Pizza pizza = null;
			try {
				Scanner donnee = new Scanner(new FileReader(args[0]));
				System.out.println("Fichier lu:");
				int l = donnee.nextInt();
				System.out.print(l + " ");
				int h = donnee.nextInt();
				System.out.print(h + " ");
				int n = donnee.nextInt();
				System.out.print(n + " ");
				int c = donnee.nextInt();
				System.out.println(c + " ");
				char[][] array = new char[l][h];
	
				for (int i = 0; i < l; i++) {
					String line = donnee.next();
					for (int j = 0; j < h; j++) {
						array[i][j] = line.charAt(j);
					}
				}
				donnee.close();
				pizza = new Pizza(array, c, n);
			} catch (FileNotFoundException e) {
				System.out.println("J'ai pas trouvé");
				e.printStackTrace();
			}
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
	
	static private void extractResultat(Certificat cert) {
		File f = new File("resultat_" + cert.score() + ".txt");
		try {
			FileWriter fw = new FileWriter(f);
			fw.write(cert.toString());
			fw.close();
		} catch (IOException e) {
			System.out.println("Il y a eu une erreur lors de l'écriture sur le fichier :" + e.getMessage());
		}
	}
}
