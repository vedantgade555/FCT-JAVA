package Question;

public class FindMinMax {
    public static void main(String[] args) {
        int a[] = new int[args.length];
        for(int i=0;i<args.length;i++)
        {
            a[i]= Integer.parseInt(args[i]);
        }
        int sum=0;

        int max=a[0];
        int min=a[0];
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>max)
                max=a[i];
            else {
                min=a[i];
            }
        }

        System.out.println("Max Element is "+max);
        System.out.println("Min Element is "+min);
    }
}
