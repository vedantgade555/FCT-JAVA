package SetInterface;

import com.sun.source.tree.Tree;

import java.util.TreeSet;

public class TreeDemo {
    public static void main(String[] args) {
        TreeSet<Integer> t2 = new TreeSet<>();
        t2.add(5);
        t2.add(20);
        t2.add(30);
        t2.add(40);
        t2.add(50);

        System.out.println("Treeset: "+t2);

        System.out.println("Floor of 50 is "+t2.floor(50));
        System.out.println("ceiling3 of 5 is "+t2.ceiling(5));


    }
}
