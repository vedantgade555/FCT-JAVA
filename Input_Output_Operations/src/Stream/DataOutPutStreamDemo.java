package Stream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class DataOutPutStreamDemo {
    public static void main(String[] args)  {
        try{
            FileOutputStream fout = new FileOutputStream(
                    "D:\\Git Hub Project\\FCT-JAVA\\Input_Output_Operations\\src\\Stream\\test.txt");

            DataOutputStream dout = new DataOutputStream(fout);
            dout.write(65);
            dout.flush();
            dout.close(); // closes fout automatically

        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("File Write Successfully");
    }
}
