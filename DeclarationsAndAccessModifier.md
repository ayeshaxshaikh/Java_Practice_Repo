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

# NOTE: Even in the case of List also we may get same ambiguouty problem because it is available in both util and awt packages. 

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