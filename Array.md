

Array:
------
⦁	An Array is a indexed collection of fixed number of homogeneous data elements.
⦁	The main advantage of Array is, we can represent huge number of values by using single variable so that readability of the code will be improved.
⦁	But the main disadvantage of array is fixed in size, i.e. once we create an array there in no chance of increasing or decreasing the size based on the requirements hence to use arrays concept we should know the size in advance which may not possible always.

Array declaration:
One-Dimensional Array Declaration-
int[] x;
int[][] x;
int[] a,b;


Array Creation:
Every array in Java is object only hence we can create arrays by using new operator.
int[] x = new int[3];
For every array, corresponding classes are available and these classes are part of java language and not available to programmer level.
sopln(x.getClass().getName()); // [I

int[] --> [I
int[][] --> [[I
double[] -->[D
short[] --> [S
byte[] --> [B
boolean[] --> [Z

Maximum allowed data type is int.
int[] x = new int[2147483647];✅
int[] x = new int[2147483648];❌


Two-Dimensional Array Creation:
⦁	In Java, 2-dimensional array not implemented in matrix style, some people followed array of array's approach for multi-dimensional array creation.
⦁	The main advantage of this approach is memory utilization will be improved.

e.g.
int[][] x = new int[2][];
x[0] = new int[3];
x[1] = new int[2];
Base size need to specify.


Array Initialization:
Once we create an array, every element by default initialized with default values.
int[] x = new int[3];
Sopln(x); // [I3e25a5
Sopln(x[0]); // 0

Whenever we trying to print any reference variable, internally two string method will be called which is  implemented by default to return the string in the following form:
classname@hashcode-in-hexadecimalform


Array Declaration-Creation-Initialization in a single line:
int[] x = {1, 2, 3};
char[] ch = {'a', 'e', 'i', 'o', 'u'};
String[] s = {"john", "peter"};
int[][] x = {{1, 2}, {3, 4}};

⦁	length is the final variable applicable for arrays.
⦁	length variable represents the size of the array.

int[] x = new int[6];
System.out.println(x.length); // 6


String x = "john";
System.out.println(x.length()); // 4

⦁	length variable applicable for arrays but not for string objects. Whereas length method applicable for string objects but not for arrays.

Anonymous arrays:
An array without name is called anonymous array.
The main purpose just for instant use.

e.g. new int[]{10, 20, 30};
While creating anonymous array, we cannot specify the size of the array, it will give compile time error.


Array Element Assignments:
⦁	In the case of primitive type arrays, as array elements we can provide any type which can be implicitly promoted to declared type.
int[] x = new int[5];
x[0] = 10;
x[1] = 'a';
byte b = 20;
x[2] = b;
short s = 30;
x[3] = s;
x[4] = 10L;❌

In the case of float-type arrays, the allowed data types are byte, short, int, long, float.

⦁	In the case of object type arrays, as array elements we can provide either declared type objects or its child class object.
e.g. 1:
Object[] a = new Object[10];
a[0] = new Object();
a[1] = new String("Love");
a[2] = new Integer(10);

e.g. 2:
Number[] n = new Number[10];
n[0] = new Integer(10);
n[1] = new Double(10.5);
n[2] = new String("Love");❌

⦁	For Interface type  arrays, as array elements its implementation class objects are allowed.
Runnable[] r = new Runnable[10];
r[0] = new Thread();
r[1] = new String("Love");❌


Array Type           |  Allowed element type
---
Primitive array      | Any type which can be implicitly promoted to declared type

Object Type array    | Either declared type or its child class object

Abstract Class Type  | Its child class objects

Interface Type       | Its implementation class objects


Whenever we are assigning one array to another array, internal elements won't be copied, just reference variable will be re-assigned. And the size need not require to match but the type and dimension must match.

int[] a = {10, 20, 30, 40, 50};
int[] b = {60, 70};

a = b;✅
b = a;✅
