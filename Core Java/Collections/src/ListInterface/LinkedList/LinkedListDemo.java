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

        LinkedList<String> l2 = (LinkedList<String>) l1.clone();

        // Get Methods

        System.out.println(l1.get(3));
        System.out.println(l1.getFirst());
        System.out.println(l1.getLast());

        // peek() method
        System.out.println(l1.peek());
        System.out.println(l1.peekFirst());
        System.out.println(l1.peekLast());

        // removing methods
        l1.remove();
        l1.remove(2);
        l1.poll();
        l1.pollFirst();
        l1.pollLast();
        System.out.println(l1);

        // contains
        System.out.println(l1.contains("Anup"));
        System.out.println("Index of Ganesh is "+l1.indexOf("Ganesh"));

        // toArray
        l1.toArray();
        System.out.println(l1);

        // Adding data
        l2.offer("Rajesh");
        l2.offerFirst("Raghav");
        l2.offerLast("Pranav");
        System.out.println(l2);



    }

}
