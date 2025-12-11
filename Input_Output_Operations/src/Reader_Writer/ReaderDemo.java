package Reader_Writer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class ReaderDemo {
    public static void main(String[] args) {
        try{
            Reader r = new FileReader("output.txt");
           int data = r.read();
           while(data!=-1){
               System.out.println((char)data);
               data = r.read();
           }

            System.out.println("Write Sucessfully");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

