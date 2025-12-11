package Stream;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class BufferOutPutStreamDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fout = new FileOutputStream(
                "D:\\Git Hub Project\\FCT-JAVA\\Input_Output_Operations\\src\\Stream\\test.txt");

        BufferedOutputStream bout = new BufferedOutputStream(fout);

        String s = "Welcome to BufferedStream";
        byte b[] = s.getBytes();

        bout.write(b);
        bout.flush();
        bout.close(); // closes fout automatically

        System.out.println("File Write Successfully");
    }
}
