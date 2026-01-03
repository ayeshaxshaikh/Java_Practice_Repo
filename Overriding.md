- Whatever methods parent has by default available to the child through inheritance. If child class not satisfied with parent class implementation then child is allowed to redefine that method based on its requirement. This process is called overriding.
- The parent class method which is overridden is called overridden method and the child class method which overriding is called overriding methods.

e.g.
class P
{
    public void property()
    {
        System.out.println("Cash + Land + Gold");
    }
    public void marry()
    {
        System.out.println("Sophia");
    }
}

class C extends P
{
    public void marry()
    {
        System.out.println("Reema | Tara | Sara");
    }
}

class Test
{
    public static void main(String[] args)
    {
        P p = new P();
        p.marry(); // parent method

        C c = new C();
        c.marry(); // child method

        P p1 = new C();
        p1.marry();  // child method
    }
}

# In overriding, method resolution is always takes care by JVM based on runtime object and hence overriding is also considered as runtime polymorphism or dynamic polymorphism or late binding.

# rules for overriding:
- In overriding, method names and argument types must be matched i.e. method signature must be same.
- In overriding, return types must be same but this rule is applicable until 1.4v only. From 1.5v onwards, we can take co-varient return types. According this child class method retun type need not to be same as parent method return type. Its child type also allowed.

e.g.
class P
{
    public Object m1() {
        retun null;
    }
}

class C extends P
{
    public String m1()
    {
        return null;
    }
}

# parent class method return type --> child class method return type
Object --> Object | String | StringBuffer...
Number --> Number | Integer...
double --> int //  invalid
String --> Object // invalid

- Co-varient return type concept applicable only for object types but not for primitive typess.

- Parent class private methods not available to the child and hence overriding concept not applicable for private methods.
- Based on our requirement, we can define exactly same private method in child class, it is valid but not overriding.

e.g.
class P
{
    private void m1() {
    
    }
}

class C extends P
{
    private void m1()
    {
        
    }
}

- We can't override parent class final methods in child classes. If we are trying to override then we will get compile time error.
- Parent class abstract methods, we should override in child class to provide implemeentation.

abstract class P
{
    public abstract void m1();
}

class C extends P
{
    public void m1()
    {

    }
}

- We can override non-abstract method as abstract.

class P
{
    public void m1()
    {

    }
}

abstract class C extends P
{
    public abstract void m1();
}

- The main advantage of this approach is we can stop availability of parent method implementation to the next level child classes.

- While overriding, we can't reduce scope of access modifier but we can increase the scope.
class P
{
    public void m1()
    {

    }
}

class C extends P
{
    void m1() 
    {
    
    }
}  // ❌

- private < default < protected < public
public --> public
protected --> protected | public
default --> default | protected | public
private --> Overriding concept not applicable for private methods


# checked and unchecked exceptions:
- If child class method throws any checked exception, compulsory parent class method should throw same checked exception or its parent otherwise we will get compile time error but there are no restrictions for unchecked exception.

1. P: public void m1() throws Exception
   C: public void m1() ✅

2. P: public void m1()
   C: public void m1() throws Exception ❌

3. P: public void m1() throws Exception
   C: public void m1() throws IOException ✅

4. P: public void m1() throws IOException
   C: public void m1() throws Exception ❌

5. P: public void m1() throws IOException
   C: public void m1() throws FileNotFoundException, EOFException ✅

6. P: public void m1() throws IOException
   C: public void m1() throws EOFException, InterruptedException ❌

7. P: public void m1() throws IOException
   C: public void m1() throws AE, NPE, CCE  ✅         


# Overriding with respect to static methods:
- We can't override a static method as non-static otherwise we will get compile time error.
e.g.
class P
{
    public static void m1(){

    }
}

class C extends P
{
    public void m1()
    {

    }
} // CE: m1() in C cannot override m1() in in P; overridden method is static

- Similarly, we can't override a non-static method as static.
e.g.
class P
{
    public void m1(){

    }
}

class C extends P
{
    public static void m1()
    {

    }
} // CE: m1() in C cannot override m1() in in P; overriding method is static

- If both parent and child class methods are static, then we won't get any compile time error. It seems overriding concept applicable for static methods but it is not overriding and it is method hiding.

e.g.
class P
{
    public static void m1(){

    }
}

class C extends P
{
    public static void m1()
    {

    }
}  // method hiding not overriding

# method hiding:
- All rules of method hiding are exactly same as overriding except the following differences:

method hiding                                                 |              overriding
------------------------------------------------------------------------------------------------------------------------------------------
1. Both parent and child class methods should be static            Both parent and child class methods should non-static
2. Compiler is responsible for method resolution based on          JVM is always responsible for method resolution based on runtime object
refernce type 
3. It is also known as Compile time polymorphism or static         It is also known as runtime polymorphism or dynamic polymorphism or late 
polymorphism or early binding.                                     binding    

e.g.
e.g.
class P
{
    public static void m1(){
        System.out.println("parent");
    }
}

class C extends P
{
    public static void m1()
    {
        System.out.println("child");
    }
} 

class Test
{
    public static void main(String[] args)
    {
        P p = new P();
        p.m1();  // parent

        C c = new C();
        c.m1();  // child

        P p1 = new C();
        p1.m1();  // child
    }
}

- If both parent and child class methods are non-static then it will become overriding. In this case out is
parent, child, child.

# Overriding with respect to var-arg methods:
- We can override var-arg method with another var-arg method only. If we are trying to override with a normal method then it will become overloading but not overriding.

e.g.
class P
{
    public void m1(int... x)
    {
        System.out.println("parent");
    }
}

class C extends P
{
    public void m1(int x)
    {
        System.out.println("child");
    }
}

class Test
{
    public static void main(String[] args)
    {
        P p = new P();
        p.m1();  // parent

        C c = new C();
        c.m1();  // child

        P p1 = new C();
        p1.m1();  // parent
    }
}

- In the above program, if we replace a child method with var-arg method then it will become overriding.
In this case the output is parent, child, child

# Overriding with respect to variables:
- Variable resolution always takes care by compiler based on reference type irrespective of whether the variable is static or non-static (overriding concept applicable only for methods but not for variables).

e.g.
class P
{
    int x = 888;
}

class C extends P
{
    int x = 999;
}

class Test
{
    public static void main(String[] args)
    {
        P p = new P();
        System.out.println(p.x);  // 888

        C c = new C();
        System.out.println(c.x);  // 999

        P p1 = new C();
        System.out.println(p1.x);  // 888
    }
}


# Differences between overloading and overriding:

property                             overloading                                  overriding
------------------------------------------------------------------------------------------------------------------------------------
1. method names                      must be same                                 must be same
2. argument types                    must be different(at least ordder)           must be same (including order)
3. method signature                  must be different                            must be same
4. return types                      No restrictions                              must be same until 1.4v. from 1.5v onwards co-varient
                                                                                  return types allowed
5. private, static, final            can be overloaded                            cannot be overridden
methods                                                                                   
6. access modifiers                  no restrictions                              we can't reduce scope of access modifier but we can
                                                                                  increase the scope.


# Note: In overloading we have to check only method names (must be same) and argument types (must be different). We are not required to check remaining like return types, access modifiers etc. But in overriding everything we have to check like method names, argument types, return types, access modifiers, throws class, etc.


# Polymorphism:
- One name but multiple forms is a concept of polymorphism.
- e.g. method name is same but we can apply for different types of arguments (overloading).
e.g.
abs(int)
abs(float)
abs(long)

- method signature is same but in parent class one type of implementation and in the child class another type of implementation (overriding).

- usage of parent refernce to hold child object is the concept of polymorphism.
e.g.
List l = new AL() | new LL() | new Vector() | new Stack();

- parent class reference can be used to hold child object but by using that reference we can call only the methods available in parent class and we can't call child specific methods.
- But by using child reference we can call both parent and child class methods.
