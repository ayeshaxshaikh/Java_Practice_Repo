
⦁	Until 1.4v, we can't declare a method with variable number of arguments. If there is a change in number of arguments compulsory we should go for new method, it increases length of the code and reduces readability
⦁	To overcome this problem some people introduced var-arg method in 1.5v. According to this we can declared a method which can take variable number of arguments such type of methods are called var-arg methods.
⦁	We can declared a var-arg method as follows: m1(int... x);
⦁	We can call this method by passing any number of int values including 0 number. e.g. m1();, m1(10);, m1(10, 20, 30);
class Main {
    public static void main(String[] args) {
        m1();   // Var-arg method
        m1(10); // Var-arg method
        m1(10, 20, 30); // Var-arg method
    }
    public static void m1(int... x) {
        System.out.println("Var-arg method");
    }
} 

Internally var-arg parameter will be converted into one-dimensional array hence within the var-arg method we can differentiate values by using index.

class Main {
    public static void main(String[] args) {
        sum();  // 0
        sum(10); // 10
        sum(10, 20, 30); // 60
    }
    public static void sum(int... x) {
        int total = 0;
        for (int n : x) {
            total += n;
        }
        System.out.println(total);
    }
}

We can mix var-arg parameter with normal parameter.
m1(int x, int... y);
m1(String s, double... d);

If we mix normal parameter with var-arg parameter then var-arg parameter should be last parameter.
m1(double... d, String s); ❌
m1(char ch, String... s); ✅

Inside var-arg method we can take only one var-arg parameter and we can't take more than one var-arg parameter.
m1(int... x, double... d);❌

Inside a class we can't declare var-arg method and the corresponding one-dimensional array simultaneously otherwise we will get compile time error.
class Main {
    public static void main(String[] args) {

    }
    public static void main(String... x) {
        
    }
} // cannot declare both main(String...) and main(String[]) in Main


class Main {
    public static void main(String[] args) {
        m1();
        m1(10, 20);
        m1(10);
    }
    public static void m1(int... x) {
        System.out.println("Var-arg Method");
    }
    public static void m1(int x) {
        System.out.println("General Method");
    }
}

In general, var-arg method will get least priority i.e. if no other method matched then only var-arg method will get the chance. It is exactly same as default case inside switch.

Equivalence between var-arg parameter and one-dimensional array:
Case 1: Wherever one-dimensional array present, we can replace with var-arg parameter.
e.g. 
m1(int[] x)  => m1(int... x) 
main(String[] args) => main(String... args)

case 2: Wherever var-arg parameter present, we can't replace with one-dimensional array.
e.g. 
m1(int... x)  => m1(int[] x) ❌

# NOTE:
m1(int... x) => int[] x
m1(String... x) => String[] x
m1(int[][]... x) => int[][] x
m1(int[][][]... x) => int[][][] x

e.g.
class Main {
    public static void main(String[] args) {
        int[] a = {10, 20, 30};
        int[] b = {40, 50, 60};
        m1(a, b);
    }
    public static void m1(int[]... x) {
       for (int[] x1: x) {
           System.out.println(x1[0]);
       } 
    }
} // 10, 40