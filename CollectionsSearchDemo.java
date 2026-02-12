import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class CollectionsSearchDemo {
    public static void main(String[] args) {
        ArrayList l = new ArrayList();
        l.add("Z");
        l.add("B");
        l.add("a");
        l.add("K");
        System.out.println(l);
        Collections.sort(l);
        System.out.println(l);
        System.out.println(Collections.binarySearch(l, "Z"));
        System.out.println(Collections.binarySearch(l, "J"));
    }
}

class CollectionsSearchDemo2 {
    public static void main(String[] args) {
        ArrayList l = new ArrayList();
        l.add("Z");
        l.add("B");
        l.add("a");
        l.add("K");
        System.out.println(l);
        Collections.sort(l, new CollectionsSearchComparator());
        System.out.println(Collections.binarySearch(l, "Z", new CollectionsSearchComparator()));
        System.out.println(Collections.binarySearch(l, "J", new CollectionsSearchComparator()));
    }
}
class CollectionsSearchComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        String s1 = (String) o1;
        String s2 = (String)o2;
        return s2.compareTo(s1);
    }
}
