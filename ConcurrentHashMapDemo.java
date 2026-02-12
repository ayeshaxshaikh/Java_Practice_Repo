import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap m =  new ConcurrentHashMap();
        m.put(1, "A");
        m.put(2, "B");
        m.put(3, "C");
        m.putIfAbsent(4, "D");
        m.putIfAbsent(2, "E");
        m.replace(3, "C", "Z");
        System.out.println(m);
    }
}

class ConcurrentHashMapDemo2 extends Thread {
    static ConcurrentHashMap m = new ConcurrentHashMap();
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
        System.out.println("Child Thread Updating Map");
        m.put(3, "C");
    }
    public static void main(String[] args) throws InterruptedException {
        m.put(1, "A");
        m.put(2, "B");
        ConcurrentHashMapDemo2 c = new ConcurrentHashMapDemo2();
        c.start();
        Set s = m.keySet();
        Iterator i = s.iterator();
        while (i.hasNext()) {
            Integer key = (Integer) i.next();
            System.out.println("Main thread iterating and current entry is: " + i + " " + m.get(i));
            Thread.sleep(2000);
        }
        System.out.println(m);
    }
}