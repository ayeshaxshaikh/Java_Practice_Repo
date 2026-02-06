//class TreeSetDemo {
//    public static void main(String[] args) {
//        TreeSet ts = new TreeSet();
//        ts.add("A");
//        ts.add("B");
//        ts.add("a");
//        ts.add("Z");
//        ts.add("C");
////        ts.add(new Integer(10));
////        ts.add(null);
//        System.out.println(ts);
//    }
//}


//class TreeSetDemo {
//    public static void main(String[] args) {
//        TreeSet t = new TreeSet();
//        t.add(new StringBuffer("A"));
//        t.add(new StringBuffer("B"));
//        t.add(new StringBuffer("C"));
//        System.out.println(t);
//    }
//}


//class CompareToDemo {
//    public static void main(String[] args) {
//        System.out.println("A".compareTo("D"));
//        System.out.println("K".compareTo("A"));
//        System.out.println("A".compareTo("A"));
//    }
//}



//class ComparatorDemo {
//    public static void main(String[] args) {
//        TreeSet t = new TreeSet(new MyComparator());
//        t.add(10);
//        t.add(20);
//        t.add(30);
//        t.add(0);
//        t.add(5);
//        System.out.println(t);
//    }
//}
//class MyComparator implements Comparator {
//    public int compare(Object o1, Object o2) {
//        Integer i1 = (Integer)o1;
//        Integer i2 = (Integer)o2;
//        if (i1 < i2) {
//            return 1;
//        } else if (i1 > i2) {
//            return -1;
//        } else  {
//            return 0;
//        }
//    }
//}



//class ComparatorDemo {
//    public static void main(String[] args) {
//        TreeSet t = new TreeSet(new MyComparator());
//        t.add(10);
//        t.add(20);
//        t.add(30);
//        t.add(0);
//        t.add(5);
//        System.out.println(t);
//    }
//}
//class MyComparator implements Comparator {
//    public int compare(Object o1, Object o2) {
//        Integer i1 = (Integer)o1;
//        Integer i2 = (Integer)o2;
//        return i1.compareTo(i2);  // Default natural sorting order [0, 5, 10, 20, 30]

import java.util.Comparator;
import java.util.TreeSet;

////        return -i1.compareTo(i2); // Descending order [30, 20, 10,5, 0]
////        return i2.compareTo(i1);  // Descending order [30, 20, 10, 5, 0]
////        return -i2.compareTo(i1); // Ascending order [0, 5, 10, 20, 30]
////        return +1; // Insertion order [10, 20, 30, 0, 5]
////        return -1; // Reverse insertion order [5, 0, 30, 20, 10]
////        return 0;  // only first element will be inserted and remaining are considered as duplicates [10]
//    }
//}


//class ComparatorDemo {
//    public static void main(String[] args) {
//        TreeSet t = new  TreeSet(new MyComparator());
//        t.add(new StringBuffer("Rama"));
//        t.add(new StringBuffer("Ramsha"));
//        t.add(new StringBuffer("Ayesha"));
//        t.add(new StringBuffer("Junaid"));
//        System.out.println(t);
//    }
//}
//class MyComparator implements Comparator{
//    public int compare(Object o1, Object o2) {
//        String s1 = o1.toString();
//        String s2 = o2.toString();
//        return s2.compareTo(s1);
//    }
//}



//class ComparatorDemo {
//    public static void main(String[] args) {
//        TreeSet t = new  TreeSet(new MyComparator());
//        t.add(new StringBuffer("A"));
//        t.add(new StringBuffer("Z"));
//        t.add(new StringBuffer("L"));
//        t.add(new StringBuffer("P"));
//        System.out.println(t);
//    }
//}
//class MyComparator implements Comparator{
//    public int compare(Object o1, Object o2) {
//        String s1 = o1.toString();
//        String s2 = o2.toString();
//        return s2.compareTo(s1);
//    }
//}






//class ComparatorDemo {
//    public static void main(String[] args) {
//        TreeSet ts = new TreeSet(new MyComparator());
//        ts.add("A");
//        ts.add(new StringBuffer("ABC"));
//        ts.add(new StringBuffer("AA"));
//        ts.add("XX");
//        ts.add("ABCD");
//        ts.add("A");
//        System.out.println(ts);
//    }
//}
//class MyComparator implements Comparator {
//    public int compare(Object o1, Object o2) {
//        String s1 = o1.toString();
//        String s2 = o2.toString();
//        int l1 = s1.length();
//        int l2 = s2.length();
//        if (l1 < l2)  {
//            return -1;
//        } else if (l1 > l2) {
//            return 1;
//        } else {
//            return s1.compareTo(s2);
//        }
//    }
//}




//class Employee implements Comparable {
//    String name;
//    int eId;
//    Employee(String name, int eId) {
//        this.name = name;
//        this.eId = eId;
//    }
//    public String toString() {
//        return name + "__" + eId;
//    }
//    public int compareTo(Object o) {
//        int eId1 = this.eId;
//        Employee e = (Employee) o;
//        int eId2 = e.eId;
//        if (eId1 < eId2) {
//            return -1;
//        }  else if (eId1 > eId2) {
//            return 1;
//        } else  {
//            return 0;
//        }
//    }
//}
//class ComparableEmployee {
//    public static void  main(String[] args) {
//        TreeSet ts = new TreeSet();
//        Employee e1 = new Employee("Jack", 102);
//        Employee e2 = new Employee("Jill", 50);
//        Employee e3 = new Employee("John", 110);
//        Employee e4 = new Employee("Jane", 30);
//        ts.add(e1);
//        ts.add(e2);
//        ts.add(e3);
//        ts.add(e4);
//        System.out.println(ts);
//    }
//}



class Employee {
    String name;
    int eId;
    Employee(String name, int eId) {
        this.name = name;
        this.eId = eId;
    }
    public String toString() {
        return name + "__" + eId;
    }
}
class ComparatorEmployee {
    public static void  main(String[] args) {
        TreeSet ts = new TreeSet(new MyComparator());
        Employee e1 = new Employee("Jack", 102);
        Employee e2 = new Employee("Ayesha", 50);
        Employee e3 = new Employee("Junaid", 110);
        Employee e4 = new Employee("Reema", 30);
        ts.add(e1);
        ts.add(e2);
        ts.add(e3);
        ts.add(e4);
        System.out.println(ts);
    }
}
class MyComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        Employee e1 = (Employee) o1;
        Employee e2 = (Employee) o2;
        String name1 = e1.name;
        String name2 = e2.name;
        return name1.compareTo(name2);
    }
}

