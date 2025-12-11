package Stream;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class ByteArrayOutputStreamDemo {
    public static void main(String[] args) throws IOException {

        FileOutputStream fout1 = new FileOutputStream(
                "D:\\Git Hub Project\\FCT-JAVA\\Input_Output_Operations\\src\\Stream\\test1.txt");

        FileOutputStream fout2 = new FileOutputStream(
                "D:\\Git Hub Project\\FCT-JAVA\\Input_Output_Operations\\src\\Stream\\test2.txt");

        FileOutputStream fout3 = new FileOutputStream(
                "D:\\Git Hub Project\\FCT-JAVA\\Input_Output_Operations\\src\\Stream\\test3.txt");

        // Correct object
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        bout.write(65);   // Writes character 'A'

        bout.writeTo(fout1);
        bout.writeTo(fout2);
        bout.writeTo(fout3);

        bout.flush();   
        bout.close(); // Closes ByteArrayOutputStream (does not close output files)

        fout1.close();
        fout2.close();
        fout3.close();

        System.out.println("Data written to all 3 files successfully!");
    }
}
