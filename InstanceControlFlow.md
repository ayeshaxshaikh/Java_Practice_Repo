- Whenever we are executing a Java class, first static control flow will be executed. In the static control flow if we are creating an object the following sequence of events will be executed as the part of instance control flow:
1. I dentification of instance members from top to bottom.
2. Execution of instance variable assignment and instance block from top to bottom.
3. Execution of constructor.

e.g.

class Test
{
    int i = 10;
    {
        m1();
        System.out.println("First instance block");
    }
    
    Test()
    {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println("main method");
    }

    public void m1() 
    {
        System.out.println(j);
    }

    {
        System.out.println("Second instance block");
    }

    int j = 20;
}
o/p:
0
First instance block
Second instance block
Constructor
main method

- If we comment the line Test t = new Test(); then the output is main method.

# Note: Static control flow is one time activity which will be performed at the time of class loading but instance control flow is not one time activity and it will be performed for every object creation.

# Object creation is the most costly operation if there is no specific requirement then it is not recommanded to create object.

# Instance control flow in parent to child relationship:
- Whenever we are creating child class, the following sequence of events will be performed automatically as a part of instance control flow:
1. I dentification of instance members from parent to child.
2. Execution of instance variable assignment and instance blocks only in parent class.
3. Execution of parent constructor.
4. Execution of instance variable assignment and instance blocks in child class.
5. Execution of child constructor.

e.g.

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
        System.out.println("Parent Constructor");
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
o/p:
0
parent instance block
Parent Constructor
0
child first instance block
child second instance block
Child Constructor
child main method

# static and instance control flow:
e.g.
class Test 
{
    {
        System.out.println("first instance block");
    }

    static
    {
        System.out.println("first static block");
    }
    
    Test()
    {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println("main method");
        Test t2 = new Test();
    }

    static
    {
        System.out.println("second static block");
    }

    {
        System.out.println("second instance block");
    }
}
o/p:
first static block
second static block
first instance block
second instance block
Constructor
main method
first instance block
second instance block
Constructor

e.g.

public class Initialization
{
    private static String m1(String msg)
    {
        System.out.println(msg);
        return msg;
    }

    public Initialization()
    {
        m = m1("1");
    }

    {
        m = m1("2");
    }

    String m = m1("3");

    public static void main(String[] args)
    {
        Object o = new Initialization();
    }
}
o/p:
2
3
1

# Note: from static area we can't access instance members directly because while executing static area JVM may not identify instance members.
e.g.

class Test
{
    int x = 10;
    public static void main(String[] args)
    {
        System.out.println(x);
    }
} // CE: non-static variable x cannot be referencced from a static context.

class Test
{
    int x = 10;
    public static void main(String[] args)
    {
        Test t = new Test();
        System.out.println(t.x);
    }
} // 10

## In how many ways we can create an object in Java or in how many ways we can get object in Java? (Very Imp)
- By using new operator.
Test t = new Test();

- By using newInstance() method:
Test t = (Test) Class.forName("Test").newInstance();

- By using Factory method:
Runtime r = Runtime.getRunTime();
DateFormat df = DateFormat.getInstance();

- By using clone() method:
Test t1 = new Test();
Test t2 = (Test)t1.clone();

- By using Deserialization:
FileInputStream fis = new FIS("acc.rev");
ObjectInputStream ois = new OIS(fis);
Dog d = (Dog)ois.readObject();