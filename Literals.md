Literals
---
int x = 10; (10 is called constant value / literal)
Any constant value which can be assigned to a variable is called a literal.


# Integral Literals: For integral data types (byte, short, int, long) we can specify literal value in the following base:
1.	Decimal form (base - 10): Allowed digit are 0 to 9
e.g. int x = 10;

2. Octal form (base - 8): Allowed digit are 0 to 7
literal value should be prefixed with 0
e.g. int x = 010;

3. Hexa decimal for (base - 16): Allowed digit are 0 to 9 and a to f (we can use both lower case and upper case characters.) This is one of areas where Java is not case sensitive.
The literal value should be prefixed with 0x or 0X.
int x = 0X10;

These are only possible ways to specify for integral data types.

e.g
int x = 10;    ✅
int x = 0786;  ❌
int x = 0777;  ✅
int x = 0XFace;✅
int x = 0XBeef;✅
int x = 0xBeer;❌

class Main {
    public static void main(String[] args) {
        int x = 10;
        int y = 010;
        int z = 0X010;
        System.out.println(x + " " + y + " " + z); // 10 8 16
        System.out.println(x + y + z); // 34
    }
}

** By default every integral is of int type, but we can specify explicitly by long type by suffixed with l/L.
long x = 10L; ✅
int x = 10L; ❌
long x = 10; ✅

** There is no direct way to specify byte and short literals explicitly, but indirectly we can specify. Whenever we are assigning integral literal to the byte variable and if the value within the range of byte then compiler treats it as byte literal, similarly short literal also **

byte b = 10;  ✅
byte b = 127; ✅
byte b = 128; ❌

short s = 32767; ✅
short s = 32768; ❌


Floating-point literals:
---
By default every floating-point literal is of double type and hence we cannot assign directly to the float variable but we can specify explicitly as floating point literals as float type by suffixed with f/F.
We can specify floating point literal as double type by suffixed with d/D. Of course this convention is not required.

float f = 123.456; ❌
float f = 123.456F;✅
double d = 123.456; ✅
double d = 123.5467D; ✅
float d = 123.5467D; ❌

We can specify floating-point literals only in decimal and can't specify in octal and hexa decimal forms.

double d = 0123.546; ✅
double d = 0X123.546;❌

We can assign integral literal directly to floating-point variable and that integral literal can be specified either in decimal or octal or hexadecimal forms.

double d = 0786; ❌
double d = 0XFace;✅
double d = 0786.0;✅
double d = 0XFace.0;❌
double d = 10;✅
double d = 0777;✅

We cannot assign floating-point literals to integral types.

double d = 10;✅
int x = 10.0;❌

We can specify floating-point literal even in exponential form (scientific notation)

double d = 1.2e3;✅
float f = 1.2e3;❌
float f = 1.2e3F;✅



Boolean Literals:
---
Only allowed values for Boolean data type are true or false.

boolean b = true;✅
boolean b = 0;❌
boolean b = True;❌
boolean b = "true";❌



Char Literal:
---
We can specify char literals as single character within single quotes ('')

char ch = 'a';✅
char ch = a; ❌
char ch = "a";❌
char ch = 'ab';❌

We can specify char literals as integral literals which represents Unicode value of the character and that integral literal can be specified either in integral, octal or hexadecimal forms but allowed range is 0 to 65535.

char ch = 97; ✅ // a
char ch = 0XFace; ✅
char ch = 0777; ✅
char ch = 65535; ✅
char ch = 65536; ✅



String Literal:
---------------
Any sequence of character within double quotes treated as string literal.

String s = "mobile";


Binary Literal:
---
For integral data types until 1.6v we can specify literal value in the following base - decimal, octal, hexadecimal forms. But from 1.7v we can specify integral values in binary form also.
Allowed values are 0 and 1.
e.g int x = 0B111;

Usage of '_' symbol in numeric literals from 1.7v we can use '_' between digits of numeric literals.
double d = 123_456.7_8_9;
The main advantage of this approach is readability will be improved.

byte--->short--->int--->long--->float--->double
 		  ^
 		  |
                 char


