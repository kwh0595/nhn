public class Stack{
    public static int index = 0;
    public static int []array = new int[100];

    public static boolean isEmpty(){
      if(index<=0){
        return true;
      }
      return false;
    }
    public static boolean isFull(){
        if(index>array.length){
            return true;
        }
        return false;
    }
    public static void push(int n){
        if(isFull()){
            throw new ArrayIndexOutOfBoundsException();
        }
        array[index++] = n;
    }
    public static int  pop(){
       if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
       }
       return array[--index];

    }
    public static int top(){
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        int tmp = array[index]-1;
        return tmp;

    }
    public static void main(String []args){
        push(1);
        push(2);
        push(3);
        System.out.println(isFull());
        System.out.println(isEmpty());
        System.out.println(pop());
        System.out.println(top());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(isEmpty());
    }
}