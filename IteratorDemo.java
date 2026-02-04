import java.util.ArrayList;
import java.util.Iterator;

class IteratorDemo{
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for(int j=0;j<10;j++){
            list.add(j);
        }
        System.out.println(list);
        Iterator itr = list.iterator();
        while(itr.hasNext()){
            Integer i = (Integer) itr.next();
            if (i%2==0){
                System.out.println(i);
            } else {
                itr.remove();
            }
        }
        System.out.println(list);
    }
}