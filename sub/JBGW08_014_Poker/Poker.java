import java.util.List;
import java.util.Arrays;
public class Poker {
    static int[] pair= new int[13];
    public static int[] pairCount=new int[3];
    public static boolean isFlush(List<Card>list){
        Suit s = list.get(0).getSuit();
        for(int i=1;i<list.size();i++){
                if(!(list.get(i).getSuit().equals(s))){
                   return false;   
                }
        }return true;
    }
    public static boolean isStraight(List<Card>list){
        int No = list.get(0).getNo();
        int cnt=0;
        for(int i=1;i<list.size();i++){
            if(No+1==list.get(i).getNo()){
                No = list.get(i).getNo();
                cnt++;
            }
            if(cnt==3 && list.get(0).getNo()==2 && list.get(4).getNo()==14){
                cnt++;
            }
        }
        if(cnt==4){
            return true;
        }
        return false;

    }
    public static boolean isOnePair(List<Card> list){
        Arrays.fill(pair,0);
        Arrays.fill(pairCount,0);
        for(Card c:list){
            for(int i=0;i<pair.length;i++){
                if(c.getNo()==i+2){
                    pair[i]++;
                }
            }
        }
        for(int i: pair){
            if(i==2){
                pairCount[0]++;
            }if(i==3){
                pairCount[1]++;
            }if(i==4){
                pairCount[2]++;
            }
        }
        if(pairCount[0]==1){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isTwoPair(List<Card> list){
        if(pairCount[0]==2){
            return true;
        }
       return false;
    }
    public static boolean isThreeofaKind(List<Card> list){
        if(pairCount[1]==1){
            return true;
        }return false;
    }
    public static boolean isFourCard(List<Card> list){
        if(pairCount[2] ==1){
            return true;
        }return false;
    }
}
