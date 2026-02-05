import java.util.HashSet;
import java.util.LinkedHashSet;

class HashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet h = new LinkedHashSet();
        h.add("A");
        h.add("Z");
        h.add("C");
        h.add(null);
        h.add(20);
        System.out.println(h.add("D"));
        System.out.println(h);
    }
}