package algo;

import java.util.*;

/**
 * @author Adrien Agez
 * @author Sarah Wissocq
 */
public class Game {
    
    public static int naif(int m, int n, int x, int y) {
	List<Integer> positif = new LinkedList<Integer>();
	List<Integer> negatif = new LinkedList<Integer>();
	if (m==n && n == 1 && x==y && x==0){
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
	
	return 0;
    }

    public static void main(String[] args) {
	System.out.println(naif(3,2,2,0));
	long temps=System.nanoTime();
	System.out.println(naif(10,7,7,3));
	System.out.println("naif(10,7,7,3) = " +(System.nanoTime() - temps));
	temps=System.nanoTime();
	System.out.println(naif(10,7,5,3));
	System.out.println("naif(10,7,5,3) = " +(System.nanoTime() - temps));
	System.out.println(dynamique(100,100,50,50));
	System.out.println(dynamique(100,100,48,52));
    }
}
