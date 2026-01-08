package Exceptions;

import java.io.FileReader;

public class FileNotFoundDemo {
    public static void main(String[] args) {
        try{
            FileReader fr = new FileReader("missing.txt");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
