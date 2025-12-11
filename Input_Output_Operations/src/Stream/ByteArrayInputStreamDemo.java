package Stream;

import java.io.ByteArrayInputStream;

class ByteArrayInputStreamDemo {
    public static void main(String[] args) {

        try {
            byte[] buf = {35, 36, 37, 38}; // # $ % &

            ByteArrayInputStream bin = new ByteArrayInputStream(buf);

            int k;
            char ch = 0; // declare outside loop

            while ((k = bin.read()) != -1) {
                ch = (char) k; // update ch
                System.out.println("ASCII: " + k + "   Character: " + ch);
            }

            bin.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
