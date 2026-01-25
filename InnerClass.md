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

e.g.
class Demo {
    int x = 10;
    static int y = 20;
    public void m1()
    {
        class Inner {
            public void m2()
            {
                System.out.println(x);
                System.out.println(y);
            }
        }
        Inner i = new Inner();
        i.m2();
    }
    public static void main(String[] args) {
        Demo d = new Demo();
        d.m1();
    }
}
o/p:
10
20

- if we declare m1() as static then at System.out.println(x); we will get compile time error saying non-static variables cannot be refernced from static context.

# From method local inner class we can't access local variables of the method in which we declare inner class. If the local variable declared as final then we can access.

class Demo {
    public void m1()
    {
        int x = 10;
        class Inner {
            public void m2()
            {
                System.out.println(x);
            }
        }
        Inner i = new Inner();
        i.m2();
    }
    public static void main(String[] args) {
        Demo d = new Demo();
        d.m1();
    }
}
o/p:
10

- From Java 8 onwards, such variables are called effectively final

# Anonymous inner class:
- sometimes we can declare inner class without name such type of inner classes are called anonymous inner classes.
- The main purpose of anonymous inner class is just for instant use (one time usage).
- based on declaration and behaviour there are 3 types of anonymous inner classes:
1. Anonymous inner class that extends a class
2. Anonymous inner class that implements an interface
3. Anonymous inner class that defined inside arguments

# Anonymous inner class that extends a class:
class PopCorn {
    public void taste()
    {
        System.out.println("salty");
    }
}
class Demo {
    public static void main(String[] args) {
        PopCorn p = new PopCorn() {
            public void taste()
            {
                System.out.println("spicy");
            }
        };
        p.taste();
        PopCorn p1 = new PopCorn();
        p1.taste();
        PopCorn p2 = new PopCorn() {
            public void taste() {
                System.out.println("sweet");
            }
        };
        p2.taste();
    }
}
o/p:
salty
spicy
sweet
Demo$1
PopCorn
Demo$2

# Analysis:
PopCorn p = new PopCorn(); 
- Just we are creating popcorn object

PopCorn p = new PopCorn() {

}
- we are declaring a class that extends popcorn without name (Anonymous inner class)
- for that child class we are creating an object with parent reference
- In that child class we are overriding taste method.

# Defining a thread by extending thread class
class ThreadDemo {
    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run()
            {
                for (int i = 0; i < 5; i++) {
                    System.out.println("child thread");
                }
            }
        };
        t.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("main thread");
        }
    }
}

# Anomynous inner class that implements an Interface: 
# Defining a thread by implementing Runnable interface:
class ThreadDemo {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            public void run()
            {
                for (int i = 0; i < 10; i++) {
                    System.out.println("child thread");   
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main thread");
        }
    }
}   

# Define anonymous inner class inside arguments:
class ThreadDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
           public void run() 
           {
                for (int i = 0; i < 10; i++) {
                    System.out.println("child thread");
                }
           }
        }).start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main thread");
        }
    }
}

# normal java class vs anonymous inner class:
- a normal java class can extend only one class at a time and anonymous inner class can extend only one class at a time
- a normal java can implement any number of interfaces simultaneously but anonymous inner class can implement only one interface at a time
- a normal java class can extend a class and can implement any number of interfaces simultaneously but anonymous inner class can extend a class or can implement an interface but not both simultaneously.
- In normal java class we can write any number of constructors but in anonymous inner class we can't write any constructor explicitly (because the name of the class and name of the constructor must be same but anonymous inner class not having any name)

# Note: If the requirement is standard and required several times then we should go for normal top level class. If the requirement is temporary and required only once (instant use) then we should go for anonymous inner class.

