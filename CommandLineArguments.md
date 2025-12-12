# The arguments which are paasing from command prompt are called command line arguments. With these command line arguments JVM will create an array and by passing an array as arguments JVM will call main() method.

The main objective of command line argument is we can constumize the behaviour of main() method.
# e.g.
class Test {
    public static void main(String[] args) {
        for (int i = 0; i <= args.length; i++) {
           System.out.println(args[i]);
        }
    }
}
case 1: java Test A B C 
A
B
C
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3

case 2: java Test A B
A
B
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2

case 3: java Test
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0

# e.g.
class Test {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
           System.out.println(args[i]);
        }
    }
} 

case 1: java Test A B C 
A
B
C

case 2: java Test A B
A
B

case 3: java Test

# e.g.
class Test {
    public static void main(String[] args) {
        String[] s = {"X", "Y", "Z"};
        args = s;
        for (String s1: args) {
            System.out.println(s1);
        }
    }
}
case 1: java Test A B C 
X
Y
Z

case 2: java Test A B
X
Y
Z

case 3: java Test
X
Y
Z


# Within main() method command line arguments are available in string form.
class Test {
    public static void main(String[] args) {
        System.out.println(args[0] + args[1]);
    }
}
java Test 10 20  // 1020

Usually sapce itself is the separator between command line arguments. If our command line argument contains space then we have to enclose that command line argument within double quotes.

class Test {
    public static void main(String[] args) {
        System.out.println(args[0]);
    }
}
java Test "Note Book" // Note Book