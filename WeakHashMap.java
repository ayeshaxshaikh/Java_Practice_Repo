import java.util.HashMap;

class WeakHashMap
{
    public static  void main(String[] args) throws Exception
    {
        HashMap m = new HashMap();
        Temp t = new Temp();
        m.put(t,"love");
        System.out.println(m);
        t = null;
        System.gc();
        Thread.sleep(4000);
        System.out.println(m);
    }
}
class Temp
{
    public String toString()
    {
        return "temp";
    }
}