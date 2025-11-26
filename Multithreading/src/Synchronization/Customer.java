package Synchronization;

class Customer {
    int amount = 10000;

    synchronized void withdraw(int amount)
    {
        System.out.println("Going to withdraw...");

        if(this.amount<amount)
        {
            System.out.println("Less Balance, waiting for deposite...");
            try
            {
                wait();
            }catch (Exception e)
            {
                System.out.println(e);
            }
        }

        this.amount-=amount;
        System.out.println("Withdrawal Completed");
    }

    synchronized void deposite(int amount)
    {
        System.out.println("Going to deposite...");
        this.amount+=amount;

        System.out.println("Deposite completed");

        notify();
    }
}

class TestITC
{
    public static void main(String[] args)
    {
        final Customer c = new Customer();

        new Thread(){
            public void run()
            {
                c.withdraw(500);
            }
        }.start();

        new Thread(){
            public void run()
            {
                c.deposite(10000);
            }
        }.start();
    }
}
