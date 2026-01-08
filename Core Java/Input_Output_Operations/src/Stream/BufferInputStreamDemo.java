package Stream;

import java.io.*;

 class BufferInputStreamDemo {
    public static void main(String[] args) throws IOException {

        FileInputStream fin = new FileInputStream(
                "D:\\Git Hub Project\\FCT-JAVA\\Input_Output_Operations\\src\\Stream\\test.txt");

        BufferedInputStream bin = new BufferedInputStream(fin);

        int i;
        while ((i = bin.read()) != -1) {
            System.out.print((char) i);
        }

        bin.close(); // closes fin automatically
    }
}
