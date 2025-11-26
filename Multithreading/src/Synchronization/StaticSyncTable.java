package Synchronization;

class Calculator {

    // static synchronized method
    public static synchronized void printNumbers(int n, String str) {
        System.out.println(str);
        for (int i = 1; i <= 10; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class WorkerA extends Thread {
    Calculator calc;
    String str;

    WorkerA(Calculator calc, String str) {
        this.calc = calc;
        this.str = str;
    }

    @Override
    public void run() {
        Calculator.printNumbers(5, str);
    }
}

class WorkerB extends Thread {
    Calculator calc;
    String str;

    WorkerB(Calculator calc, String str) {
        this.calc = calc;
        this.str = str;
    }

    @Override
    public void run() {
        Calculator.printNumbers(100, str);
    }
}

class StaticSyncDemo {
    public static void main(String[] args) {

        Calculator obj = new Calculator();

        WorkerA thread1 = new WorkerA(obj, "Thread A Running:");
        WorkerB thread2 = new WorkerB(obj, "Thread B Running:");

        thread1.start();
        thread2.start();
    }
}
