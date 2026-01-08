package Stream;
import java.io.FileOutputStream;
public class FileOutputStreamTest {
    public static void main(String[] args) {
        try{
            FileOutputStream fs = new FileOutputStream("D:\\Git Hub Project\\FCT-JAVA\\Input_Output_Operations\\src\\Stream\\test.txt");
            String s = "Welcome IO Programming";
            fs.write(65);//65 will be ascii value
            fs.write(s.getBytes());
            fs.close();
            System.out.println("Sucess");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
