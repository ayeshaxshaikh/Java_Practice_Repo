class Parent 
{
    int i = 10;
    {
        m1();
        System.out.println("parent instance block");
    }
    
    Parent()
    {
        System.out.println("Parent Constructor");
    }

    public static void main(String[] args) {
        Parent t = new Parent();
        System.out.println("parent main method");
    }

    public void m1() 
    {
        System.out.println(j);
    }

    int j = 20;
}

class Child extends Parent 
{
    int x = 100;
    {
        m1();
        System.out.println("child first instance block");
    }
    
    Child()
    {
        System.out.println("Child Constructor");
    }

    public static void main(String[] args) {
        Child t = new Child();
        System.out.println("child main method");
    }

    public void m1() 
    {
        System.out.println(y);
    }

    {
        System.out.println("child second instance block");
    }

    int y = 200;
}