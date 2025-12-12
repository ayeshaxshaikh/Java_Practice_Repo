# Whether class contains main method or not and whether main method is declared according to the requirement or not, these things won't be checked by compiler. At run time JVM will  responsible to check these things. If JVM unable to find main method then we will get run time exception saying NoSuchErrorMethod: main

# At run time JVM always searches for the main method with the following prototype:
public => To call by JVM from anywhere
static => without existing object also JVM has to call this method
void => main() method won't return anything to JVM
main => This is the name which is configured inside JVM
String[] args => Command-line arguments

The above syntax is very strict and if we perform any change then we will get runtime exception saying NoSuchErrorMethod: main

# Even though above syntax is very strict the following changes are acceptable:
Instead of public static we can take static public i.e. the order of modifier is not important.
We can declare String[] in any acceptable form - main(String[] args) or main(String []args) or main(String args[])
Instead of args we can any valid java identifier. e.g. main(String[] love)
We can replace String[] with var-arg parameter. main(String... args)

# We can declare main() method with the following identifiers:
final
synchronized
strictfp
 
# Which of the following main() method declarations are valid:
public static void main(String args) ❌
public static void Main(String[] args) ❌
public void main(String[] args) ❌
public static int main(String[] args) ❌
final synchronized strictfp public void main(String[] args) ❌
final synchronized strictfp public static void main(String[] args) ✅
public static void main(String... args) ✅

# In which of the above cases we will get compile time error:
We won't get compile time error anywhere but except the last two cases, in remaining we will get run time exception saying NoSuchErrorMethod: main

# Case 1:
Over loading of the main() method is possible but JVM will always call String[] args main() method only, the other over loaded method we have to call explicitly like normal method call
class Test {
    public static void main(String[] args) {
        System.out.println("String[]");
    }
    public static void main(int[] args) {
        System.out.println("int[]");
    }
} // String[]

# Case 2:
Inheritance concept applicable for main() method hence while executing child class if child doesn't contain main() method then parent class main() method will be executed.
class P {
    public static void main(String[] args) {
        System.out.println("Parent main");
    }
} // Parent main
class C extends P {
} // Parent main

# Case 3:
class P {
    public static void main(String[] args) {
        System.out.println("Parent main");
    }
} // Parent main
class C extends P {
    System.out.println("Child main");
} // Child main
It seems overriding concept applicable for main() method but it is not overriding and it is method hiding.

# NOTE: For main() method, inheritance and over loading concepts are applicable but overriding concept is not applicable. Instead of overriding, method hiding is applicable.


Until 1.6v if the class does not contain the main() method then we will get run time exception saying NoSuchErrorMethod: main but 1.7v onwards instead of NoSuchErrorMethod: main we will get more elaborated error information.
class Test {

} 
// ERROR!
Error: Main method not found in class Main, please define the main method as:
   public static void main(String[] args)
or a JavaFX application class must extend javafx.application.Application

From 1.7v onwards main() method is mandatory to start the program execution hence even though class contains static block it won't be executed if the class does not contain main() method.

class Test {
    static {
        System.out.println("Static block");
    }
}
Output(1.6v): 
Static block
NoSuchErrorMethod: main

Output(1.7v):
ERROR!
Error: Main method not found in class Main, please define the main method as:
   public static void main(String[] args)

# Without writing main method is it possible to print something in the console?
Yes, by using static block but until 1.6v. from 1.7v onwards it is impossible to console something without writing main method
