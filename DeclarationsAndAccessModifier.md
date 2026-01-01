# Java source file structure:
- A Java program can contain any number of classes but atmost one class can be declared as public.
- If there is a public class then name of the program and name of the public class must be matched. Otherwise we will get compile time error.
e.g.
class A {

}
class B {

}
class C {

}

case 1: If there is no public class, then we can use any name and there are no restrictions.
e.g. A.java, B.java, C.java, Love.java, etc.

case 2: If class B is public then name of the program should be B.java. Otherwise we will get compile time error saying class B is public, should be declared in a file named B.java.

case 3: If classes B and C declared as public and name of the program is B.java then we will get compile time error saying class C is public, should be declared in a file named C.java.

e.g.
class A {
    public static void main(String[] args) {
        System.out.println("A class main");
    }
}
class B {
    public static void main(String[] args) {
        System.out.println("B class main");
    }
}
class C {
    public static void main(String[] args) {
        System.out.println("C class main");
    }
}
class D {

}

Given the file name as Test.java
javac Test.java:
A.class
B.class
C.class
D.class

java A:
o/p: A class main

java B:
o/p: B class main

java C: 
o/p: C class main

java D:
RE: NoSuchMethodError: main

java Test:
RE: NoClassDefFoundError: Test

# Conclusion: 
Whenever we are compiling a java program for every class present in the program a separate .class file will be generated.
We can compile java program (java source file) but we can run a java .class file.
Whenever we are executing a java class, the corresponding class main method will be executed.
If the class does not contain main method then we will get runtime exception saying NoSuchMethodError: main.
If the corresponding .class file not available the we will get runtime exception saying NoClassDefFoundError.
It is not recommanded to declare multiple classes in a single source file.
It is highly recommanded to declare only one class per source file and name of the program we have to keep same as class name.
The main advantage of this approach is readability and maintainability of the code will be improved.

# import statement:
class Test {
    public static void main(String[] args) {
        ArrayList l = new ArrayList();
    }
} 
// CE: cannot find symbol
Symbol: class ArrayList
location: class Test

We can solve this problem using fully qualified name -
java.util.ArrayList l = new java.util.ArrayList();

The problem with usage of fully qualified name every time is, it increases the length of the code and reduces readability.
We can solve this problem by using import statement.
Whenever we are writing import statement it is not required to use fully qualified name everytime. We can use Short name directly.

e.g.
import java.util.ArrayList;

Hence import statement acts as typing shortcut.

# Types of import statement -
case 1: 
-------
There are two types of import statements - 
1. Explicit class import
2. Implicit class import

- Explicit class import :
e.g.
import java.util.ArrayList;
It is highly recommanded to use explicit class import because it improves readability of the code.

- Implicit class import:
e.g.
import java.util.*;
Not recommanded to use because it reduces readability of the code.


case 2:
-------
Which of the following import statements are meaningful:
import java.util.AL; ✅ 
import java.util.AL.*; ❌
import java.util.*; ✅
import java.util; ❌

case 3:
-------
Consider the following code
class myObject extends java.rmi.UnicastRemoteObject {

}
The code compiles fine even though we are not writing import statement because we used fully qualified name.

# NOTE: Whenever we are using fully qualified name it is not required to write import statement, similarly whenever we are writing import statement it is not required to use fully qualified name.

case 4:
-------
e.g.
import java.util.*;
import java.sql.*;

class Test {
    public static void main(String[] args) {
        Date d = new Date();
    }
} // CE: reference to Date is ambiguous

# NOTE: Even in the case of List also we may get same ambiguity problem because it is available in both util and awt packages. 

case 5:
-------
While resolving class name, compiler will always gives precedence in the following order -
1. Explicit class import
2. Classes present in current working directory (default package)
3. Implicit class import

e.g.
import java.util.Date;
import java.sql.*;

class Test {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d.getClass().getName());
    }   
} // java.util.Date


case 6:
-------
Whenever we are importing a java package all classes and interfaces present in that package by default available but not sub-package classes.
If we want to use sub-classes package then we should write import statement until sub-package level. 

case 7:
-------
All classes and interface present in the following packages are by default available to every java program hence we are not required to write import statement -
1. java.lang;
2. default package (current working directory)

case 8:
-------
Import statement is totally compile time related concept. If more number of imports then more will be the compile time but there is no effect on execution time (runtime).

# 1.5v new feature:
for-each loop
var-arg method
Autoboxing and Autounboxing
Generics
co-varient return types
Queue
Annotations
enum
static import

# Static import:
Introduced in 1.5v.
According sun, usage of static import reduces length of the code and improves readability but according to world wide programing experts usage of static imports creates confusion and reduces readability hence if there is no specific requirement then it is not recommanded to use static import.
e.g.
import static java.lang.math.*;
class Test {
    public static void main(String[] args) {
        System.out.println(sqrt(4));
        System.out.println(max(4, 10));
        System.out.println(random());
    }
}

# Explain about System.out.println():
System is class present in java.lang package.
out is a static variable present in system class of the type PrintStream.
println() is a method present in PrintStream class.

e.g.
import static java.lang.System.out;
class Test {
    public static void main(String[] args) {
        out.println("Hello");
        out.println("Hi");
    }
}

While resolving static members, compiler will always consider the precedence in the following order:
1. Current class static members
2. Explicit static import
3. Implicit static import

e.g.
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Byte.*;
class Test {
    static int MAX_VALUE = 999;
    public static void main(String[] args) {
        System.out.println(MAX_VALUE);
    }
} // 999

# Packages:
It is an encapsulation mechanism to group related classes and interfaces into a single unit, which is nothing but package.
e.g.1:
All classes and interfaces which are required for database operations or grouped into a single package, which is nothing but java.sql package.

e.g.2:
All classes and interfaces which are useful for file io operations or grouped into a separate package, which is nothing but java.io package.
The main advantages of packages are :
1. To resolve naming conflicts i.e. unique identification of our components.
2. It improves modularity of the application.
3. It improves maintainability of the application.
4. It provides security for our components.

There is one universally accepted naming convention for packages i.e. to use internet domain name in reverse.
e.g.
com.icicibank.loan.housing.Account;

e.g.
package com.love.scjp;

public class Test {
    public static void main(String[] args) {
        System.out.println("Package demo");
    }
}
// javac Test.java:
- Generated .class file will be placed in current working directory.

// javac -d . Test.java :
- Generated .class file will be placed in corresponding package structure.

- If the corresponding package structure not already available then this command itself will create corresponding package structure.
- As destination instead of (.) we can any valid directory name, e.g. javac -d C: Test.java.
- If the specified directory is not already available then we will get compile time error.
- At the time of execution we have to use fully qualified name 
e.g. java com.love.scjp.Test // Package demo

Conclusion 1:
-------------
In any java source file there can be atmost one package statement i.e. more than one package statement is not allowed otherwise we will get compile time error.
e.g. 
package pack1;
package pack2;

public class A {

} // CE: class, interface or enum expected

Conclusion 2:
-------------
In any java program the first non-comment statement should be package statement (if it is available) otherwise we will get compile time error.
e.g.
import java.util.*;
package pack1;

public class A {

} // CE: class, interface or enum expected

# The following is the java valid source file structure:
Package statement --> Atmost one
import statement --> Any number
class / interface / enum / declarations --> Any number

# NOTE: An empty source file is a valid java program.

# Class Level Modifiers:
Whenever we are writing our own classes, we have to provide some information about our class to the JVM like whether this class can be accessible from anywhere or not, whether child class creation is possible or not whether object creation is possible or not, etc. We can specify this information by using appropriate modifiers.

- The only applicable modifiers for top level classes are:
public
<default>
final
abstract
strictfp

But for inner classes the applicable modifiers are:
public
<default>
final
abstract
strictfp
+
private
protected
static

e.g.
private class Test {
    public static void main (String[] args) {
        System.out.println("Hello");
    }
} // CE: modifier private not allowed here

# public classes:
If a class declared as public then we can access that class from anywhere.

# default classes:
If a class is not declared as public then we can access that class only within the current package i.e. from outside package we can't access. Hence default access is also known as package level access.

# final modifier:
final is a modifier applicable for classes, methods and variables. 
- final method:
whatever method parents has by default available to the child through inhetitance, if the child not satisfied with parent method implementation then child is allowed to redefine that method based on its requirement. This process is called overriding.
If the parent class method declared as final then we can't override that method in child class because its implementation is final.
e.g.
class Parent {
    public void property() {
        System.out.println("Cash + Land + Gold");
    }
    public final void marry() {
        System.out.println("Rina");
    }
}
class Child extends Parent {
    public void marry() {
        System.out.println("Isha / Sonia");
    }   
} // CE: marry() in Child cannot override marry() in Parent; Overridden method is final.

- final class:
If a class declared as final, we can't extend functionality of that class i.e. we can't create child class for that class that means inheritance is not possible for final classes.
e.g.
final class Parent {

}
class Child extends Parent {

} // CE: cannot inherit from final Parent

# NOTE: Every method present inside a final class is always final by default but every variable present inside final need not be final.
# The main advantage of final keyword is we can achieve security and we can provide unique implementation. But the disadvantage of final keyword is we are missing key benefits of OOPs: inheritance (because of final classes), polymorphism (because of final methods).

# abstract modifier:
abstract is a modifier applicable for classes and methods but not for variables.

- abstract method:
Even though we don't know about implementation still we can declare a method with abstract modifier i.e. for abstract methods only declaration is available but not implementation hence abstract method declaration should ends with semi-colon.
Child class is responsible to provide implementation for parent class abstract methods.
e.g.
abstract class Vehicle {
    abstract public int getNoOfWheels();
}
class  Bus extends Vehicle {
    public int getNoOfWheels {
        return 7;
    }
}
class  Auto extends Vehicle {
    public int getNoOfWheels {
        return 3;
    }
}
By declaring abstract method in the parent class, we can provide guidelines to the child classes such that which method compulsory child has to implement.
abstract method never talks about implementation. If any modifier talks about implementation then it forms illegal combination with abstract modifier.
The following are various illegal combination of modifiers for methods with respect to abstract:
abstract-final
abstract-native
abstract-synchronized
abstract-static
abstract-private
abstract-strictfp

- abstract class:
For any java class if we are not allowed to create an object (because of partial of implementation) such type of class we have to declare with abstract modifier i.e. for abstract classes instantiation is not possible.
e.g.
abstract class Test {
    public static void main (String[] args) {
        Test t = new Test();
    }
} // CE: Test is abstract; cannot be instantiated

# abstract class vs abstract method:
1. If a class contains at least one abstract method then compulsory we should declare class as abstract. Otherwise we will get compile time error. 
Reason: If a class contain at least one abstract method then implementation is not complete and hence it is not recommanded to create object. To restrict object creaation or instantiation compulsory we should declare class as abstract.
2. Even though class does not contain any abstract method still we can declare class as abstract if we don't want instantiation i.e. abstract class can contain zero number of abstract method also.

e.g.
class P {
    public void m1();
} // CE: missing method body, or declare abstract

# NOTE: It is highly recommanded to use abstract modifier because it promotes several OOP features like inheritance and polymorphism

# strictfp [strict floating point]:
Introduced in 1.2v.
We can use strictfp for classes and methods but not for variables.
Usually the result of floating-point arithmetic is varied from platform to platform, If we want platform independent results for floating point arithmetic then we should go for strictfp modifier.

- strictfp method:
If a method declared as strictfp, all floating-point calculation in that method has to follow IEEE 754 standard so that we will get platform independet results.
abstract modifier never talks about implementation whereas strictfp always talks about implementation hence abstarct-strictfp combination is illegal for methods.

- strictfp class:
If a class declared as strictfp, then every floating-point calculations present in every concrete method has to follow IEEE 754 standard so that we will get platform independent results.
We can declare abstract-strictfp combinations for classes i.e. abstract-strictfp combination is legal for classes but illegal for methods.

e.g.
abstract strictfp class Test {

} // ✅

abstract strictfp void m1(); ❌

# Member Modifiers (method or variable level modifier):
If a member declared as public then we can access that member from anywhere.
If both class and method are public then only we can access a method from outside package.

# default members:
If a member declared as default then we can access that member only within the current package. From outside of the package we can't access. hence default access is also known as package level access.

# private members:
If a member is private then we can access that member only within the class. From outside of the class we can't access.
abstract methods should be available to the child classes to provide implementation whereas private methods are not available to the child classes. Hence private-abstract combination is illegal for methods.

# protected members (The most misunderstood modifier in java):
If a member declared as protected then we can access that member anywhere within the current package but only in child classes of outside package.
protected = default + child classes

We can access protected members within the current package anywhere either by using parent reference or by using child reference.
But We can access protected members in outside package only in child classes and we should use child reference only. Parent reference cannot be used to access protected members from outside package.

e.g.
package pack1;
public class A {
    protected void m1() {
        System.out.println("Hey");
    }
}
class B extends A {
    public static void main(String[] args) {
        A a = new A();
        a.m1();
        B b = new B();
        b.m1();
        A a1 = new B();
        a1.m1();
    }
} // Hey (3 times)

e.g.
package pack2;
import pack1.A;
class C extends A {
    public static void main(String[] args) {
        A a = new A();
        a.m1();     // CE
        C c = new C();
        c.m1();     // valid
        A a1 = new C();
        a1.m1();    // CE
    }
} // CE

We can access protected members from outside package only in child classes and we should use that child class reference only.
e.g.
package pack2;
import pack1.A;
class C extends A {
    
} 
class D extends C {
    public static void main(String[] args) {
        A a = new A();
        a.m1();     // CE
        C c = new C();
        c.m1();     // CE
        A a1 = new C();
        a1.m1();    // CE
        D d = new D();
        d.m1();     // valid
    }
}

# final variables:
- final instance variables:
If the value of a variable is varied from object to object such type of variables are called instance varibale.
For every object a separate copy of instance variables will be created.
For instance variables we are not required to perform initialization explicitly. JVM will always provide default values.    
If the instance variable declared as final then compulsory we have to perform initialization explicitly. Whether we are using or not and JVM won't provide default values.
e.g.
class Test {
    final int x;
} // CE: variable x might not have been initialized

Rule: for final instance variables we should perform initialization before constructor completion.
The following are various places for initialization:
1. At the time of declaration:
class Test {
    final int x = 10;
}
2. Inside instance block:
class Test {
    final int x;
    {
        x = 10;
    }
}
3. Inside constructor:
class Test {
    final int x;
    Test() {
        x =
    }
}

- final static variables:
If a value of a variable not varied from object to object such type of variables are not recommanded to declare as instance variables.
We have to declare those variables at class level by using static modifier.
In the case of instance variables, for every variable a separate copy will be created but in the case of static variables a single copy will be created at class level and shared by every object of that class.
For static variables it is not required to perform initialization, JVM will always provide default values.

If the static variable declared as final then compulsory we should perform initialization explicitly. Otherwise we will get compile time error. JVM won't provide any default values.
e.g.
class Test {
    final static int x;
} // CE: variable x might not have been initialized

Rule: for final static variables we should perform initialization before class loading completion.
The following are various places for initialization:
1. At the time of declaration:
class Test {
    final static int x = 10;
}
2. Inside static block:
class Test {
    final static int x;
    static {
        x = 10;
    }
}


# final local variables:
The variables which are declared inside a method or block or constructor to meet temporary requirements of the programmer, such type of variables are called local variable or temporary variables or stack variable or automatic variables.
For local variables JVM won't provide default values, we have to perform initialization explicitly.
Even though local variable is final before using only we have to perform initialization, if we are not using then it is not required to perform initialization though it is final
class Test {
    public static void main(String[] args) {
        final static int x;
        System.out.println("Hello");
    }
} // Hello

The only applicable modifier for local variable is final.

# NOTE: If we are not declaring any modifier then by default it is default but this rule is applicable only for static and instance variables but not for local variables.


# static modifier:
static is a modifier applicable for methods and variables but not for classes. We can't declare top level class with static modifier but we can declare inner classes as static (such type of inner classes are called static nested classes).
In the case of static variables a single copy will be created at class level and shared by every object of that class.
We can't access instance members directly from static area but we can access from instance area directly. We can access static members from both instance and static areas directly.
# NOTE: For static methods overloading and inheritance concepts are applicable but overriding is not applicable. Insteadof overriding, method hiding concept is applicable.

# synchronized modifier:
- synchronized is a modifier applicable for methods and blocks but not for classes and variables.
If multiple threads trying to operate simultaneously on the same java object then there may be a chance of data inconsistency problem. This is called race condition.
We can overcome this problem by using synchronized keyword.
- If a method or block is declared as synchronized then at a time only one thread is allowed to execute that method or block or given object. so that data inconsistency problem will be resolved.
- But the disadvantage of this keyword is it increases waiting time of threads. and creates performance problems hence if there is no specific requirements then it is not recommanded to use synchronized keyword.
- Synchronized method should contain implementation whereas abstract method does not contain any implementation hence abstract-synchronized is illegal combination of modifiers for methods.

# native modifier:
- native is a modifier applicable only for methods and we can't apply anywhere else.
- The methods which are implemented in non-java (mostly c or c++) are called native methods or foriegn methods.
- The main objectives of native keyword are to improve performance of the system.
- To achieve machine level or memory level communication.
- To use already existing legacy non-java code.

pseudo code to use native keyword in java:
e.g.
class Native {
    static {
        System.loadLibrary("native library");
    }
    public native void m1();
}

class Client {
    public static void main(String[] args) {
        Native n = new Native();
        n.m1();
    }
}

- for native methods implementation is already available in old languages like c or c++ and we are not responsible to provide implementation. Hence native method declaration should ends with semi-colon.
- the main advantage of native keyword is performance will be improved but the main disadvange is, it breaks platform independent nature of java


# transient keyword:
- transient is a modifier applicable only for variables.
- we can use transient keyword in serialization context.
- At the time of serialization, if we don't want to save value of a particular variable to meet security constaint then we should declare that variable as transient.
- At the time of serialization, JVM ignores original value of transient variable and save default value to the file, hence transient means not to serailize.


# volatile modifier:
- volatile is a modifier applicable only for variables.
- If a value of a variable keep on changing by multiple threads then there may be chance of data inconsistency problem, we can solve this problem by using volatile modifier.
- If a variable declared as volatile then for every thread, JVM will create a separate local copy.
- Every modification performed by the thread will takes place in local copy so that there is effect on remaining threads.
- the main advantage of volatile keyword is we can overcome data inconsistency problem but the main disadvantage of volatile keyword is creating and maintaining a separate copy for every thread increases complexity of programming and creates performance problems hence if there is no specific requirements, it is never recommanded to use volatile keyword and it is almost deprecated keyword.
- final-volatile is illegal combination for variables.