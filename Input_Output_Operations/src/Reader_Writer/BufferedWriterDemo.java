package Reader_Writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class BufferedWriterDemo {
    public static void main(String[] args) {
        try{
            Writer w = new FileWriter("output.txt");
            BufferedWriter br = new BufferedWriter(w);
            String content = "Kshtriya";
            br.write(content);
            br.close();
            System.out.println("Write Sucessfully");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

