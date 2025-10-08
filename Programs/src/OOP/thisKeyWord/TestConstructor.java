package OOP.thisKeyWord;

class ConMethod1 {
   public ConMethod1()
   {
       this(10);
       System.out.println("Default Constructor");
//       This concept called constructor chaining
   }

   public ConMethod1(int id)
   {
//       this();
       System.out.println("Parametarized Constructor "+id);
   }
}

public class TestConstructor
{
    public static void main(String[] args) {
        ConMethod1 m1  =new ConMethod1();
    }
}
