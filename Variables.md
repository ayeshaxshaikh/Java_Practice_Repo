Types Of Variables:
-------------------
⦁	Division 1:
Based on type of value represented by a variable, all variables are divided into two types -
Primitive Variables, can be used to represent primitive values.
e.g. int x = 10;
Reference Variables, can be used to refer Objects.
e.g. Student s = new Student();

⦁	Division 2:
Based on position of declaration and behavior all variables are divided into 3 types -
1.	Instance Variables
2.	Static Variables
3. Local Variables


Instance Variables:
⦁	If the value of a variable is varied from object to object, such type of variables are called instance variables.
⦁	For every object, a separate copy of instance variable will be created.
⦁	Instance variables should be declared within the class directly but outside of any method or block or constructor.
⦁	Instance variable will be created at the time of object creation, and destroyed at the time of object distraction. Hence the scope of instance variable is exactly same as scope of object
⦁	Instance variable will be stored in the heap memory as a part of object.
⦁	We cannot access instance variables directly from static area but we can access by using object reference.
⦁	But we can access instance variables directly from instance area.

class Main {
    int x = 10;
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.x);
    }
}

for instance variables, JVM will always provide default values and we are not required to perform initialization explicitly.
class Main {
    int x;
    double d;
    boolean b;
    String s;
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.x);
        System.out.println(m.d);
        System.out.println(m.b);
 	System.out.println(m.s);
    }
}

Instance variables also known as Object level variables or attributes.


Static Variables:
If the value of a variable is not varied from object to object then it is not recommended to declare variable as instance variable. We have to declare such type of variable as class level by using static modifier.
In the case of instance variables, for every object a separate copy will be created but in the in the case of static variables a single copy will be created at class level and shared by every object of the class.
Static variable should be declared within the class directly but outside of any method of any method or block or constructor.
Static variables will be created at the time of class loading and destroyed at the time of class unloading hence scope of static variable exactly same as scope of that class file.

Java Test File:
1.	Start JVM
2.	Create and start main thread
3.	Locate Test.class file
4.	Load Test.class
5.	Execute main() method
6.	unload Test.class
7.	Terminate main Thread
8.	Shutdown JVM

Static variables will be stored in method area.
We can access static variables either by object reference or by class name, but recommended to use class name.
Within the same class it is not required to use class name and we can access directly.

class Main {
    static int x = 10;
    public static void main(String[] args) {
        System.out.println(x);
    }
    public void main() {
        System.out.println(x);
    }
}

We can access static variables directly from both instance and static areas.
class Main {
    static int x;
    static double d;
    static boolean b;
    static String s;
    public static void main(String[] args) {
        System.out.println(x); // 0
        System.out.println(d); // 0.0
        System.out.println(b); // false
 	System.out.println(s); // null
    }
}

For static variables, JVM will provide default values and we are not required to perform intialization explicitly.
Static variables also known as class level variables or fields.
class Main {
    static int x = 10;
    int y = 20;
    public static void main(String[] args) {
        Main m1 = new Main();
        m1.x = 40;
        m1.y = 50;
        Main m2 = new Main();
        System.out.println(m2.x); // 40
        System.out.println(m2.y); // 20
    }
}


Local Variables:
Sometimes, to meet the temporary requirements of the programmer we can declare variables inside a method or block or constructor such type of variables are called local variables or temporary variables or stack variables or automatic variables.
Local variables will be stored inside stack memory.
Local variables will be created while executing the block in which we declared it. Once block execution completes automatically local variables will be destroyed hence the scope of local variables is block in which we declared it.
for (int i = 0; i < 5; i++) {
    int temp = i * 2;  // temp is a local variable to this loop block
    System.out.println("Temp value: " + temp);
}
For local variables, JVM will not provide default values, compulsory we should perform initialization explicitly before using that variable. i.e. if we are not using then it is not required to perform initialization.
class Main {
    public static void main(String[] args) {
 	int x;
        System.out.println("hello"); // hello
    }
}

class Main {
    public static void main(String[] args) {
 	int x;
        System.out.println(x); // error
    }
}


class Main {
    public static void main(String[] args) {
        int x;
        if (args.length > 0) {
            x = 10;
        } else {
            x = 20;
        }
        System.out.println(x);
    }
} // 20 because it will execute the else condition

NOTE: It is not recommended to perform initialization for local variables inside logical blocks because there is no guarantee for the execution of these blocks always at runtime.
NOTE: It is highly recommended to perform initialization for local variables at the time of declaration at least with default values.

The only applicable modifier for local variables is final. If we are trying to apply any modifier then we will get compile time error.

NOTE: If we are not declaring with any modifier then by default it is default but this rule is applicable only for instance and static variables but not for local variables.

Conclusion: For instance and static variables JVM will provide default values and we are not  required to perform initialization explicitly. But for local variables JVM won't provide default values compulsory we should perform initialization explicitly before using that variable.
Instance & Static variables can be accessed by multiple threads simultaneously and hence these are not thread safe but in the case of local variables for every thread a separate copy will be created and hence local variables are thread safe.

Every variable in Java should be either instance or static or local.
Every variable in Java should be either primitive or reference. 
Hence various possible combination of variables in Java are: 
Instance - Instance primitive, Instance reference
Static - Static primitive, Static reference
Local - Local primitive, Local reference
