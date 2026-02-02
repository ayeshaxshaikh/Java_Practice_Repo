//class Student {
//    String name;
//    int rollno;
//    Student(String name, int rollno) {
//        this.name = name;
//        this.rollno = rollno;
//    }
//    public String toString() {
//        return name + " " + rollno;
//    }
//    public static void main(String[] args) {
//        Student s1 = new Student("Sam", 1);
//        Student s2 = new Student("John", 2);
//        System.out.println(s1);
//        System.out.println(s1.toString());
//        System.out.println(s2);
//    }
//}


//import java.util.ArrayList;
//
//class StringDemo {
//    public String toString()
//    {
//        return "StringDemo";
//    }
//    public static void main(String[] args) {
//        String s = new String("Ayesha");
//        System.out.println(s);
//        ArrayList list = new ArrayList();
//        list.add("A");
//        list.add("B");
//        System.out.println(list);
//        StringDemo s1 = new StringDemo();
//        System.out.println(s1);
//    }
//}



//
//class Student {
//    String name;
//    int rollno;
//    Student(String name, int rollno) {
//        this.name = name;
//        this.rollno = rollno;
//    }
//    public static void main(String[] args) {
//        Student s1 = new Student("Sam", 1);
//        Student s2 = new Student("Smith", 2);
//        Student s3 = new Student("Steve", 3);
//        Student s4 = s1;
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.equals(s3));
//        System.out.println(s1.equals(s4));
//    }
//}




//class Student {
//    String name;
//    int rollno;
//    Student(String name, int rollno) {
//        this.name = name;
//        this.rollno = rollno;
//    }
//    public boolean equals(Object obj) {
//        try {
//            String name1 = this.name;
//            int rollno1 = this.rollno;
//            Student s = (Student)obj;  // ClassCastException
//            String name2 = s.name;
//            int rollno2 = s.rollno;
//            if (name1.equals(name2) && rollno1 == rollno2) {
//                return true;
//            } else  {
//                return false;
//            }
//        } catch (ClassCastException e) {
//            return false;
//        } catch (NullPointerException e) {
//            return false;
//        }
//    }
//    public static void main(String[] args) {
//        Student s1 = new Student("Sam", 1);
//        Student s2 = new Student("Sam", 1);
//        Student s3 = new Student("Steve", 3);
//        Student s4 = s1;
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.equals(s3));
//        System.out.println(s1.equals(s4));
//    }
//}



//
//class Student {
//    String name;
//    int rollno;
//    Student(String name, int rollno) {
//        this.name = name;
//        this.rollno = rollno;
//    }
//    public boolean equals(Object obj) {
//        try {
//            Student s = (Student)obj;  // ClassCastException
//            if (name.equals(s.name) && rollno == s.rollno) {
//                return true;
//            } else  {
//                return false;
//            }
//        } catch (ClassCastException e) {
//            return false;
//        } catch (NullPointerException e) {
//            return false;
//        }
//    }
//    public static void main(String[] args) {
//        Student s1 = new Student("Sam", 1);
//        Student s2 = new Student("Sam", 1);
//        Student s3 = new Student("Steve", 3);
//        Student s4 = s1;
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.equals(s3));
//        System.out.println(s1.equals(s4));
//    }
//}




//class Student {
//    String name;
//    int rollno;
//    Student(String name, int rollno) {
//        this.name = name;
//        this.rollno = rollno;
//    }
//    public boolean equals(Object obj) {
//        if (obj == this) return true;
//        if (obj instanceof Student) {
//            Student s = (Student)obj;  // ClassCastException
//            if (name.equals(s.name) && rollno == s.rollno) {
//                return true;
//            } else  {
//                return false;
//            }
//        }
//        return false;
//    }
//    public static void main(String[] args) {
//        Student s1 = new Student("Sam", 1);
//        Student s2 = new Student("Sam", 1);
//        Student s3 = new Student("Steve", 3);
//        Student s4 = s1;
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.equals(s3));
//        System.out.println(s1.equals(s4));
//    }
//}



//class Test {
//    public static void main(String[] args) {
//        String s1 = new String("Hello");
//        String s2 = new String("Hello");
//        StringBuffer sb1 = new StringBuffer("Hello");
//        StringBuffer sb2 = new StringBuffer("Hello");
//        System.out.println(s1 == s2);
//        System.out.println(s1.equals(s2));
//        System.out.println(sb1 == sb2);
//        System.out.println(sb1.equals(sb2));
//    }
//}


//import java.lang.reflect.Method;
//
//class Test {
//    public static void main(String[] args) {
//        int count = 0;
//        Object o = new String("Hello");
//        Class c = o.getClass();
//        System.out.println(c.getName());
//        Method[] m = c.getDeclaredMethods();
//        for (Method m1 : m) {
//            count++;
//            System.out.println(m1.getName());
//        }
//        System.out.println(count);
//    }
//}


//class Test {
//    public static void main(String[] args) {
//        String s1 =  new String("hello");
//        String s2 = s1.toUpperCase();
//        String s3 = s1.toLowerCase();
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//    }
//}





















