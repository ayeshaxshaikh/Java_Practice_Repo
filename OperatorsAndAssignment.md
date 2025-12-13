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