Uninitialized Arrays:
1.
class Main {
    int[] x;
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.x); // null
        System.out.println(m.x[0]); // Error
    }
}

2.
class Main {
    int[] x = new int[3];
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.x); //[I@659e0bfd
        System.out.println(m.x[0]); // 0
    }
}

3.
class Main {
    static int[] x;
    public static void main(String[] args) {
        System.out.println(x); // null
        System.out.println(x[0]); // Error
    }
}

4.
class Main {
    static int[] x = new int[3];
    public static void main(String[] args) {
        System.out.println(x); //[I@659e0bfd
        System.out.println(x[0]); // 0
    }
}

5.
class Main {
    public static void main(String[] args) {
        int[] x;
        System.out.println(x);  // Error
        System.out.println(x[0]); // Error
    }
}

6.
class Main {
    public static void main(String[] args) {
        int[] x = new int[3];
        System.out.println(x);  // [I@659e0bfd
        System.out.println(x[0]); // 0
    }
}

NOTE: Once we creates an array every array element by default initialized with default values irrespective of whether it is instance or static or local array.