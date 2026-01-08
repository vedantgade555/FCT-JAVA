import java.io.IOException;

public class TestIo {
    public static void main(String[] args) throws IOException {
        System.out.println("Test Output Stream");

        System.err.println("Test Error Stream");

        try{
            int i = System.in.read();
            System.out.println((char)i);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
