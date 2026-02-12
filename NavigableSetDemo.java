import java.util.TreeSet;

class NavigableSetDemo{
    public static void main(String[] args){
        TreeSet<Integer> ts = new TreeSet<Integer>();
        ts.add(100);
        ts.add(200);
        ts.add(300);
        ts.add(400);
        ts.add(500);
        System.out.println(ts);
        System.out.println(ts.first());
        System.out.println(ts.last());
        System.out.println(ts.pollFirst());
        System.out.println(ts.pollLast());
        System.out.println(ts.ceiling(200));
        System.out.println(ts.floor(200));
        System.out.println(ts);
    }
}