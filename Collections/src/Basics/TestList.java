package Basics;

import java.util.ArrayList;
import java.util.Iterator;

class TestList {
    public static void main(String[] args) {
        ArrayList l1 = new ArrayList();
        l1.add(101);
        l1.add("Ram");
        l1.add("Pune");
        l1.add(55.55);
        l1.add("Male");
        l1.add("Pune");


        System.out.println(l1);
        
        Iterator itr = l1.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
