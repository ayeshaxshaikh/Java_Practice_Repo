import java.util.Comparator;
import java.util.TreeSet;

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



class ComparatorDemo {
    public static void main(String[] args) {
        TreeSet t = new TreeSet(new MyComparator());
        t.add(10);
        t.add(20);
        t.add(30);
        t.add(0);
        t.add(5);
        System.out.println(t);
    }
}
class MyComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        Integer i1 = (Integer)o1;
        Integer i2 = (Integer)o2;
        return i1.compareTo(i2);  // Default natural sorting order [0, 5, 10, 20, 30]
//        return -i1.compareTo(i2); // Descending order [30, 20, 10,5, 0]
//        return i2.compareTo(i1);  // Descending order [30, 20, 10, 5, 0]
//        return -i2.compareTo(i1); // Ascending order [0, 5, 10, 20, 30]
//        return +1; // Insertion order [10, 20, 30, 0, 5]
//        return -1; // Reverse insertion order [5, 0, 30, 20, 10]
//        return 0;  // only first element will be inserted and remaining are considered as duplicates [10]
    }
}