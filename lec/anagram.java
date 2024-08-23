public class anagram{
    public static char[] toChar(String value){
        char result[] = new char[value.length()];
        for(int i=0;i<result.length;i++){
            result[i] = value.charAt(i);
         }
         return result;
    }
    public static char[] removeWhite(char array[]){
        int count = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]!=' '){
                count++;
            }
        }
        char[] result = new char[count];
        int index = 0;
        for(char i: array){
            if(i!=' '){
                result[index++] = i;
            }
        }
        return result;

    }
    public static char[] toLower(char[] array){
        for(int i=0;i<array.length;i++){
            if(array[i]>='A' && array[i]<='Z'){
                array[i] +=32;
            }
        }
        return array;
    }
    public static void sortArray(char[] array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    char tmp = ' ';
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }
    public static boolean isEqual(char[] a, char []b){
       if(a.length != b.length){
        return false;
       }
       for(int i=0;i<a.length;i++){
        if(a[i]!=b[i]){
            return false;
        }
       }
        return true;
    }
    public static void main(String []args){
        String s = "App le";
        String s1 = "a pL le";

        char[] c = toChar(s);
        char[] c1 = toChar(s1);

        c = toLower(removeWhite(c));
        c1 = toLower(removeWhite(c1));
        
        sortArray(c);
        sortArray(c1);

        System.out.println(isEqual(c,c1));
      
    }
}
