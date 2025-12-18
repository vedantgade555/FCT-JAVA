package ListInterface.LinkedList.QueueInteface;

import java.util.PriorityQueue;

public class QueueDemo {
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("Apple");
        pq.add("Ram");
        pq.add("Banana");
        pq.add("Orange");

        pq.offer("Kevi");
        System.out.println(pq);

        System.out.println("Head is "+pq.peek());

        pq.poll();
        System.out.println(pq);
        pq.remove();
        System.out.println(pq);

    }
}
