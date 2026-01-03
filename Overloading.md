- Two methods are said to be overloaded if and only if both methods having same name but different argument types.
- Having overloading concept in Java reduces complexity of programming.

e.g.
class Test
{
    public void m1()
    {
        System.out.println("no-arg");
    }

    public void m1(int i)
    {
        System.out.println("int-arg");
    }

    public void m1(double d)
    {
        System.out.println("double-arg");
    }
}

public class Main {
    public static void main(String[] args) {
        Test t = new Test();
        t.m1();    // no-arg
        t.m1(10);  // int-arg
        t.m1(10.5); // double-arg
    }
}

- In overloading, method resolution always takes care by compiler based on reference type hence overloading is also considered as compile time polymorphism or static polymorphism or early binding.

# Case-1:
Automatic promotion in overloading - while resolving overlaoded methods if exact matched method is not available then we won't get compile time error immediately. First it will promote argument to the next level and check whether that matched method is available or not.
If matched method is availble then it will be considered. 
If the matched method is not available, compiler promotes argument once again to next level. This process will be continued untill all possible promotion. Still if the matched method is not available then we will get compile time error.

e.g.
class Test
{
    public void m1(int i)
    {
        System.out.println("int-arg");
    }

    public void m1(float f)
    {
        System.out.println("float-arg");
    }
}

public class Main {
    public static void main(String[] args) {
        Test t = new Test();
        t.m1(10);  // int-arg
        t.m1(10.5f); // float-arg
        t.m1('a'); // int-arg
        t.m1(10l); // float-arg
        t.m1(10.5); // CE
    }
}


# Case-2:
- While resolving overloaded methods, compiler will always keeps precedence for child type argument then compared it with parent type argument.
e.g.
class Test
{
    public void m1(String s)
    {
        System.out.println("String-Version");
    }

    public void m1(Object o)
    {
        System.out.println("Object-Version");
    }
}

public class Main {
    public static void main(String[] args) {
        Test t = new Test();
        t.m1(new Object());  // Object-Version
        t.m1("love"); // String-Version
        t.m1(null); // String-Version
    }
}


# Case-3:
- String and StringBuffer are at same level.
e.g.
class Test
{
    public void m1(String s)
    {
        System.out.println("String-Version");
    }

    public void m1(StringBuffer sb)
    {
        System.out.println("StringBuffer-Version");
    }
}

public class Main {
    public static void main(String[] args) {
        Test t = new Test();
        t.m1(new StringBuffer("love"));  // StringBuffer-Version
        t.m1("love"); // String-Version
        t.m1(null); // CE: Reference to m1() is ambiguous.
    }
}


# Case-4:
e.g.
class Test
{
    public void m1(int i, float f)
    {
        System.out.println("int-float");
    }

    public void m1(float f, int i)
    {
        System.out.println("float-int");
    }
}

public class Main {
    public static void main(String[] args) {
        Test t = new Test();
        t.m1(10, 10.5f);  // int-float
        t.m1(10.5, 10); // float-int
        t.m1(10, 10); // CE: Reference to m1() is ambiguous.
    }
}


# Case-5:
- In general, var-arg method will get least priority. If no other method matched then only var-arg method will get the chance. It is exactly same as default case inside a switch.
e.g.
class Test
{
    public void m1(int i)
    {
        System.out.println("general");
    }

    public void m1(int... x)
    {
        System.out.println("var-arg");
    }
}

public class Main {
    public static void main(String[] args) {
        Test t = new Test();
        t.m1();  // var-arg
        t.m1(10, 20); // var-arg
        t.m1(10); // general
    }
}