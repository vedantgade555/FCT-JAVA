package ThrowAndThrows;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ThrowsDemo {
    public static void show() throws FileNotFoundException {
        FileReader fr = new FileReader("abc.txt");
        throw  new FileNotFoundException();
    }


    public static void main(String[] args) {
        try{
            show();
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("Rest of the code...");
    }
}
