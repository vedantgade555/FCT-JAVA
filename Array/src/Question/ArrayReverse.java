package Question;

public class ArrayReverse {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("In forward Order");
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }

        System.out.println("array in reverse order");
        for(int i=a.length-1;i>=0;i--)
        {
            System.out.println(a[i]);
        }
    }
}
