package OOP.Abstraction;

abstract class Bank {
    abstract int getInterestRate();
}

class SBI extends Bank{
    int getInterestRate()
    {
        return 8;
    }
}

class HDFC extends Bank{
    int getInterestRate()
    {
        return 9;
    }
}

class BOB extends Bank{
    int getInterestRate()
    {
        return 10;
    }
}

class TestAbstraction{
    public static void main(String[] args) {
        Bank b;
        b = new SBI();
        System.out.println("Rate of interest: "+b.getInterestRate());

        b = new HDFC();
        System.out.println("Rate of interest: "+b.getInterestRate());

        b = new BOB();
        System.out.println("Rate of interest: "+b.getInterestRate());
    }
}
