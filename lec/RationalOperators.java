import java.util.*;
public class RationalOperators{
    public static int [] plus(int[] left, int[] right){
        int numerator = left[0] * right[1]+ right[0]*left[1];
        int denominator = left[1]*right[1];

        int g = gCD(numerator, denominator);
        return new int[] { numerator/g, denominator/g};
    }
    public static int []subtract(int[] left, int[] right){
        int numerator = left[0]*right[1]-right[0]*left[1];
        int denominator = left[1]*right[1];

        int g = gCD(numerator, denominator);

        return new int[] {numerator/g, denominator/g};
    }
    public static int gCD(int numerator, int denominator){
        int max = numerator>denominator?numerator:denominator;
        int gcd=0;
        for(int i=1;i<=max;i++){
            if(numerator%i==0 && denominator%i==0){
                gcd=i;
            }
        }
        return gcd;
    }
    public static void main(String []args){
        System.out.println("분자와 분모를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        int []left = new int[2];
        for(int i=0;i<left.length;i++){
            left[i] = sc.nextInt();
        }
        int right[]=  new int[2];
        for(int i=0;i<right.length;i++){
            right[i] = sc.nextInt();
        }
        int result[] = plus(left,right);
        System.out.println("합: "+result[0]+" "+result[1]);
        
        result= subtract(left, right);
        System.out.println("차: "+result[0]+" "+result[1]);
    }
}