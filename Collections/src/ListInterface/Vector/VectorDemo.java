package ListInterface.Vector;

import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<String> v1 = new Vector<>();

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

    }
}
