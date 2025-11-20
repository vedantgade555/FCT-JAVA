public class ThreadDemo3 extends Thread {
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
        ThreadDemo3 t1 = new ThreadDemo3();
        ThreadDemo3 t2 = new ThreadDemo3();
        t1.start();
        t2.start();

    }
}
