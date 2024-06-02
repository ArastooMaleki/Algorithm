public class Main {
    public static void main(String[] args) {
        StackLinkedList stack1  = new StackLinkedList();
        stack1.push("hello");
        stack1.push("world");
        System.out.println(stack1.pop());
        System.out.println(stack1.higth());

        System.out.println("*****************************");

        StackLinkedList stack2  = new StackLinkedList();
        stack2.push("hello2");
        stack2.push("world2");
        System.out.println(stack2.pop());
        System.out.println(stack2.higth());
    }
}