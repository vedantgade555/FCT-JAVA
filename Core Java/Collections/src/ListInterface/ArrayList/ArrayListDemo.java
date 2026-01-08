package ListInterface.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList l1 = new ArrayList();
        l1.add(101);
        l1.add("Ram");
        l1.add("Pune");
        l1.add(55.55);
        l1.add("Male");// add element at last

        l1.set(1,"RamBhau"); // replace element at specific position
        l1.add(1,"Shyam"); // add element at perticular position
        l1.add(0,1000);

        ArrayList l2 = new ArrayList();
        l2.add("Krishna");
        l2.add("Dwarka");
        l2.add(2000);

        l1.addAll(l2); // add data from anoter collection
        System.out.println(l1);
        Iterator itr = l1.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
