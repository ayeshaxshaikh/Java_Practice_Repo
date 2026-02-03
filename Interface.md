# Introduction:
- Any service requirement specification (SRS) is considered as an interface.
e.g.
JDBC API acts as requirement specification to develop database driver.
Database vendor is responsible to implement JDBC API.

e.g.
servlet API acts as requirement specification to develop web server.
Web server vendor is responsible to implement servlet API.

- From client point of view an interface defines the set of services what they are expecting.
From service provider point of view an interface defines the set of services what they are offering hence any contract between client and service provider is considered as an interface.

- Inside interface every method is always abstract whether we are declaring or not hence interface is considered as 100% pure abstract class.

summary defination:
Any service requirement specification or any contract between client and service provider or 100% pure abstract class is interface.

- Whenever we are implementing an interface, for each and every method of that interface we have to provide implementation otherwise we have to declare class as abstract then next level child class is responsible to provide implementation.
- Every interface method is always public and abstract whether we are declaring or not hence whenever we are implementing an interface method, compulsory we should declare as public, otherwise we will get compile time error.

e.g.
interface Interf {
    void m1();
    void m2();
}

abstract class ServiceProvider implements Interf {
    public void m1() {

    }
}

class SubServiceProvider extends ServiceProvider {
    public void m2() {

    }
}

# extends vs implements:
- A class can extends only one class at a time
- An interface can extends any number of interfaces simultaneously
e.g. 
interface A {
}
interface B {
}
interface C extends A, B {
}

- A class can implements any number of interfaces simultaneously.
- A class can extend another class and can implement aany number of interfaces simultaneously.
e.g.
class A extends B implements C, D, E {}

- We have to take extends first followed by interface.

# interface-methods:
Every method present inside interface is always public and abstract whether we are declaring or not.

- It is public to make the method available to every implementation class.
- It is abstract: Implementation class is responsible to provide implementation.
Hence inside interface, the following method declarations are equal:
void m1();
public void m1();
abstract void m1();
public abstract void m1();

- An interface can contain variables. The main purpose of interface variables is to define requirement level constant.
- Every interface variable is always public static final whether we are declaring or not.
public: To make this variable available to every implementation class.
static: without existing object, implementation class can access this variable.
final: If one implementation class change value the remaining implementation will be affected. To restrict this, every interface variable is always final.

- For interface variables, we should perform initialization at the time of declaration otherwise we will get compile time error.
- Inside implementation class, we can access interface variables but we can't modify values.

# interface naming conflicts:
1. method naming conflicts:
case 1:
If 2 interfaces contain a method with a same signature and same return type then in the implementation class we have to provide implementation for only one method.
e.g.
interface Left {
    public void m1();
}

interface Right {
    public void m1();
}

class Test implements Left, Right {
    public void m1() {

    }
}

case 2:
If 2 interfaces contain a method with a same name but different argument type then in the implementation class we have to provide implementation for both method. These methods acts as overloaded methods
e.g.    
interface Left {
    public void m1();
}

interface Right {
    public void m1(int i);
}

class Test implements Left, Right {
    public void m1() {
    }
    public void m1(int i) {
    }
}

caase 3:
If 2 interfaces contain a method with a same name but different return type then it is impossible to implement both interfaces simultaneously. If return types are not co-varient.

2. variable naming conflicts:
- 2 interfaces can contain a variable with the same name and there may be a chance of variable naming conflicts but we can solve this problem by using interface names.
e.g.    
interface Left {
    int x = 100;
}

interface Right {
    int x = 200;
}

class Test implements Left, Right {
    public static void main(String[] args) {
        System.out.println(Left.x);
        System.out.println(Right.x);
    }
}

# Marker Interface (Very Important):
If an interface doesn't contain any methods and by implementing that interface if our objects get some ability. Such type of interface are called marker interfaces.
e.g.
Serializable(I)
Cloneable(I)
RandomAccess(I)
SingleThreadModel(I)

e.g.
By implementing Serializable(I), our objects can be saved to the file and can travel across the network.

e.g.
By implementing Cloneable(I), our objects are in a position to produce exactly duplicate cloned objects.

# Internally JVM is responsible to provide required ability in marker interface.
# To reduce complexity of programming and to make java language as simple.

# Adapter classes:
Adapter class is a simple Java class that implements an interface with only empty implementation.
e.g.
interface X {
    m1();
    m2();
    m3();
    m100();
}
class Adapter X implements X
{
    m1(){}
    m2(){}
    m3(){}
    m100(){}
}

If we implement an interface, for each and every method of that interface, we must provide implementation whether it is required or not required.
class Test implements X
{
    m1(){}
    m2(){}
    m3(){}
    m100(){}
} 

The problem in this approach is, it increases length of the code and reduces readability.
We can solve this problem by using Adapter classes.
Instead of implementing interface, if we extends adapter class we have to provide implementation only for required methods. 
We are not responsible to provide implementation for each and every method of that interface. So that length of the code will be reduced.

class Test extends Adapter X {
    m3() {

    }
}

class Sample extends Adapter X 
{
    m7() {

    }
}

# interface vs abstract class vs concrete class
- If we don't know anything about implementation, just we have requirement specification then we should go for interface.
e.g. Servlet(I)

- If we are talking about implementation but not completely (partial implementation) then we should go for abstract class.
e.g
GenericServlet(AC)
HttpServlet(AC)

- If we are talking about implementation completely and we are ready to provide service then we should go for concrete class.

# Differences between interface and abstract class (very important):

interface                                             |          abstract class
---------------------------------------------------------------------------------------------------------------------
- If we don't know anything about implementation,        If we are talking aabout implementation but not completely (partial 
just we have requirement specification then we           implementation) then we should go for abstract class.
should go for interface.

- Inside interface, every method is always public         Every method present inside abstract class need not be public and abstract
and abstract whether we are declaring or not              and we can take concrete method also
hence interface is considered as 100% pure abstarct
class

- every variable present inside interface is always       Every variable present inside abstract class need not be public static final.
public static final.

- for interface variables, we should perform              for abstract class variables, we are not required to perform initialization at 
initialization at the time of declaration.                the time of declaration.

- inside interface we can't declare static and            inside abstract class we can declare static and instance blocks
instance blocks

- inside interface we can't declare constructors          inside abstract class we can declare constructors

# Note: Either directly or indirectly we can't create object for abstract class.

- Whenever we are creating child class object, parent object won't be created, just parent class constructor will be executed for the child object purpose only

- If everything is abstract then we should go for interface not abstract class.


# new vs Constructor:
- The main objective of new operator is to create an object.
- The main purpose of Constructor is to initiaze object.
- First object will be created by using new operator and then initialization will be performed by constructor.

e.g.
class Student {
    String name;
    int rollno;
    Student(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
    }
}
Student s = new Student("Love", 18);

# Child Object vs Parent Constructor:
- Whenever we are creating child class object automatically parent constructor will be executed to perform initialization for the instance variables which are inherating from parent.
e.g.
class Person
{
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends Person 
{
    int rollno;
    int marks;
    Student(String name, int age, int rollno, int marks)
    {
        super(name, age);
        this.rollno = rollno;
        this.marks = marks;
    }
}

Student s = new Student("Love", 22, 101, 90);

- In the above program, both parent and child contructors executed for child object initialization only.

# Whenever we are creating child class object, parent contructor will be executed but parent object won't be created.
e.g.
class P
{
    P()
    {
        System.out.println(this.hashCode());
    }
}

class C extends P
{
    C()
    {
        System.out.println(this.hashCode());
    }
}

class Test 
{
    public static void main(String[] args)
    {
        C c = new C();
        System.out.println(c.hashCode());
    }
}
1392838282
1392838282
1392838282

- In the above example, we just created only child class object but both parent and child contructor will executed for that child class object.

# need of abstract class constructor:
- Anyway we can't create object for abstract class either directly or indirectly, but abstract class can contain constructor. 
- The main objective of abstract class contructor is to perform initialization for the instance variables which are inherating from abstract class to the child class.
- Whenever we are creating child class object automatically, abstract class constructor will be executed to perform initialization for the instance variables which are inherating from abstract class (code reusability).
abstract class Person
{
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends Person 
{
    int rollno;
    int marks;
    Student(String name, int age, int rollno, int marks)
    {
        super(name, age);
        this.rollno = rollno;
        this.marks = marks;
    }
}

Student s = new Student("Love", 22, 101, 90);

class Teacher extends Person 
{
    double salary;
    String subject;
    Teacher(String name, int age, double salary, String subject)
    {
        super(name, age);
        this.salary = salary;
        this.subject = subject;
    }
}

Teacher s = new Teacher("Peter", 42, 70.0, "Java");

# Abstract class vs Interface with respect to Constructor:
- Anyway we can't create object for abstract class and interface, but abstract class can contain constructor but interface does not.
- The main purpose of constructor is to perform initialization of object that is to perfrom initialization for instance variables.
- Abstract class can contain instance variables which are required for child class object, to perfrom initialization for these instance variables constructor concept is required for abstract classes.
- Every variable present inside interface is always public static final whether we are declaring or not hence there is no chance of existing instance variables inside interface.   
- Because of this constructor concept not required for interfaces.


# If everything is abstract then it is highly recommanded to go for interface but not abstract class.
- We can replace interface with abstract class but it is not a good programming practice.

e.g.
interface X 
{

}

While implementing interface we can extend any other class and hence we won't miss inheritance benefit

abstract class X
{

}

While extending abstract class we can't extend any other class. Hence we are missing inheritance benefit.

class Test extends A implements X 
{

} ✅

class Test implements X
{

}

Test t = new Test();

In this case object creation is not costly.

Class Test extends A, X 
{
    
} ❌

class Test extends X
{

}

Test t = new Test();

In this case object creation is costly.

