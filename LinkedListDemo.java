import java.util.LinkedList;

class LinkedListDemo
{
    public  static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add("love");
        list.add(null);
        list.add("happy");
        list.set(0, 3);
        list.add(0, 9);
        list.removeLast();
        list.addFirst("KJNKN");
        System.out.println(list);
    }
}