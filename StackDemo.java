import java.util.Stack;

class StackDemo{
    public static void main(String[] args){
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s);
        System.out.println(s.search(10));  // 3
        System.out.println(s.peek()); // 30
    }
}