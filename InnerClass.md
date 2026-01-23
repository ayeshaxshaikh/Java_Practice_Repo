# Introduction:
- Sometimes we can declare a class inside another class such type of classes are called inner classes.
- inner classes concept introduced in 1.1v to fix GUI bugs as a part of event handling but because of powerful features and benefits of inner classes slowly programmers started using in regular coding also.
- Without existing one type of object if there is no chance of existing another type of object then we should go for inner classes.
e.g.1
university consists of several departments. Without existing university there is no chance of existing departments hence we have to declare department class inside university class.
e.g.2
Without existing car object there is no chance of existing engine object hence we have to declare engine class inside car class.
e.g.3
map is group of key value pairs and each key value pair is called an entry. without existing map object there is no chance of existing entry object hence interface entry is defined inside map interface.

# Note: Without existing outer class object there is no chance of existing innerclass object. The relation between innerclass and outerclass is not IS-A relation and it is HAS-A relationship (composition or aggregation).

- Based on position of declaration and behaviour all innerclasses are divided into 4 types:
1. Normal or Regular Inner class
2. Method local inner class
3. Anonymous inner class
4. Static nested class

# Normal or Regular Inner Classes:
- If we are declaring any named class without static modifier directly inside a class such type of inner class is called normal or regular inner class.
e.g.1
class Outer
{
    class Inner
    {

    }
}
- javac Outer.java
- then two classes will be created 
Outer.class and Outer$Inner.class
- java Outer : Error: Main method not found in class Outer, please define the main method as:
   public static void main(String[] args)

- java Outer$Inner : Error: Main method not found in class Outer, please define the main method as:
   public static void main(String[] args)

e.g.2
class Outer {
    class Inner
    {
        
    }    
    public static void main(String[] args) {
        System.out.println("Outer main method");
    }
}
java Outer: Outer main method
java Outer$Inner : Outer main method

- Inside inner class, we can't declare any static members hence we can't declare main method hence we can't run inner class directly from command prompt.
e.g
class Outer {
    class Inner {
        public static void main(String[] args) {
            System.out.println("Inner main method");
        }
    }
}
// CE: Inner classes cannot have static declaration

# case-1:
- Accessing inner class code from static area of outer class
e.g.
class Outer {
    class Inner {
        public void m1()
        {
            System.out.println("Inner class method");
        }
    }
    public static void main(String[] args) {
        // Outer o = new Outer();
        // Outer.Inner i = o. new Inner();
        // i.m1();

        Outer.Inner i = new Outer(). new Inner();
        i.m1();
    }
}

# case-2:
- Accessing inner class code from instance area of outer class
class Outer {
    class Inner {
        public void m1()
        {
            System.out.println("Inner class method");
        }
    }
    public void m2()
    {
        Inner i = new Inner();
        i.m1();
    }
    public static void main(String[] args) {
        Outer o = new Outer();
        o.m2();
    }
}

# case-3:
- Accessing inner class code from outside of outer class
class Outer {
    class Inner {
        public void m1()
        {
            System.out.println("Inner class method");
        }
    }
}
class Demo {
    public static void main(String[] args) {
        Outer o = new Outer();
        Outer.Inner i = o. new Inner();
        i.m1();
    }
}

- From normal or regular inner class we can access both static and non-static memebers of outer class directly
class Outer {
    int x = 10;
    static int y = 20;
    class Inner {
        public void m1()
        {
            System.out.println(x);
            System.out.println(y);
        }
    }
    public static void main(String[] args) {
        new Outer().new Inner().m1();
    }
}

- Within the inner class this always refers current inner class object. If we want to refer current outer class object we have to use outerclassname.this
class Outer {
    int x = 10;
    class Inner {
        int x = 100;
        public void m1()
        {
            int x = 1000;
            System.out.println(x);  // 1000
            System.out.println(this.x); // 100
            System.out.println(Outer.this.x); // 10
        }
    }
    public static void main(String[] args) {
        new Outer().new Inner().m1();
    }
}

- The only applicable modifiers for outer classes are public, <default>, abstract, final, strictfp
- But for inner classes applicable modifiers are public, <default>, abstract, final, strictfp, private, protected, static
- Inside inner class we can declare another inner class that is nesting of inner class is possible.

class A {
    class B {
        class C {
            public void m1()
            {
                System.out.println("Inner class method");
            }
        }
    }
}
class Test 
{
    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
        A.B.C c = b.new C();
        c.m1();
    }
}

# Method local inner class:
- Sometimes we can declare a class inside method such type of inner classes are called method local inner classes.
- The main purpose of method local inner class is to define method specific repeatedly required functionality.
- Method local inner classes are best suitable to meet nested method requirements
- we can access method local inner classes only within a method where we declared
- Outside the method we can't access
- because of its less scope method local inner classes are rarely used type of inner classes
e.g.
class Test 
{
    public void m1()
    {
        class Inner 
        {
            public void sum(int x, int y)
            {
                System.out.println(x+y);
            }
        }
        Inner i = new Inner();
        i.sum(10, 20);
        i.sum(100, 200);
        i.sum(1000, 2000);
    }
    public static void main(String[] args) {
        Test t = new Test();
        t.m1();
    }
}

- We can declare method local inner class inside both instance and static methods.
- If we declare inner class directly inside instance method then from that method local inner class we can access both static and non-static members of outer class directly.
- If we declare inner class inside static method then we can access only static members of outer class directly from that method local inner class. 