Increment and Decrement Operators
Arithmetic Operators
String concatination Operator
Relational Operators
Equality Operators
instanceof operators
bitwise operator
short circuit operators
type cast operators
assignment operators
conditional operators
new operator
[ ] operator
operator precendense
Evaluation order of operands
new Vs newInstance()
ClassNotFoundException Vs NoClassDefFoundError

# Increment and Decrement Operators:
Exception | initial value of x | value of y | final value of x
---------------------------------------------------------------
y = ++x;      10                    11           11
y = x++;      10                    10           11
y = --x;      10                    9            9
y = x--;      10                    10           9

We can apply increment and decrement operators only for variables but not for constant values. If we are trying to apply for constant values then we will get compile time error.

e.g. 1:
int x = 10;
int y = ++x;
Sopln(y); // 11 

e.g. 2:
int x = 10;
int y = ++10;
Sopln(y); // Compile time Error

e.g. 3:
int x = 10;
int y = ++ (++x);
Sopln(y); // Compile time error

e.g. 4:
final int x = 10;
x = 11;
Sopln(x); // Compile time error

e.g. 5:
int x = 10;
x++;
Sopln(x); // Compile time error

# NOTE: For final variables we cannot apply increment and decrement operators.

e.g. 6:
char ch = 'a';
ch++;
Sopln(ch); // b

e.g. 7:
double d = 10.5;
d++;
Sopln(d); // 11.5

# NOTE: We can apply increment and decrement operators in every primitive type except boolean.

# Difference between b++ and b = b + 1: 
If we apply any arithmetic operator between two variables a and b, the result type is always max(int, type of a, type of b);
byte a = 10;
byte b = 20;
byte c = a + b;
Sopln(c) // Compile time error: Possible loss of precision, found: int, required: byte

byte a = 10;
byte b = 20;
byte c = (byte)(a + b); 
Sopln(c) // 30

e.g.
byte b = 10;
b = b + 1;
Sopln(b) // CE
because max(int, byte, int) => int
but we solve this using
b = (byte)(b + 1); // 11

e.g.
byte b = 10;
b++;  // b = (type of b)(b+1)
Sopln(b); // 11

# NOTE: In the case of increment and decrement operator, internal type casting will be performed automatically.

# Arithmetic Operators (+, -, *, /, %): 
If we apply any arithemetic operator between two variables a and b, the result type is always max(int, type of a, type of b)

byte + byte = int
byte + short = int
short + short = int
byte + long = long
long + double = double
float + long = float
char + char = int
char + double = double

- In integral arithmetic (byte, short, int, long) there is no way to represent Infinity hence if infinity is the result we will get arithmetic exception in integral arithmetic.
e.g.
Sopln(10/0); RE: AE / by zero

But in floating-point arithmetic (float and double) there is a way to represent Infinity.
For these float and double classes contains the following 2 constants:
POSITIVE_INFINITY;
NEGATIVE_INFINITY;
Hence even though result is infinity we won't get any arithmetic exception in floating-point arithmetic.
Sopln(10/0.0); // Infinity
Sopln(-10/0.0); // -Infinity

- NaN: In Integral arithmetic (byte, short, int, long) there is no way to represent undefined result hence if the result is undefined then we will get run time exception saying arithmetic exception.
e.g. Sopln(0/0); // RE: AE / by zero

But in floating-point arithmetic (float and double) there is a way to represent undefined. 
For these float and double classes contains NaN constant, hence if the result is undefined we won't get any arithmetic exception in floating-point arithmetic
Sopln(0.0/0); // NaN
Sopln(-0/0.0); // NaN

# Note: for any x value includung NaN the following expressions returns false:
x < NaN
x <= NaN
x > NaN
x >= NaN
x == NaN

# For any x value including NaN the following expresssion returns true:
x != NaN; // true

Sopln(10 < Float.NaN); false
Sopln(10 <= Float.NaN); false
Sopln(10 > Float.NaN); false
Sopln(10 >= Float.NaN); false
Sopln(10 == Float.NaN); false
Sopln(Float.NaN Float.NaN); false
Sopln(10 != Float.NaN); true
Sopln(Float.NaN != Float.NaN); true

# Arithmetic Exception:
It is a runtime exception but not compile time error.
It is possible only in integral arithmetic but not in floating-point arithmetic.
The only operators which cause Arithmetic Exception are / and %.

# String Concatenation Operator(+):
The only over loaded operator in Java is + operator. Sometimes it acts as arithmetic addition operator and sometimes it acts as string concatenation operator.
If at least one argument is string type then + operator acts as concatenation operator and if both arguments are number type then + operator acts as arithmetic addition operator. 

e.g.
String a = "love";
int b = 10, c = 20, d = 30;
Sopln(a + b + c + d); // love102030
Sopln(b + c + d + a); // 60love
Sopln(b + c + a + d); // 30love30
Sopln(b + a + c + d); // 10love2030

a = b + c + d; ❌
a = a + b + c; ✅
b = a + c + d; ❌
b = b + c + d; ✅

# Relational Operators (<, <=, >, >=):
We can apply relational operators for every primitive type except boolean.
We can't apply relational operators for object types.
e.g. Sopln("love123" > "love"); // ❌
Listing of relational operators is not allowed otherwise we will get compile time error.
e.g. Sopln(10 < 20 < 30); // CE

# Equality Operator (==, !=):
We can apply equality operators for every primitive type including boolean type also.
We can apply equality operators for object types also. For object references r1 and r2
r1 == r2 returns true if and only if both references pointing to the same object(reference comparisons are address comparison).
Sopln(10 == 20); // false
Sopln('a' == 'b'); // false
Sopln('a' == 97.0); // true
Sopln(false == false); // true

e.g.
Thread t1 = new Thread();
Thread t2 = new Thread();
Thread t3 = t1;
Sopln(t1 == t2); // false
Sopln(t1 == t3); // true

If we apply equality operators for objects types then compulsory there should be some relation between argument types either child to parent or parent to child or same type. Otherwise we will compile time error saying incomparable types.
e.g.
Thread t = new Thread();
Object o = new Object();
String s = new String();
Sopln(t == o); // false
Sopln(o == s); // false
Sopln(s == t); // CE
 
# Difference between == and .equals() method
In general we can use == for reference comparison (address comparison) and .equals() method for content comparison.
String s1 = new String("love");
String s2 = new String("love");
Sopln(s1 == s2); // false
Sopln(s1.equals(s2)); // true

# NOTE: For any object reference r, r == null is always false but null == null is always true

# instanceof operator:
We can use instanceof operator to check whether the given object is of particular type or not.
Syntax:
r instanceof x
r = object reference
x = class / interface name
e.g.
Thread t = new Thread();
Sopln(t intanceof Thread); // true
Sopln(t intanceof Object); // true
Sopln(t intanceof Runnable); // true

To use instanceof operator compulsory there is should be some relation between argument types (either parent to child or child to parent or same type) otherwise we will get compile time error saying inconvertable types.

Sopln(t instanceof String); // CE

For any class or interface x, null instance of x is always false.
Sopln(null instanceof Thread); false
Sopln(null instanceof Runnable); false

# Bit wise operators (&, |, ^):
& => Returns true if both arguments are true.
| => Returns true if at least one argument is true.
^ => Returns true if both arguments are different.
e.g.
Sopln(true & false); // false
Sopln(true | false); // true
Sopln(true ^ false); // true

We can apply these operators for integral types also.
Sopln(4 & 5); // 4
Sopln(4 | 5); // 5
Sopln(4 ^ 5); // 1

# Bit wise complement Operator (~):
We can apply this operator only for integral type but not for boolean type. If we are trying to apply for boolean type then we will get compile time error.
Sopln(~true); // CE
Sopln(~4); // -5

# Boolean complement operator (!):
We can apply this operator only for boolean types but not for integral types.
Sopln(!4); // CE
Sopln(!false); // true

# Short-Circuit Operators (&&, ||):
These are exactly same as bit wise operators (& , |) excepts the following differences:
&, |                                              |      &&, ||
-------------------------------------------------------------------------------------------------------------------
1. both arguments checks                              second argument evaluation is optional
2. Relatively performance is low                      Relatively performance is high
3. Applicable for both boolean and integral types     Applicable only for boolean type but not for integral types

# NOTE: 
x && y => y will be evaluated if x is true. 
x || y => y will be evaluated if x is false.

# Type-cast operators:
There are two types of type-casting
1. Implicit Type-casting
2. Explicit Type-casting

1. Implicit Type-casting:
Compiler is responsible to perform implicit type-casting.
Whenever we are assigning smaller data type value to bigger data type variable, implicit type-casting will be performed.
It is also known as widening or upcasting.
There is no loss of information in this type-casting.
e.g.
int x = 'a';
Sopln(x); // 97

double d = 10;
Sopln(d); // 10.0


2. Explicit Type-casting:
Programmer is responsible to perform explicit type-casting.
Whenever we are assigning bigger data type value to smaller data type variable, explicit type-casting is required.
It is also known as narrowing or down-casting.
There may be a chance of loss of information in this type-casting.
e.g.
int x = 130;
byte b = (byte)x;
Sopln(b); // -126

Whenever we are assigning bigger data type value to smaller data type variable by explicit type-casting, the most significant bits will be lost we have to consider only least significant bits