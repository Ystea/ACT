package regina;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class CertificatTest {

	private static final char[][] pizza1 = 
		{{'T', 'T', 'T', 'T', 'T'},
			{'T', 'H', 'H', 'H', 'T'},
			{'T', 'T', 'T', 'T', 'T'}};

			
	private static final char[][] pizza2 = 
	{{'T', 'H', 'H', 'T', 'T'},
		{'T', 'T', 'T', 'T', 'T'},
		{'T', 'T', 'T', 'T', 'T'}};
	
	
	private static Certificat certif1 = new Certificat();
	private static Certificat certif2 = new Certificat();
	private static Certificat certif3 = new Certificat();
	private static Certificat certif4 = new Certificat();
	
	static {
		certif1.add(new Slice(0, 2, 0, 1));
		certif1.add(new Slice(0, 2, 2, 2));
		certif1.add(new Slice(0, 2, 3, 4));
		
		certif2.add(new Slice(0, 2, 0, 1));
		certif2.add(new Slice(0, 2, 2, 2));
		certif2.add(new Slice(0, 2, 3, 5)); // Part en dehors de la pizza
		
		certif3.add(new Slice(0, 2, 0, 1));
		certif3.add(new Slice(0, 2, 2, 2));
		certif3.add(new Slice(0, 2, 2, 4)); // Chevauchement avec une autre part
		
		certif4.add(new Slice(0, 2, 0, 1));
		certif4.add(new Slice(0, 2, 2, 4)); // Part de taille 9
		certif4.add(new Slice(0, 2, 3, 3)); // Part incluse dans une autre part
	}
	
	
	@Test
	public void verifieTest() {
		assertTrue("Certificat OK", certif1.verifie(new Pizza(pizza1, 6, 1)));
		assertFalse("Parts trop grandes", certif1.verifie(new Pizza(pizza1, 5, 1)));
		assertFalse("Parts \"non royale\"", certif1.verifie(new Pizza(pizza2, 6, 1)));
		
		assertFalse("Parts hors de la pizza", certif2.verifie(new Pizza(pizza1, 6, 1)));
		assertFalse("Parts hors de la pizza", certif2.verifie(new Pizza(pizza2, 6, 1)));
		
		assertFalse("Des parts se chevauchent", certif3.verifie(new Pizza(pizza1, 6, 1)));
		
		assertFalse("Une part est incluse dans une autre part", certif4.verifie(new Pizza(pizza1, 9, 1)));
		certif4.remove(2);
		assertTrue("Certificat OK", certif4.verifie(new Pizza(pizza1, 9, 1)));
		assertFalse("Une part est trop grande", certif4.verifie(new Pizza(pizza1, 6, 1)));
	}

}

