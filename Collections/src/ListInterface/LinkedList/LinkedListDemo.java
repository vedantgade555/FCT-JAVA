package ListInterface.LinkedList;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> l1 = new LinkedList<String>();
        l1.add("Vijay");
        l1.add("Anup");
        l1.add("Raj");
        l1.add("Ganesh");
        l1.add("Anand");

        System.out.println(l1);

        l1.addFirst("Sagar");
        l1.addLast("Jeevan");
        l1.push("Sunjay");
        System.out.println(l1);

        // Get Methods

        System.out.println(l1.get(3));
        System.out.println(l1.getFirst());
        System.out.println(l1.getLast());

        // peek() method
        System.out.println(l1.peek());
        System.out.println(l1.peekFirst());
        System.out.println(l1.peekLast());
    }

}
