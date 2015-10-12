package algo;

import java.util.*;

import algo.LigneToit;
import algo.Point;

/**
 * @author Adrien Agez
 * @author Sarah Wissocq
 */
public class Main {


    public static void main(String args[]) {
        LigneToit test1 = new LigneToit();
        LigneToit test2 = new LigneToit(); 
//      List<Immeuble> test1 = new ArrayList<Immeuble>();
       
	test1.add(new Point(1,10));
        test1.add(new Point(5,6));
        test1.add(new Point(8,0));
        test1.add(new Point(10,8));
        test1.add(new Point(12,0));
        
        test2.add(new Point(2,12));
        test2.add(new Point(7,0));
        test2.add(new Point(9,4));
        test2.add(new Point(11,2));
        test2.add(new Point(14,0));
        

 	/*test1.add(new Point(1,11));
        test1.add(new Point(3,13));
        test1.add(new Point(9,0));
        test1.add(new Point(12,7));
        test1.add(new Point(16,0));

        
        test2.add(new Point(3,6));
        test2.add(new Point(7,0));
        test2.add(new Point(16,3));
        test2.add(new Point(19,18));
        test2.add(new Point(22,3));
        test2.add(new Point(25,0)); /* */
        
        
        
        /*test1.add(new Immeuble(3,13,9));
        test1.add(new Immeuble(1,11,5));
        test1.add(new Immeuble(19,18,22));
        test1.add(new Immeuble(3,6,7));
        test1.add(new Immeuble(16,3,25));
        test1.add(new Immeuble(12,7,16))*/;
        
        System.out.println(test1.fusion(test2));
    }
    
}
