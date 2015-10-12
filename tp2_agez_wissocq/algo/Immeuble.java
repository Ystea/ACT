package algo;

import algo.*;

/**
  * @author Adrien Agez
  * @author Sarah Wissocq
  */
public class Immeuble {


    private int g;
    private int h;
    private int d;
    
    
    public Immeuble(int g, int h, int d) {
        this.g = g;
        this.h = h;
        this.d = d;
    }
    
    public Immeuble() {
        this(0, 0, 0);
    }
    
    public LigneToit ligneToit() {
        LigneToit res = new LigneToit();
        res.add(new Point(g, 0));
        res.add(new Point(g, h));
        res.add(new Point(d, h));
        res.add(new Point(d, 0));
        return res;
    }
   
}