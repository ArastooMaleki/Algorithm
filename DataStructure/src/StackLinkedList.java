class StackLinkedList {
    public static void main(String[] args) {

    }
    private Node first =null;
    private class Node{
        String item ;
        Node next =null;
    }
    public void push(String item){
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = this.first;
        this.first = newNode;
    }
    public String pop(){
        String item = this.first.item;
        this.first = this.first.next;
        return item;
    }
    public boolean isEmpty(){
        return this.first == null ;
    }
    public int higth(){
        int counter = 0 ;
        Node node = this.first;
        while (node !=null){
            counter++;
            node = node.next;

        }
        return counter;
    }
}