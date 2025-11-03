package OOP.Encapsulation.PracticeQuestion;

public class TestAccount {
    public static void main(String[] args) {
        Account a = new Account();
        System.out.println(a.viewBalance());
        a.deposite(500);
        System.out.println(a.viewBalance());
        a.withdraw(1000);
        System.out.println(a.viewBalance());
        a.withdraw(100);
        System.out.println(a.viewBalance());
        a.deposite(-500);
        System.out.println(a.viewBalance());

    }
}
