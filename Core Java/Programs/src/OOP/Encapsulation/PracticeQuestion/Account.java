package OOP.Encapsulation.PracticeQuestion;

public class Account {
    private double balance;

    public double viewBalance()
    {
        return balance;
    }
    public void deposite(double amount) {
        if(amount > 0)
        {
            balance+=amount;
        }
        else{
            System.out.println("Balance does not in negative");
        }
    }

    public void withdraw(double amount)
    {
        if(amount>0 && amount<=balance)
        {
            balance-=amount;
        }
        else {
            System.out.println("Not Sufficient Balance avaliable");
        }
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
