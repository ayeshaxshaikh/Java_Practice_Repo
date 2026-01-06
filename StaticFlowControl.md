- Whenever we are executing a Java class, the following sequence of steps will be executed as the part of stactic control flow:
1. I dentification of static members from top to bottom.
2. Execution of static variable assignment and stactic block from top to bottom.
3. Execution of main method.

e.g.
class Base {
    static int i = 10;
    static 
    {
        m1();
        System.out.println("First static block");
    }

    public static void main(String[] args) {
        m1();
        System.out.println("main method");
    }

    public static void m1() 
    {
        System.out.println(j);
    }

    static
    {
        System.out.println("Second static block");
    }

    static int j = 20;
}
0
First static block
Second static block
20
main method


# read indirectly write only:
- Inside static block, if we are trying to read a variable that read operation is called direct read.
- If we are calling a method, and within that method if we are trying to read a variable that read operation is called indirect read.

e.g.
class Test
{
    static int i = 10;

    static
    {
        m1();
        System.out.println(i);   // direct read
    }

    public static void m1()
    {
        System.out.println(i);  // indirect reaad
    }
}

- If a variable is just identified by the JVM and original value not yet assigned then the variable is said to be in read indirectly and write only state (riwo).
- If a variable is in read indirectly write only state then we can't perform direct read but we can perform indirect read.
- If we are trying to read directly then we will get compile time error saying illegal forward reference.

e.g.
class Test
{
    static int i = 10;

    static
    {
        System.out.println(i);   // direct read
    }
}  
o/p:
10
RE: NoSuchMethodError: main


e.g.
class Test
{
    static
    {
        System.out.println(i);   // indirect read
    }
     static int i = 10;
}
o/p:
CE: illegal forward reference

e.g.
class Test
{
    static
    {
        m1();
    }

    public static void m1()
    {
        System.out.println(i);
    }

    static int i = 10;
}
o/p:
0
RE: NoSuchMethodError: main


# static block:
- static blocks will be executed at the time of class loading hence at the time of class loading if we want to perform any activity, we have to define that inside static block.
- At the time of java class loading, the corresponding loading libraries should be loaded hence we have to define this activity inside static block.

class Test
{
    static
    {
        System.loadLibrary("native library path");
    }
}

- After loading every database driver class, we have to register driver class with driver manager but inside databse driver class there is a static block to perform this activity and we are not responsible to register explicitly.

class DbDriver
{
    static
    {
        Register this driver with driver manager
    }
}

# Note: Whithin a class we can declare any number of static blocks. But all these static blocks will be executed from top to bottom.

Q. Without writing main method, is it possible to print some statements to the console?
A. Yes. By using static block.

e.g.
class Test
{
    static 
    {
        System.out.println("Hello");
        System.exit(0);
    }
}
o/p: Hello


Q. Without writing main method and static block, is it possible to print some statements to the console?
A. Yes. There are multiple ways.
e.g.
class Test
{
    static int x = m1();
    public static int m1()
    {
        System.out.println("Hello");
        System.exit(0);
        return 10;
    }
} // Hello

e.g.
class Test
{
    static Test t = new Test();

    {
        System.out.println("Hello");
        System.exit(0);
    }
} // Hello

e.g.
class Test
{
    static Test t = new Test();
    Test()
    {
        System.out.println("Hello");
        System.exit(0);
    }
}

# NOTE: From 1.7v onwards main method is mandatory to start a program execution hence from 1.7v onwards without writing main method it is impossible to print some statement to the console.

# Static control flow in parent to child relationship:
- Whenever we are executing child class, the following sequence of events will be executed automatically as a part of static control flow:
1. I dentification of static members from parent to child.
2. Execution of static variable assignment and stactic block from parent to child.
3. Execution of only child class main method.

# NOTE: Whenever we are loading child class automatically parent calss will be loaded but whenever we are loading parent class, child class won't be loaded (because parent class members by default available to the child class whereas child class members by default won't be available to the parent).