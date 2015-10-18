package algo;

import java.util.*;
import algo.*;

/**
 * @author Adrien Agez
 * @author Sarah Wissocq
 */
public class Game {
    
    private int m;
    private int n;
    private int x;
    private int y;
    private static long time;
    
    public Game(int m, int n, int x, int y) {
        this.m = m; 
        this.n = n; 
        this.x = x; 
        this.y = y;
    }
    
// ######################## VERSION RECURSIVE NAIVE ###################################    
    
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
    
    
    
    
// ######################## VERSION RECURSIVE DYNAMIQUE ###################################   
   
    public int dynamique(){	// INITIALISATION
    // Initialisation des tableaux
	int[][][][] tab = new int[m+1][n+1][x+1][y+1];
	boolean[][][][] calc = new boolean[m+1][n+1][x+1][y+1];
	// Remplissage des tableaux

	for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < x; k++) 
                    for (int l = 0; l < y; l++)
                        calc[i][j][k][l] = false;
	for (int i = 1; i < m; i++) {
            tab[i][1][0][0] = 1;
            calc[i][1][0][0] = true;
        }
        for (int j = 1; j < n; j++) {
            tab[1][j][0][0] = 1;
            calc[1][j][0][0] = true;
        }
	tab[1][1][0][0] = 0;
        
	return this.dynamiqueRec(tab, calc);
    }
    
    private int dynamiqueRec(int[][][][] tab, boolean[][][][] calc) {
	if (calc[this.m][this.n][this.x][this.y])
	    return tab[this.m][this.n][this.x][this.y];
	List<Game> successeurs = this.successeur();
	List<Integer> positif = new LinkedList<Integer>();
	List<Integer> negatif = new LinkedList<Integer>();
	for (Game g : successeurs) {
	    int res = g.dynamiqueRec(tab, calc);
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
	calc[this.m][this.n][this.x][this.y] = true;
	tab[this.m][this.n][this.x][this.y] = res;
	return res;
    }
    

// ######################## FONCTIONS UTILITAIRES ###################################   
    
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
    
    
    
    public String toString() {
	return "(" + m + ", " + n + ", " + x + ", " + y + ")";
    }
    
    private static double time() {
	long prev = time;
	long now = System.nanoTime();
	time = now;
	return ((double) (now - prev)) / 1000000000.;
    }
    
    
// ######################### AUTRES ALGORITHMES ####################################



    
// ################################## MAIN #########################################

    public void printNaif() {
	System.out.println("naif("+m+","+n+","+x+","+y+") = " + new Game(m,n,x,y).naif() + ", time = " + time() + " secondes");
    }
    
    public void printDynamique() {
	System.out.println("dynamique("+m+","+n+","+x+","+y+") = " + new Game(m,n,x,y).dynamique() + ", time = " + time() + " secondes");
    }
    
    public static void usage() {
		System.out.println("usage : ");
		System.out.println("java algo.Game m n i j");
    }

    public static void main(String[] args) {
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

// 		time();
// 		printNaif(3,2,2,0);
// 		printNaif(10,7,7,3);
// 		printNaif(10,7,5,3);
// 		
// 		printDynamique(3,2,2,0);
// 		printDynamique(10,7,7,3);
// 		printDynamique(10,7,5,3);
	}
}
