// class Outer {
//     class Inner {
//         public static void main(String[] args) {
//             System.out.println("Inner main method");
//         }
//     }
// }


// class Outer {
//     class Inner {
//         public void m1()
//         {
//             System.out.println("Inner class method");
//         }
//     }
//     public static void main(String[] args) {
//         // Outer o = new Outer();
//         // Outer.Inner i = o. new Inner();
//         // i.m1();

//         Outer.Inner i = new Outer(). new Inner();
//         i.m1();
//     }
// }





// class Outer {
//     class Inner {
//         public void m1()
//         {
//             System.out.println("Inner class method");
//         }
//     }
//     public void m2()
//     {
//         Inner i = new Inner();
//         i.m1();
//     }
//     public static void main(String[] args) {
//         Outer o = new Outer();
//         o.m2();
//     }
// }




// class Outer {
//     class Inner {
//         public void m1()
//         {
//             System.out.println("Inner class method");
//         }
//     }
// }
// class Demo {
//     public static void main(String[] args) {
//         Outer o = new Outer();
//         Outer.Inner i = o. new Inner();
//         i.m1();
//     }
// }





// class Outer {
//     int x = 10;
//     static int y = 20;
//     class Inner {
//         public void m1()
//         {
//             System.out.println(x);
//             System.out.println(y);
//         }
//     }
//     public static void main(String[] args) {
//         new Outer().new Inner().m1();
//     }
// }






// class Outer {
//     int x = 10;
//     class Inner {
//         int x = 100;
//         public void m1()
//         {
//             int x = 1000;
//             System.out.println(x);  // 1000
//             System.out.println(this.x); // 100
//             System.out.println(Outer.this.x); // 10
//         }
//     }
//     public static void main(String[] args) {
//         new Outer().new Inner().m1();
//     }
// }



// class A {
//     class B {
//         class C {
//             public void m1()
//             {
//                 System.out.println("Inner class method");
//             }
//         }
//     }
// }
// class Test 
// {
//     public static void main(String[] args) {
//         A a = new A();
//         A.B b = a. new B();
//         A.B.C c = b. new C();
//         c.m1();
//     }
// }





// class Test 
// {
//     public void m1()
//     {
//         class Inner 
//         {
//             public void sum(int x, int y)
//             {
//                 System.out.println(x+y);
//             }
//         }
//         Inner i = new Inner();
//         i.sum(10, 20);
//         i.sum(100, 200);
//         i.sum(1000, 2000);
//     }
//     public static void main(String[] args) {
//         Test t = new Test();
//         t.m1();
//     }
// }




class Demo {
    int x = 10;
    
}