package Stream;
import java.io.FileInputStream;

public class FileInputStreamTest {
    public static void main(String[] args) {
        try {
            FileInputStream fs = new FileInputStream("D:\\Git Hub Project\\FCT-JAVA\\Input_Output_Operations\\src\\Stream\\test.txt");
            int i;
            while((i = fs.read()) != -1) {
                System.out.print((char)i);
            }
            fs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
