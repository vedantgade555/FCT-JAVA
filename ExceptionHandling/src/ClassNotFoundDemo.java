import java.io.FileReader;

public class ClassNotFoundDemo {
    public static void main(String[] args) {
        try{
            Class.forName("com.ram.sam");

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
