package Reader_Writer;

import java.io.FileWriter;
import java.io.Writer;

public class WriterDemo {
    public static void main(String[] args) {
        try{
            Writer w = new FileWriter("output.txt");
            String content = "Kshtriya";
            w.write(content);
            w.append("\nI like India");
            w.close();
            System.out.println("Write Sucessfully");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

