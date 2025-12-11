# Identifiers:
---
1) Identifiers can be defined a-z, A-Z, 0-9, $, _
2) Name cannot starts with integers
3) Cannot use any reserved key words for identifies like if, int, etc.
4) Case sensitive i.e. int Number = 10, int number = 20, int NUMBER = 30 are different.
5) No limits for defining the length of identifier but not recommended that means it must be readable

example:
class Test {
 	static public void main (String [] args) {
 		int number = 10;
 	}
 	system.out.println(number)
}



# Reserved Words:
---
There are 53 reserved words in the Java.
1) 50 are keywords --> 48 are used keywords (if, else) --> 2 are unused (goto and const)
2) 3 are literals (true, false, null)

Keywords for Data types (8):
byte, short, int, long, float, double, boolean, char

if, else, switch, break, while, do, return, case, default, for, continue

public, private, protected, static, final, synchronized, abstract, native, strictfp, transient, volatile

keywords for exceptional handling:
try, catch, finally, throw, throws, assert

class related keywords:
class, interface, extends, implements, import, package

Object related keywords:
new, instanceof, super, this

return type keyword:
void


In java, return type is mandatory. If a method won't return anything then we have to declare that method with void return type. But C language return type is optional, and the default return type is int.

Unused Keywords:
goto: usage of goto created several problems in old languages, hence some people band this keyword in java
const: use final instead of const


Note: goto and const are unused keywords and if we are trying to use we will get compile time error


Reserved Literals:
true and false --> Boolean values
null --> default value for object reference



enum :
we can use Enum to define a group of named constants

enum Month {
 	JAN, FEB, ...., DEC
}


Conclusion:
1) all 53 reserved words contains only lowercase alphabets
2) In java, we have only new keyword and there is no delete keyword because distraction of useless object is the responsibility of garbage collector
3) new keywords in Java --> strictfp(1.2v), assert(1.4v), enum(1.5v)


