public class GiveNameToThread extends Thread {
    public void run(){
        for (int i = 0; i <5 ; i++) {
            try{
                Thread.sleep(500);
            }catch (Exception e){
                System.out.println(e);
            }
            System.out.println(i);
        }

    }

    public static void main(String[] args) {
        GiveNameToThread t1 = new GiveNameToThread();
        GiveNameToThread t2 = new GiveNameToThread();
        GiveNameToThread t3 = new GiveNameToThread();
        t1.start();
        t2.start();
        t3.start();

        t1.setName("Vedant");

        System.out.println("Thread 1: "+t1.getName());
        System.out.println("Thread 2: "+t2.getName());
        System.out.println("Thread 3: "+t3.getName());

    }
}
