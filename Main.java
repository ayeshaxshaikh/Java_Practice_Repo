// import java.util.ArrayList;

// class Demo {
//     public static void main(String args[]) {
//         int num = 89;
//         float f = 8.9f;
//         double d = 7.4;
//         char c = 'A';
//         long l = 34567;
//         System.out.println(num + " " + f + " " + d + " " + c + " " + l);
//         show();
//     }

//     public static void show() {
//         System.out.println("Hey there");
//     }
// }



// class Keyboard {
//     int keys;
//     String colors;
//     static String brand;

//     public static void pressed(){
//         System.out.println("Key Pressed");
//     }

//     public static void throwIt(){
//         System.out.println("Throw this away");
//     }
// }

// class AdvKeyboard extends Keyboard {
//     public static void hitBoard() {
//         System.out.println("Borad hitted");
//     }
// }

// class Demo {
//     public static void main(String[] args) {
//         // Keyboard obj = new Keyboard();
//         AdvKeyboard obj;
//         obj = new AdvKeyboard();
//         obj.pressed();
//         obj.throwIt();
//         obj.hitBoard();

//         System.out.println(obj.keys);
//         System.out.println(obj.colors);
//         System.out.println(Keyboard.brand);
//     }
// }

// class Students extends Object {
//     int rollNo;
//     String name;

//     // constructor — no return type
//     Students(int rollNo, String name) {
//         this.rollNo = rollNo;
//         this.name = name;
//     }
// }


// public class Main {
//     public static void main(String[] args) {
//         String s = "AYESHA";
//         // System.out.println(s);

//         StringBuffer str = new StringBuffer("Ayesha ");
//         str.append("Junaid");
//         // System.out.println(str);

//         int nums[] = new int[8];
//         nums[0] = 8;
//         nums[1] = 9;


//         int values[] = {3, 4, 5};

//         // for (int i = 0; i < values.length; i++) {
//         //     System.out.println(values[i]);
//         // }

//         // for (int num : values) {
//         //     System.out.println(num);
//         // }


//         Students students[] = new Students[3];
//         students[0] = new Students(1, "Kevin");
//         students[1] = new Students(2, "Vincent");
//         students[2] = new Students(3, "Aditya");

//         for (var student : students) {
//             System.out.println(student);
//         }
//     }
// }


// class Test {
//     public static void main(String[] args) {
//         String[] s = {"X", "Y", "Z"};
//         args = s;
//         for (String s1: args) {
//             System.out.println(s1);
//         }
//     }
// }


// class A {
//     public static void main(String[] args) {
//         System.out.println("A class main");
//     }
// }

// class Test {
//     public static void main(String[] args) {
//         ArrayList l = new ArrayList();
//     }
// }

// class P
// {
//     P()
//     {
//         System.out.println(this.hashCode());
//     }
// }

// class C extends P
// {
//     C()
//     {
//         System.out.println(this.hashCode());
//     }
// }

// class Test 
// {
//     public static void main(String[] args)
//     {
//         C c = new C();
//         System.out.println(c.hashCode());
//     }
// }

// class P
// {
//     public void m1()
//     {
//         System.out.println("Parent");
//     }
// }

// class C extends P
// {
//     public void m2()
//     {
//         System.out.println("Child");
//     }   
// }

// class Test 
// {
//     public static void main(String[] args) {
//         P p = new P();
//         p.m1();
//         // p.m2();

//         C c = new C();
//         c.m1();
//         c.m2();

//         P p1 = new C();
//         p1.m1();
//         // p1.m2();

//         // C c1 = new P();
//     } 
// }

// class Test
// {
//     public void m1()
//     {
//         System.out.println("no-arg");
//     }

//     public void m1(int i)
//     {
//         System.out.println("int-arg");
//     }

//     public void m1(double d)
//     {
//         System.out.println("double-arg");
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Test t = new Test();
//         t.m1();
//         t.m1(10);
//         t.m1(10.5);
//     }
// }

// class Test
// {
//     static int count = 0;

//     {
//         count++;
//     }

//     Test()
//     {

//     }

//     Test(int i)
//     {

//     }

//     Test(double d)
//     {

//     }

//     public static void main(String[] args)
//     {
//         Test t1 = new Test();
//         Test t2 = new Test(10);
//         Test t3 = new Test(10.5);
//         System.out.println("The no. of objects creaated: ", count);
//     }
// }


// class Test
// {
//     public static void main(String[] args) 
//     {
//         doStuff();
//     }
//     public static void doStuff() 
//     {
//         doMoreStuff();
//     }
//     public static void doMoreStuff() 
//     {
//         System.out.println(10/0);
//     }
// }

class Test
{
    public static void main(String[] args) 
    {
        doStuff();
        System.out.println(10/0);
    }
    public static void doStuff() 
    {
        doMoreStuff();
        System.out.println("Hi");
    }
    public static void doMoreStuff() 
    {
        System.out.println("Hello");
    }
}    