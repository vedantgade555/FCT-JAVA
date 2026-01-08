public class PriorityDemo extends Thread {
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        PriorityDemo t1 = new PriorityDemo();
        PriorityDemo t2 = new PriorityDemo();
        PriorityDemo t3 = new PriorityDemo();

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t3.getPriority());

        t2.setPriority(7);
        t1.setPriority(4);
        t3.setPriority(5);

        System.out.println(currentThread().getName());
        System.out.println(currentThread().getPriority());

        Thread.currentThread().setPriority(10);
        System.out.println(currentThread().getPriority());





    }
}
