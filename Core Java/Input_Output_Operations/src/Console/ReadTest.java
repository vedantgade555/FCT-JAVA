package Console;
import java.io.Console;

public class ReadTest {
    public static void main(String[] args) {
        Console c = System.console();

        if(c == null){
            System.out.println("Console not available! Run using Command Prompt.");
            return;
        }

        System.out.println("Enter your Name");
        String name = c.readLine();

        System.out.println("Enter Your Password: ");
        char[] ch = c.readPassword();

        String pass = String.valueOf(ch);
        System.out.println("Welcome " + name);
        System.out.println("Your password is " + pass);
    }
}
