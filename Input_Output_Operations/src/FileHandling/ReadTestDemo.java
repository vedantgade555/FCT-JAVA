package FileHandling;
//We are set the permission of the file
import java.io.File;

public class ReadTestDemo {
    public static void main(String[] args) {
        try{
            File f = new File("D:\\Git Hub Project\\FCT-JAVA\\Input_Output_Operations\\src\\FileHandling\\sample.txt");

            if(f.createNewFile()){
                System.out.println(f.getName()+" file created Sucessfully ");
            }else{
                System.out.println(f.getName()+"file already exists");
            }

            System.out.println("Is file readable : "+f.canRead());
            System.out.println("Is file writeable: "+f.canWrite());
            System.out.println("Is file execute: "+f.canExecute());

//            f.setReadable(true);
//            f.setWritable(false);
//            f.setExecutable(true);
//
//
//            System.out.println("Is file readable : "+f.canRead());
//            System.out.println("Is file writeable: "+f.canWrite());
//            System.out.println("Is file execute: "+f.canExecute());
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
