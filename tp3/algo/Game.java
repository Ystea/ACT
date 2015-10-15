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
    
    public Game(int m, int n, int x, int y) {
        m = m; n = n; i = i; j = j;
    }
    
    public static int naif() {
	List<Integer> positif = new LinkedList<Integer>();
	List<Integer> negatif = new LinkedList<Integer>();
	if (m==n && n == 1 && x==y && x==0) {
            return 0;
	}
	else{
	    for(int i=1;i<=x;i++){
		int res=naif(m-i,n,x-i,y);
		if(res>0){
		    positif.add(res);
		}
		else{
		    negatif.add(res);
		}
	    }
	    for(int i=x+1;i<m;i++){
		int res=naif(i,n,x,y);
		if(res>0){
		    positif.add(res);
		}
		else{
		    negatif.add(res);
		}
	    }
	    for(int i=1;i<=y;i++){
		int res=naif(m,n-i,x,y-i);
		if(res>0){
		    positif.add(res);
		}
		else{
		    negatif.add(res);
		}
	    }
	    for(int i=y+1;i<n;i++){
		int res=naif(m,i,x,y);
		if(res>0){
		    positif.add(res);
		}
		else{
		    negatif.add(res);
		}
	    }
	    if(negatif.isEmpty()){
		return -(maximum(positif)+1);
	    }
	    else{
		return -(maximum(negatif))+1;
	    }
	}
    }


    public static Integer maximum(List<Integer> l){
	Integer res=l.get(0);
	for(Integer i : l){
	    if(i.compareTo(res)>0){
		res=i;
	    }
	}
	return res;
    }

   
    public static int dynamique(){
    /** Initialisation des tableaux*/
	int[][][][] tab = new int[m][n][x][y];
	boolean[][][][] calc = new boolean[m][n][x][y];
	/** Remplissage des tableaux*/
	tab[1][1][0][0]=0;
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
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < i-1; k++) {
                    for (int l = 0; l < j-1; l++) {
                        List<Quadruplet> succes = successeur(i, j, k, l);
                        
                    }
                }
            }
        }
	return 0;
    }
    
    
    public static List<Quadruplet> successeur(int m, int n, int x, int y){
    List<Quadruplet> res = new ArrayList<Quadruplet>();
        for (int idx = 1; idx < this.m; idx++) {
            if (m-idx >=0)                              // Coupure verticale avant le carré
                res.add(new Quadruplet(m-idx , n, x-idx, y));
            else                                        // Coupure verticale après le carré
                res.add(new Quadruplet(idx, n, x, y));
        }
        for (int idx = 1; idx < this.n; idx++) {
            if (n-idx >=0)                              // Coupure horizontale avant le carré
                res.add(new Quadruplet(m , n-idx, x, y-idx));
            else                                        // Coupure horizontale après le carré
                res.add(new Quadruplet(m, idx, i, j));
            }
    }

    public static void main(String[] args) {
	System.out.println(new Game(3,2,2,0).naif());
	long temps=System.nanoTime();
	System.out.println(new Game(10,7,7,3).naif());
	System.out.println("naif(10,7,7,3) = " +(System.nanoTime() - temps));
	temps=System.nanoTime();
	System.out.println(new Game(10,7,5,3).naif());
	System.out.println("naif(10,7,5,3) = " +(System.nanoTime() - temps));
    }
}
