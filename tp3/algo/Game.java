
import java.util.*;

/**
 * @author Adrien Agez
 * @author Sarah Wissocq
 */
public class Game {
    
    // FIELDS
    private int m;
    private int n;
    private int x;
    private int y;
    
    private static long time = 0;	// Permet de calculer la durée entre 2 time()
    
    // Tableaux pour algo dynamique
    private static Integer[][][][] tab;		// Contient les valeurs calculées
    
    // Bornes pour algo dynamique
    private static int maxM;
    private static int maxN;
    private static int maxX;
    private static int maxY;
    
    
    
    
    public Game(int m, int n, int x, int y) {
        this.m = m; 
        this.n = n; 
        this.x = x; 
        this.y = y;
    }
    
// ####################################################################################
// ######################## VERSION RECURSIVE NAIVE ###################################
// ####################################################################################
    
    public int naif() {
	List<Integer> positif = new LinkedList<Integer>();
	List<Integer> negatif = new LinkedList<Integer>();
	if (m == n && n == 1 && x == y && x == 0) {
            return 0;
	}
	else{
	    for(int i=1;i<=x;i++){
		int res = new Game(m-i,n,x-i,y).naif();
		if(res>0){
		    positif.add(res);
		}
		else{
		    negatif.add(res);
		}
	    }
	    for(int i=x+1;i<m;i++){
		int res = new Game(i,n,x,y).naif();
		if(res>0){
		    positif.add(res);
		}
		else{
		    negatif.add(res);
		}
	}
	    for(int i=1;i<=y;i++){
		int res = new Game(m,n-i,x,y-i).naif();
		if(res>0){
		    positif.add(res);
		}
		else{
		    negatif.add(res);
		}
	    }
	    for(int i=y+1;i<n;i++){
		int res = new Game(m,i,x,y).naif();
		if(res>0){
		    positif.add(res);
		}
		else{
		    negatif.add(res);
		}
	    }
	    if(negatif.isEmpty())
		return -(maximum(positif)+1);
	    else 
		return -(maximum(negatif))+1;
	}
    }
    
    
    
// ########################################################################################    
// ######################## VERSION RECURSIVE DYNAMIQUE ###################################   
// ########################################################################################
   
    public int dynamique(){	// FONCTION D'INITIALISATION
	// Remplissage des tableaux
	tab = new Integer[m+1][n+1][x+1][y+1];
	maxX = x;
	maxY = y;
	for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < x; k++) 
                    for (int l = 0; l < y; l++)
                        tab[i][j][k][l] = null;
	for (int i = 1; i < m; i++) {
            tab[i][1][0][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            tab[1][j][0][0] = 1;
        }
	tab[1][1][0][0] = 0;
        
	int res = this.dynamiqueRec();
	tab = null;
	return res;
    }


// =============== Prise en compte de la symétrie
    private int dynamiqueRec() {
	if (tab[m][n][x][y] != null)
	    return tab[m][n][x][y];
	List<Game> successeurs = this.successeur();
	List<Integer> positif = new LinkedList<Integer>();
	List<Integer> negatif = new LinkedList<Integer>();
	for (Game g : successeurs) {
	    int res = g.dynamiqueRec();
	    if (res > 0)
		positif.add(res);
	    else 
		negatif.add(res);
	}
	int res;
	if(negatif.isEmpty())
	    res = -(maximum(positif)+1);
	else
	    res = -(maximum(negatif))+1; 
	calculated(res);
	return res;
    }
    
    private void calculated(int value) {
	int aux1 = m-(x+1);
	int aux2 = n-(y+1);
	tab[m][n][x][y] = value;
	
	// Symétries
	if (aux1 < maxX) {
	    tab[m][n][aux1][y] = value;
	}
	if (aux2 < maxY) {
	    tab[m][n][x][aux2] = value;
	    if (aux1 < maxX) {
		tab[m][n][aux1][aux2] = value;
	    }
	}
	
	// Rotations (ralentit le code, trop de if ?)
// 	if (m < maxN && n < maxM) {
// 	    if (x < maxY && y < maxX)
// 		tab[n][m][y][x] = value;
// 	    if (aux1 < maxY) {
// 		tab[n][m][y][aux1] = value;
// 	    }
// 	    if (aux2 < maxX) {
// 		tab[n][m][aux2][x] = value;
// 		if (aux1 < maxY) {
// 		    tab[n][m][aux2][aux1] = value;
// 		}
// 	    }
// 	}
    }
    
// ##################################################################################
// ######################## FONCTIONS UTILITAIRES ###################################
// ##################################################################################
    
    public List<Game> successeur(){
	List<Game> res = new ArrayList<Game>();
        for (int idx = 1; idx < m; idx++) {
            if (x >= idx)                              // Coupure verticale avant le carré
                res.add(new Game(m-idx , n, x-idx, y));
            else                                        // Coupure verticale après le carré
                res.add(new Game(idx, n, x, y));
        }
        for (int idx = 1; idx < n; idx++) {
            if (y >= idx)                              // Coupure horizontale avant le carré
                res.add(new Game(m , n-idx, x, y-idx));
            else                                        // Coupure horizontale après le carré
                res.add(new Game(m, idx, x, y));
	}
	return res;
    }
    
    public static Integer maximum(List<Integer> l){
	Integer res=l.get(0);
	for(Integer i : l)
	    if(i.compareTo(res)>0)
		res=i;
	return res;
    }
    
    /**
     * @return La durée écoulée en secondes depuis le dernier time()
     */
    private static double time() {
	long prev = time;
	long now = System.nanoTime();
	time = now;
	return ((double) (now - prev)) / 1000000000.;
    }
    
    private boolean validate() {
	return x < m && y < n;
    }
    
    private void printView() {}
    
    // Inherited from Object
    public String toString() {
	return "(" + m + ", " + n + ", " + x + ", " + y + ")";
    }
    
    public boolean equals(Object o) {
	if (!(o instanceof Game))
	    return false;
	Game g = (Game) o;
	return m == g.m && n == g.n && x == g.x && y == g.y;
    }
    
    public int hashCode() {
	return this.toString().hashCode();
    }
    
// #################################################################################
// ######################### AUTRES ALGORITHMES ####################################
// #################################################################################


    public static Set<Game> configs(int m, int n, int value){	// FONCTION D'INITIALISATION
	// Remplissage des tableaux
	tab = new Integer[m+1][n+1][(m+1)/2][(n+1)/2];
	maxX = (m+1)/2;
	maxY = (n+1)/2;
	for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                for (int k = 0; k < m/2; k++) 
                    for (int l = 0; l < n/2; l++)
                        tab[i][j][k][l] = null;
	for (int i = 1; i < m; i++) {
            tab[i][1][0][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            tab[1][j][0][0] = 1;
        }
	tab[1][1][0][0] = 0;
        Set<Game> games = new HashSet<Game>();
        for (int i = 0; i < (m+1)/2; i++) {
	    for (int j = 0; j < (n+1)/2; j++) {
		Game g = new Game(m, n, i, j);
		int res = g.dynamiqueRec();
		if (res == value) {
		    games.add(g);
		    games.add(new Game(m, n, m-(i+1), j));
		    games.add(new Game(m, n, i, n-(j+1)));
		    games.add(new Game(m, n, m-(i+1), n-(j+1)));
		    System.out.println("================================");
		    System.out.println("Add " + g);
		    System.out.println("================================");
		} else
		    System.out.println("tried " + g);
	    }
	}
	tab = null;
	return games;
    }
// #################################################################################    
// ################################## MAIN #########################################
// #################################################################################

    public void printNaif() {
	System.out.println("naif("+m+","+n+","+x+","+y+") = " + new Game(m,n,x,y).naif() + ", time = " + time() + " secondes");
    }
    
    public void printDynamique() {
	System.out.println("dynamique("+m+","+n+","+x+","+y+") = " + new Game(m,n,x,y).dynamique() + ", time = " + time() + " secondes");
    }
    
    public static void usage() {
	System.out.println("usage : ");
	System.out.println("java Game m n i j");
	System.out.println("Avec m et n le nombre de lignes et de colonnes");
	System.out.println("Et i et j la position du carré de la mort");
    }


    public static void main(String[] args) {

/*	Pas de paramètre, teste la vitesse des 2 algos /
		time();
		new Game(3,2,2,0).printNaif();
		new Game(10,7,7,3).printNaif();
		new Game(10,7,5,3).printNaif();
		
		new Game(3,2,2,0).printDynamique();
		new Game(10,7,7,3).printDynamique();
		new Game(10,7,5,3).printDynamique();
/* */


  
    /*	Passer 4 entiers en paramètres pour calculer la valeur du jeu 	/
	
	if (! (args.length == 4))
	    usage();
		else {
		    try {
			    int m = Integer.parseInt(args[0]);
			    int n = Integer.parseInt(args[1]);
			    int x = Integer.parseInt(args[2]);
			    int y = Integer.parseInt(args[3]);
			    time();
			    new Game(m, n, x, y).printDynamique();
		    } catch (NumberFormatException e) {
			    usage();
		    }
		}
/* */



/*	Pas de paramètre, réponse question 5 (execution ~3min40 au m5)	*/
		System.out.println(configs(127,127,127));
/* */
    }
}
