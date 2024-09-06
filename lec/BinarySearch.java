public class BinarySearch<T extends Comparable<T>>{
    static int count=0;

    public static <T extends Comparable<T>>void sort(T[] array){{
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-1-i;j++){
               if(array[j].compareTo(array[j+1])>0){
                    T tmp;
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }}
    public static Integer binarySearch(Integer[] array, int value){
        int low = 0;
        int high = array.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(array[mid]>value){
                high= mid -1;
            }else if(array[mid]<value){
                low = mid+1;
            }
            else{
                return mid;
            }
            count++;
        }return -1;
    }
    
    public static void main(String []args){
        Integer[] array = {4,3,5,6,2,11}; // 2 3 4 5 6 11
        sort(array);
        
        for(Integer i:array){
            System.out.print(i+" ");
        }System.out.println();
        System.out.println(array[binarySearch(array, 5)]);
        System.out.println(count);
    }

   
}