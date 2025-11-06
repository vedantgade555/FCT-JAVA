package ArrayOfObject;

public class Products {
    int pid;
    String pname;
    float pprice;

    public Products(int pid, String pname, float pprice) {
        this.pid = pid;
        this.pname = pname;
        this.pprice = pprice;
    }


    public void display()
    {
        System.out.println("Poduct Id "+pid);
        System.out.println("Product Name "+pname);
        System.out.println("Product Price "+pprice);
    }

    public static void main(String[] args) {
        Products[] p = new Products[5];
        p[0]=new Products(101,"Iphone",80000);
        p[1]=new Products(101,"IWatch",50000);
        p[2]=new Products(101,"IPad",80000);
        p[3]=new Products(101,"MacBook",200000);
        p[4]=new Products(101,"AirPods",32000);

        for(int i=0;i<p.length;i++)
        {
            p[i].display();
        }
    }
}
