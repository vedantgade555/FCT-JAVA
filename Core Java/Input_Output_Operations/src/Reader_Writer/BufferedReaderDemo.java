package Reader_Writer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class BufferedReaderDemo {
    public static void main(String[] args) {
        try{
            Reader r = new FileReader("output.txt");
            BufferedReader br = new BufferedReader(r);
           int data;
           while((data=br.read())!=-1){
               System.out.println((char)data);
           }

            System.out.println("Write Sucessfully");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

