package ThrowAndThrows;

import java.io.IOException;

class ThrowsDemo1{
    void display() throws IOException{
        System.out.println("Throws Example");
    }
}

public class ThrowsTest {
    public static void main(String[] args) {
        ThrowsDemo1 d1 = new ThrowsDemo1();
        try{
            d1.display();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
