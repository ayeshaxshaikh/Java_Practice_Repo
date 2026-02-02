final public class StringImmutableDemo {
    private int i;
    StringImmutableDemo(int i){
        this.i = i;
    }
    public StringImmutableDemo modify(int i){
        if (this.i == i){
            return this;
        } else {
            return (new StringImmutableDemo(i));
        }
    }
}

class Test {
    public static void main(String[] args) {
        StringImmutableDemo demo1 = new StringImmutableDemo(1);
        StringImmutableDemo demo2 = demo1.modify(2);
        StringImmutableDemo demo3 = demo1.modify(1);
        System.out.println(demo1 == demo2);
        System.out.println(demo1 == demo3);
    }
}