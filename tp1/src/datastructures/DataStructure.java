package datastructures;

public interface DataStructure {
	
	/**
	 * Place des éléments aléatoires dans la structure de données.
	 */
	public void alea();
	
	/**
	 * Test la présence de e dans la structure de données
	 * @param e Élément à rechercher
	 * @return vrai si l'élément est trouvé
	 */
	public boolean recherche(int e);
	
	/**
	 * Recherche l'élément minimum dans l'ensemble des élements de la structure
	 * @return l'élément minimum
	 */
	public int minimumSimple();
	/**
	 * Recherche l'élément minimum dans l'ensemble des élements de la structure
	 * en commencant par trier les éléments pour ensuite prendre le premier.
	 * @return l'élément minimum
	 */
	public int minimumTri();
	
	/**
	 *  ???
	 */
	public void mystere();
	
}
