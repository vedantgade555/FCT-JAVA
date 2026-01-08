package Basics;

class CommandLineArgument{
    public static void main(String args[]) {
        System.out.println("My Command Line array data ");

//        for(String j:args)
//        {
//            System.out.println(j);
//        }

        int a[] = new int[args.length];
        for(int i=0;i<args.length;i++)
        {
            a[i]= (int) Double.parseDouble(args[i]);
        }
        for(double j:a)
        {
            System.out.println(j);
        }
    }
}
