import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
public class Player implements Iterable<Card>{
    String name;
    List<Card> list;
  
    public Player(String name,List<Card>list){
        this.name = name;
        this.list = list;
    }
    public String getName(){
        return this.name;
    }
    public int getCardNo(int index){
        return this.list.get(index).getNo();
    }
    public void sort(){
        Collections.sort(this.list);
    }
    public void sort(Comparator<Card> comparator) {
        Collections.sort(this.list, comparator);
    }
    public Iterator<Card> iterator(){
        return this.list.iterator();
    }
    public Rank pokerAlgorithm(){
        if(Poker.isOnePair(list)){
            if(Poker.isThreeofaKind(list)){
                return Rank.FullHouse;
            }
           else{
                return Rank.OnePair;
         }
        }
        if(Poker.isTwoPair(list)){
            return Rank.TwoPair;
        }
        if(Poker.isThreeofaKind(list)){
            return Rank.ThreeofaKind;
        }
        if(Poker.isFourCard(list)){
            return Rank.FourofaKind;
        }
        if(Poker.isStraight(list)){
            if(Poker.isFlush(list)){
                return Rank.StraightFlush;
            }
            else{
                return Rank.Straight;
            }
        }
        if(Poker.isFlush(list)){
            return Rank.Flush;
        }
        else{
            return Rank.HighCard;
        }
    }

    
}
