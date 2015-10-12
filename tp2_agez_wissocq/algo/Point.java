package algo;

/**
 * @author Adrien Agez
 * @author Sarah Wissocq
 */
public class Point implements Comparable<Point>{

    private int x;
    private int y;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
    }

    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
  /* /
    public int maxX(Point that) {
        if (this.x > that.x)
            return this.x;
        return that.x;
    }
    
    public int maxY(Point that) {
        if (this.y > that.y)
            return this.y;
        return that.y;
    }
    /**/
     public boolean equals(Object o) {
        if (o instanceof Point) {
            Point p = (Point) o;
            return p.x == this.x && p.y == this.y;
        }
        return false;
    }
    
    
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    public int compareTo(Point that) {
        return Integer.compare(this.getX(), that.getX());
    }
    
}