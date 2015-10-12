package algo;

import java.util.*;

import algo.Point;

/**
 * @author Adrien Agez
 * @author Sarah Wissocq
 */
public class LigneToit extends ArrayList<Point> {

    public LigneToit fusion(LigneToit that) {    
        if (this.isEmpty()) { return that; }
        if (that.isEmpty()) { return this; }
        this.add(new Point(-42, -42));
	that.add(new Point(-42, -42));
        LigneToit res = new LigneToit();
        int h1 = 0, h2 = 0;
        int x1, x2, y1, y2;
        Point p1, p2 = null;
        Iterator<Point> l1 = this.iterator();
        Iterator<Point> l2 = that.iterator();
        
        p1 = l1.next();
        p2 = l2.next();
        
	while(l1.hasNext() && l2.hasNext()){
	    x1=p1.getX();
	    x2=p2.getX();
	    y1=p1.getY();
	    y2=p2.getY();
	    if (x1 == x2) {
                res.add(new Point(x1, Math.max(y1, y2)));
                p1 = l1.next(); p2 = l2.next();
	    }
	    else  if (y1 == y2) {
                res.add(new Point(Math.max(x1, x2),y1));
                p1 = l1.next(); p2 = l2.next();
	    }
	    else if(x1<x2){

		if(y1>y2 && (y1==0|| y2==0)){
		    res.add(new Point(Math.max(x1,x2),Math.max(y1,y2)));
		    p1=l1.next();
		    p2=l2.next();
		}
		else{
		    res.add(p1);
		p1=l1.next();
		}
	    }
	    else{
		if(y1<y2 && (y1==0|| y2==0)){
		    res.add(new Point(Math.max(x1,x2),Math.max(y1,y2)));
		    p1=l1.next();
		    p2=l2.next();
		}
		else{
		res.add(p2);
		p2=l2.next();
		}
	    }
	}  
	while(l1.hasNext() && p1.getX()!=-42){
	    res.add(p1);
	    p1=l1.next();
	}
	while(l2.hasNext() && p2.getX()!=-42){
	    res.add(p2);
	    p2=l2.next();
	}
	return res;

    }
    
    
    public static LigneToit createLigne(int n, List<Immeuble> l) {
        if (n == 0)
            return new LigneToit();
        else if (n == 1)
            return l.get(0).ligneToit();
        else {
            List<Immeuble> l1 = l.subList(0, n/2);
            List<Immeuble> l2 = l.subList(n/2+1, n-1);
            return createLigne(l1.size(), l1).fusion(createLigne(l2.size(), l2));
        }
    }
}
