package algo;

import java.util.*;

/**
  * @author Adrien Agez
  * @author Sarah Wissocq
  */
public class Game {

    private int m;
    private int n;
    private int i;
    private int j;
    
    
    public Game(int m, int n, int i, int j) {
        i = i;
        j = j;
        m = m;
        n = n;
    }
    
    
    public int naif() {
        if (m == 1 && j == 1)
            return 0;
        List<Game> tab = this.possibilities();
        int[] res = new int[tab.size()];
        for (int idx = 0; i < tab.size();  i++) {
            res[idx] = tab.get(idx).naif();
        }
        return nextValue(res);    
    }
    
    private List<Game> possibilities() {
        List<Game> res = new ArrayList<Game>();
        for (int idx = 1; idx < this.m; idx++) {
            if (m-idx >=0)                              // Coupure verticale avant le carré
                res.add(new Game(m-idx , n, i-idx, j));
            else                                        // Coupure verticale après le carré
                res.add(new Game(idx, n, i, j));
        }
        for (int idx = 1; idx < this.n; idx++) {
            if (n-idx >=0)                              // Coupure horizontale avant le carré
                res.add(new Game(m , n-idx, i, j-idx));
            else                                        // Coupure horizontale après le carré
                res.add(new Game(m, idx, i, j));
         }
         System.out.println(res);
        return res;
    }
    
    private static int nextValue(int[] tab) {
        if (tab.length == 0)        
            return 0;
        int res = tab[0];
        boolean negValue = (res < 0);
        for (int idx = 0; idx < tab.length; idx++) {
            if (negValue) {
                if (tab[idx] < 0 && tab[idx] > res)
                    res = tab[idx];
            }
            else {
                if (tab[idx] < 0) {
                    res = tab[idx];
                    negValue = true;
                }
                else if (tab[idx] > res) 
                    res = tab[idx];
            }
        }
        if (negValue) 
            return -res+1;
        return -res -1;
    }
    
    
    public String toString() {
        return "(" + m + ", " + n + ", " + i + "," + j + ")";
    }
    
}