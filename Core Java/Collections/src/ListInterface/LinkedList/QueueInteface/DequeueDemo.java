package ListInterface.LinkedList.QueueInteface;

import java.util.Queue;
import java.util.LinkedList;

class DeQueueDemo {
    public static void main(String[] args) {

        Queue<String> q = new LinkedList<>();

        /* ===== Enqueue Methods ===== */
        q.add("Apple");      // throws exception if fails
        q.offer("Banana");   // returns false if fails
        q.offer("Orange");
        q.add("Mango");

        System.out.println("Queue: " + q);

        /* ===== Peek Methods ===== */
        System.out.println("peek(): " + q.peek());     // null if empty
        System.out.println("element(): " + q.element()); // exception if empty

        /* ===== Dequeue Methods ===== */
        System.out.println("poll(): " + q.poll());     // removes front, null if empty
        System.out.println("After poll: " + q);

        System.out.println("remove(): " + q.remove()); // removes front, exception if empty
        System.out.println("After remove: " + q);

        /* ===== Utility Methods ===== */
        System.out.println("Size: " + q.size());
        System.out.println("Is Empty: " + q.isEmpty());

        System.out.println("Contains Mango: " + q.contains("Mango"));

        /* ===== Iteration ===== */
        System.out.print("Iterating queue: ");
        for (String item : q) {
            System.out.print(item + " ");
        }
    }
}
