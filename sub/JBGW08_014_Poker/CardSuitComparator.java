import java.util.Comparator;
import java.util.Map;
public class CardSuitComparator implements Comparator<Card>{
    public static Map<Suit, Integer> score = 
    Map.of(Suit.Spade,4,Suit.Diamond,3,Suit.Heart,2,Suit.Club,1);
    public int compare(Card o1, Card o2) {
      int o1Score = score.get(o1.getSuit());
      int o2Score = score.get(o2.getSuit());
      if(o1Score<o2Score){
        return 1;
      }
      else if(o1Score==o2Score){
        return 0;
      }
      else{
        return -1;
      }
    }
    
}
