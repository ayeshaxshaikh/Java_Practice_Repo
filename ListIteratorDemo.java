import java.util.LinkedList;
import java.util.ListIterator;

class ListIteratorDemo{
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.add("Sania");
        list.add("Sam");
        list.add("Smith");
        list.add("John");
        list.add("Mike");
        System.out.println(list);
        ListIterator itr = list.listIterator();
        while(itr.hasNext()){
            String s = (String)itr.next();
            if (s.equals("Smith")){
                itr.remove();
            } else if (s.equals("John")){
                itr.add("Chiru");
            } else if (s.equals("Mike")){
                itr.set("charan");
            }
        }
        System.out.println(list);
    }
}