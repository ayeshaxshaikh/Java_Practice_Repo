# IS-A Relationship:
- It is also known as inheritance.
- The main advantage of IS-A relationship is code reusability.
- By using extends keyword we can implement IS-A relationship.

e.g.
class P
{
    public void m1()
    {
        System.out.println("Parent");
    }
}

class C extends P
{
    public void m2()
    {
        System.out.println("Child");
    }   
}

class Test 
{
    public static void main(String[] args) {
        P p = new P();
        p.m1();
        p.m2();  // Invalid

        C c = new C();
        c.m1();
        c.m2(); 

        P p1 = new C();
        p1.m1();
        p1.m2();  // invalid

        C c1 = new P(); // invalid
    } 
}

# Conclusion:
- Whatever methods parent has by default available to the child and hence on the child reference we can call both parent and child methods.
- Whatever methods child has by default not available to the parent and hence on the parent reference we can't call child specific methods.
- Parent reference can be used to hold child object but by using that refernce we can't call child specific methods but we can call the methods present in parent class.
- Parent reference can be used to hold child object but Child refernce cannot be used to hold parent object.

# Without Inheritance:
class VLoan 
{
    300 methods
}

class HLoan
{
    300 methods
}

class PLoan
{
    300 methods
}

# With Inheritance

class Loan
{
    250 common methods
}

class VLoan extends Loan
{
    50 specific methods
}

class HLoan extends Loan
{
    50 specific methods
}

class PLoan extends Loan
{
    50 specific methods
}

# NOTE: 
- The most common methods which are applicable for any type of child, we have to define in parent class.
- The specific methods which are applicable for a particular child, we have to define in child class.
- Total Java API is implemented based on inheritance concept.
- The most common method which are applicable for any java object are defined in Object class and hence every class in Java is a child class of object either directly or indirectly so that object class method by default availble to every Java class without rewriting. 
- Due to this Object class acts root for all java classes.

# multiple inheritance:
- A java class can't extend more than one class at a time hence Java won't provide support for multiple inheritance in classes.

# NOTE:
- If our class does not extend any other class then only our class is direct child class of Object.
- If our class extends any other class then our class is indirect child class of Object.
- Either directly or indirectly java won't provide support for multiple inheritance with respect to classes.

# Why java won't provide support for multiple inheritance?
- There may be a chance of ambiguity problem, hence Java won't provide support for multiple inheritance.
C --> p1 -> m1()
|
p2 -> m1()

- But Interface can extend any number of interface simultaneously hence java provide support for multiple inheritance with respect to interfaces.
e.g.
interface A {}
interface B {}
interface C extends A, B {}

# Why ambiguity problem won't be there in interfaces?
PI1 --> m1();
PI2 --> m1();

CI --> m1();

Though multiple method declarations are available, but implementation is unique and hence there is no chance of ambiguity problem in interfaces.

# NOTE: Strictly speaking through interfaces, we won't get any inheritance.


# HAS-A relationship:
- HAS-A relationship is also known as Composition or Aggregation.
- There is no specific keyword to implement HAS-A relation but most of the time we are depending on new keyword.
- The main advantage of HAS-A relationship is reusability of the code.

e.g.
class Engine 
{
    // engine specific functionality
}

class class 
{
    Engine e = new Engine();
}
Car HAS-A Engine refernce

# Differnce between Composition and Aggregation:
- Without existing container object, if there is no chance of existing contained objects then container and contained objects are strongly associated and this strong association is nothing but composition.
e.g. University consists of several department. Without existing university there is no chance of existing department. Hence University and department are strongly associated and this strong association is nothing but Composition.

- Without existing container object, if there is chance of existing contained objects then container and contained objects are weakly associated and this weak association is nothing but Aggregation.
e.g. Department consists of several professors. Without existing department there may be chance of existing professors object. Hence department and professor objects are weakly associated and this weak association is nothing but Aggregation.

# NOTE: 
- In Composition, objects are strongly associated whereas in Aggregation, objects are weakly associated.
- In composition, container objects holds directly contained objects whereas in aggregation, container objects holds just references of contained objects.

# IS-A vs HAS-A:
- If we want a total functionality of a class automatically then we should go for IS-A relationship.
- If we want part of the functionality then we should go for HAS-A relationship.


# method signature:
- In java, method signature consists of method names followed by argument types.
e.g. m1(int, float)
- return type is not part of method signature in Java.
- within a class two methods with the same signature not allowed.

e.g.
class Test
{
    public void m1(int i)
    {

    }
    public int m1(int x)
    {
        return x;
    }
} // CE: m1(int) is already defined in Test.