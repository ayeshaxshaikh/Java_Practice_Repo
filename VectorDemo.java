import java.util.Vector;

class VectorDemo{
    public static void main(String[] args){
        Vector v = new Vector();
        System.out.println(v.capacity());
        for(int j=0;j<10;j++){
            v.addElement(j);
        }
        System.out.println(v.capacity());
        v.addElement("A");
        System.out.println(v.capacity());
        System.out.println(v);
    }
}