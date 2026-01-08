package Synchronization;

class Table{
//    synchronized void printTable(int n){
    void printTable(int n)
    {
        synchronized (this)
        {
            for (int i = 1; i <= 10; i++)
            {
                System.out.println(n * i);
                try
                {
                    Thread.sleep(400);
                } catch (Exception e)
                {
                    System.out.println(e);
                }
            }

        }
        System.out.println(" other Calculation in print table Method");
        for (int j = 1; j <= 5; j++)
        {
            System.out.println(n * j);
            try
            {
                Thread.sleep(400);
            } catch (Exception e)
            {
                System.out.println(e);
            }
        }

    }

}

class MyThread1 extends Thread{
    Table t;
    MyThread1(Table t){
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(5);
    }
}

class MyThread2 extends Thread{
    Table t;
    MyThread2(Table t){
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(100);
    }
}

class TestTable{
    public static void main(String[] args) {
        Table obj = new Table();
        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);

        t1.start();
        t2.start();
    }
}
