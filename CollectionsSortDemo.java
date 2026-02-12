import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class CollectionsSortDemo{
    public static void main(String[] args){
        ArrayList l = new ArrayList();
        l.add("K");
        l.add("Y");
        l.add("E");
        l.add("S");
        Collections.sort(l);
        System.out.println(l);
    }
}

class CollectionsCustomizedSortDemo{
    public static void main(String[] args){
        ArrayList l = new ArrayList();
        l.add("K");
        l.add("Y");
        l.add("E");
        l.add("S");
        Collections.sort(l, new MyCustomizedComparator());
        System.out.println(l);
    }
}
class MyCustomizedComparator implements Comparator {
    public int compare(Object o1, Object o2){
        String s1 = (String)o1;
        String s2 = (String)o2;
        return s2.compareTo(s1);
    }
}