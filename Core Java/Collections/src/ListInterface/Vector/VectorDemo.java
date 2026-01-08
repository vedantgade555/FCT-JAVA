package ListInterface.Vector;

import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<String> v1 = new Vector<>();
        Vector<Integer> v2 = (Vector<Integer>) v1.clone();

        v1.add("Fortuner");
        v1.add("Tiago");
        v1.add("Altroz");
        v1.add("Harior");
        v1.add("Punch");
        v1.add("Defender");
        v1.add("Curve");

        System.out.println(v1);

        v1.addElement("Sierra");
        System.out.println(v1);

        // element
        System.out.println(v1.firstElement());
        System.out.println(v1.lastElement());
        System.out.println(v1.elements());
        System.out.println(v1.elementAt(4));

        System.out.println(v1);
        // capacity
        System.out.println("Capaccity is "+v1.capacity());
        System.out.println("Size is "+v1.size());

        // Indexof
        System.out.println("Index of Fortuner is "+v1.indexOf("Fortuner"));

        // remove
        v1.remove("Punch");
        System.out.println(v1);

        // set
        v1.set(3,"Innova");
        System.out.println("After set is "+v1);

        // get
        System.out.println(v1.get(2));

        // isEmpty
        System.out.println("Is there Empty "+v1.isEmpty());

        // elements
        System.out.println("First Element "+v1.firstElement());
        System.out.println("Last Elemet "+v1.lastElement());
        System.out.println("Elements are "+v1.elements());
        System.out.println("Element at index 2 is "+v1.elementAt(2));


    }
}
