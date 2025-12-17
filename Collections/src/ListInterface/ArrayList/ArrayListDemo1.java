package ListInterface.ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo1 {
    public static void main(String[] args) {
        ArrayList l1 = new ArrayList();

        for(int i=50;i>=0;i-=10)
        {
            l1.add(i);
        }

        System.out.println(l1);
        System.out.println(l1.get(2));

        Collections.sort(l1);
        System.out.println(l1);
        //


        // Sort
        ArrayList l2 = new ArrayList();
        l2.add("Ganesh");
        l2.add("Sandip");
        l2.add("Ram");
        l2.add("Shyam");
        System.out.println(l2);
        Collections.sort(l2);
        System.out.println(l2);

        //Remove
        l2.remove("Sandip");
        System.out.println(l2);


        // Remove All

        l1.addAll(l2);
        System.out.println(l1);
        l1.removeAll(l2);
        System.out.println(l1);

        // indexOf()

        System.out.println(l1.indexOf(30));


        // contains()
        System.out.println(l1.contains(30));

        // isEmpty()
        System.out.println(l1.isEmpty());

        //lastIndexof
//        System.out.println(lastIndexOf(l1));

        // isEmpty()
        System.out.println("Array is Empty or not "+l1.isEmpty());

        // last Index
        System.out.println("Last index is "+l1.lastIndexOf(10));

        // toArray()
        System.out.println("In Arra: "+l1.toArray());


        // sublist
        System.out.println("Sublist is "+l1.subList(1,4));

        // size is
        System.out.println("Size is "+l1.size());

        // retainAll
        System.out.println(l1.retainAll(l2)); // write the common elements

        // clone
        ArrayList<Integer> l3 = (ArrayList<Integer>) l1.clone();

        // ensure capacity
        // used to set capacity
        ArrayList<Integer> l4 = new ArrayList<>();
        l4.ensureCapacity(50);
        for (int i = 0; i <50 ; i++) {
            l4.add(i);
        }
        System.out.println(l4);


        // clear()
        l1.clear();
        System.out.println(l1);
    }
}
