package algo;

import java.util.*;
import algo.*;

public class Main {

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int i = Integer.parseInt(args[2]);
        int j = Integer.parseInt(args[3]);
        System.out.println(new Game(m, n, i, j).naif());

    }
    
}