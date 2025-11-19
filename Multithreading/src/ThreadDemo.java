public class ThreadDemo extends Thread implements Runnable{
    public void run(){
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
//      First Method
        ThreadDemo t1 = new ThreadDemo();
        t1.start();
//        Second Method
        Thread t2 = new Thread("My Thread");
        t2.start();
        String s1 =  t2.getName();
        System.out.println(s1);
//      Third Method
        Runnable r = new ThreadDemo();
        Thread t3 = new Thread(r,"My Thread");
        t3.start();
    }
}
