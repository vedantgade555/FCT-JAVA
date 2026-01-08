package Stream;

import java.io.DataInputStream;
import java.io.FileInputStream;

class DataInPutStreamDemo {
    public static void main(String[] args)  {
        try{
            FileInputStream fin = new FileInputStream(
                    "D:\\Git Hub Project\\FCT-JAVA\\Input_Output_Operations\\src\\Stream\\test.txt");

            DataInputStream din = new DataInputStream(fin);

            int count = fin.available();     // number of bytes available
            byte[] arr = new byte[count];    // create array

            din.read(arr);   // read bytes into arr

            for(byte bt : arr){
                char ch = (char) bt;     // convert byte to character
                System.out.print(ch);    // print characters
            }

            din.close();  // closes fin automatically
        }
        catch (Exception e){
            System.out.println(e);
        }

        System.out.println("\nFile Read Successfully");
    }
}
