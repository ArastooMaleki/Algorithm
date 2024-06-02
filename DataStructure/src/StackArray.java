public class StackArray {
    private  String[] s;
    private int N ;
    public StackArray(int capacity){
        s = new String[capacity];
    }
    public void push(String item){
        s[N] = item ;
        N++;
    }
    public String pop(){
        String item = s[--N];
        s[N] = null;
        return item ;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int hight(){
        return (N) ;
    }
}