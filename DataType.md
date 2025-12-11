Data Types:
---
In Java every variable and expression has some type. Each and every data type is clearly defined. Every assignment should be checked by compiler for type compatibility. Because of above reason we can conclude java language is strongly typed programming language.

Java is not considered as pure oop language bcz several oop features are not satisfied by java (like operator over loading, multiple inheritance, etc.)
moreover we are depending on primitive data types which non-objects.

Primitive Data Types:
1) Numeric Data Type :
 	i) Integral Data Type: byte, short, int, long
 	ii)Floating-point Data Type: float, double
2) Non-numeric data type:
 	i) char
 	ii)Boolean

Except Boolean and char, remaining data types are considered as signed data types. because we can represent both positive and negative numbers.

Byte:
---
size: 1 byte (8 bits)
max value: +127
min value: -128
Range: -128 to +127

sign bit: 0 --> +ve, 1 --> -ve

The most bit x as sign bit, 0 means positive number, 1 means negative number. Positive numbers will be represented directly in a memory whereas negative numbers will be represented in too complicated form.

Byte is the best choice if we want to handle data in terms of streams either from the file or from the network.(files supported form or network supported form are byte)



Short:
---
This is the more Rarely used data type in Java.
size: 2 bytes (16 bits)
range: -2^15 to 2^15 - 1



int:
---
most commonly used data type.
size: 4 byte(32 bits)
range: -2^31 to 2^31 - 1 [-2147483648 to 2147483647]



long:
---
sometimes int is not enough to hold big values then we should go for long type
return type of length method is long but not int
long l = f.length()
size: 8 bytes (64 bits)
range: -2^63 to 2^63 - 1


Note: All the above data types (byte, short, int, long) meant for representing integral values. If we want to represent floating point values then we should go for floating point data types.


Floating point data types:
---
float and double
float:
5 to 6 decimal
single precision (less accuracy)
size: 4 bytes
range: -3.4e38 to 3.4e38

double:
14 to 15 decimal
double precision (more accuracy)
size: 8 bytes
range: -1.7e38 to 1.7e38



Boolean:
---
Size: not applicable [virtual Machine dependent]
range: not applicable [only true or false]



char:
---
old languages (like c or c++ are Ascii code based and number of different Ascii codes are <= 256. To represent these 256 characters 8 bits are enough hence the size of char in old languages is 1 byte)
But Java is Unicode based and the number of different Unicode characters are > 256 and <= 65536
to represents these many characters 8 bits are not enough so we should go for 16 bits hence the size of char in Java is 2 bytes.
size: 2 bytes
range: 0 to 65535


Summary of Java Primitive Data types
---
data type   |    size    |     range         |   wrapper class   |  default value
---
byte           1 byte      -128 to +127          Byte               0

short          2 bytes     -2^15 to 2^15 - 1     Short              0
 
int            4 bytes     -2^31 to 2^31 - 1     Integer            0

long           8 bytes     -2^63 to 2^63 - 1     Long               0

float          4 bytes     -3.4e38 to 3.4e38     Float              0.0

double         8 bytes     -1.7e38 to 1.7e38     Double             0.0

Boolean        NA           NA                   Boolean            false
 
char           2 bytes     0 to 65535            Character          0 [represents space]


** Null is default value for object reference and we cannot apply for primitives. If we are trying to use for primitive then we will compile time error.**