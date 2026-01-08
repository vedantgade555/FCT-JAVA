package FileHandling;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        try{
            File f1 = new File("D:\\Git Hub Project\\FCT-JAVA\\Input_Output_Operations\\src\\FileHandling\\sample.txt");
            if(f1.createNewFile()){
                System.out.println("File "+f1.getName()+" is created sucessfully");
            }else{
                System.out.println("File alrady exists");
            }

            System.out.println("Path of file: "+f1.getAbsolutePath());
            System.out.println("Permission to read file: "+f1.canRead());
            System.out.println("Permission to write file: "+f1.canWrite());
            System.out.println("Length of file: "+f1.length());


            if(f1.delete()){
                System.out.println("File "+f1.getName()+" is deleted sucessfully");
            }else{
                System.out.println("error occurs");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
