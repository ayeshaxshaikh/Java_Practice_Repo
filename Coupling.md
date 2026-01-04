- The degree of dependency between the components is called coupling.
- If dependency is more, then it is considered as tightly coupling.
- If dependency is less, then it is considered as loosely coupling.

e.g.
class A
{
    static int i = B.j;
}

class B
{
    static int j = C.k;
}

class C
{
    static int k = D.m1();
}

class D
{
    public static int m1()
    {
        return 10;
    }
}

- The above components are said to be tigthly coupled because dependency between the components is more.
- Tightly coupling is not a good programming practice because it has several serious disadvantages:
1. Without affecting remaining components, we can't modify any component and hence enhancement will become difficult.
2. It supresses reusability.
3. It reduces maintainability of the application.

- Hence we have to maintain dependency between the components as less as possible i.e. loosely coupling is a good programming practice.


# Cohesion:
- For every component, a clear well defined functionality is defined then that component is said to be follow high cohesion.
- High cohesion is always a good programming practice because it has several advantages:
1. Without affecting remaining components, we can modify any component and hence enhancement will become easy.
2. It promotes reusability of the code.
3. It improves maintainability of the application.

# NOTE: Loosely coupling and high cohesion are good programming practices.


# Object type casting:
- We can use parent reference to hold child object.
e.g.
Object o = new String("love");

- we can use interface reference to hold implemented class object.
e.g.
Runnable r = new Thread();

# Compile time checking - 1
A b = (C) d;
- The type of 'd' and C must have some relation. Either child to parent or parent to child or same type. Otherwise we will get compile time error saying inconvertible type.

e.g.
Object o = new String("love");
StringBuffer sb = (StringBuffer)o;  // No compile time error

e.g.
String s = new String("love");
StringBuffer sb = (StringBuffer)s; // CE: inconvertible type

# Compile time checking - 2
A b = (C) d;
- 'C' must be either same or derived type of 'A' otherwise we will get compile time error saying incompatible type.

e.g.
Object o = new String("love");
StringBuffer sb = (StringBuffer)o; // No compile time error

e.g.
Object o = new String("love");
StringBuffer sb = (String)o; // CE: Incompatible type; found: java.lang.String required: java.lang.StringBuffer


# Runtime checking:
- Runtime object type of 'd' must be either same or derived type of 'C' otherwise we will get runtime exception saying ClassCastException..
e.g.
Object o = new String("love");
StringBuffer sb = (StringBuffer)o; // RE: ClassCastException

e.g.
Object o = new String("love");
Object o1 = (String)o;  // valid\


# type-casting:
- Strictly speaking through type-casting we are not creating any new object.
- For the existing object we are providing another type of reference variable i.e. we are performing type-casting but not object casting.
e.g.
String s = new String("love");
Object o = (Object)s;

e.g.
Integer I = new Interger(10);
Number n = (Number)I;
Object o = (Object)n;

or

Object o = new Interger(10);

# NOTE:
C c = new C();
B b = (B)c;  == B b = new C();