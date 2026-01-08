public class currentThreadDemo extends Thread {
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        currentThreadDemo t1 = new currentThreadDemo();
        currentThreadDemo t2 = new currentThreadDemo();
        currentThreadDemo t3 = new currentThreadDemo();
        t1.setName("Vedant");
        t1.start();
        t2.start();
        t3.start();


    }
}
