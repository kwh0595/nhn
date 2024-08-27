public class Stack{
    public static int stack[]= new int[100];
    public static int size = 0;
    public static boolean isEmpty(){
        if(size==0){
            return true;
        }return false;
    }
    public static void push(int n){
        stack[size++]=n;
    }
    public static int pop(){
        return stack[--size];
    }
    public static int top(){
        int tmp = stack[size-1];
        return tmp;
    }
    public static void main(String []args){
        push(1);
        push(2);
        System.out.println(top());
        System.out.println(pop());
        System.out.println(top());
        System.out.println(isEmpty());
        System.out.println(pop());
        System.out.println(isEmpty());

    }
}