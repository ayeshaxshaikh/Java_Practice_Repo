import java.util.Hashtable;

class HashtableDemo{
    public static void main(String[] args){
        Hashtable h = new Hashtable();
        h.put(new TempDemo(5), "A");
        h.put(new TempDemo(2), "B");
        h.put(new TempDemo(6), "C");
        h.put(new TempDemo(15), "D");
        h.put(new TempDemo(23), "E");
        System.out.println(h);
    }
}
class TempDemo {
    int i;
    TempDemo(int i){
        this.i = i;
    }
    public String toString(){
        return i + "";
    }
    public int hashCode(){
        return i;
    }
}