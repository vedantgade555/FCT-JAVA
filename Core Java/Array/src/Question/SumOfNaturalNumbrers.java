package Question;

public class SumOfNaturalNumbrers {
    public static void main(String[] args) {
        int a[] = new int[args.length];
        for(int i=0;i<args.length;i++)
        {
            a[i]= Integer.parseInt(args[i]);
        }
        int sum=0;
        for(int i:a)
        {
            sum+=i;
        }
        System.out.println("Sum is "+sum);
    }
}
