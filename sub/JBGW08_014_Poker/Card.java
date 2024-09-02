public class Card implements Comparable<Card>{
    int no;
    Suit suit;
    String displayNo;
    Card(){}
    Card(int no, Suit suit, String displayNo){
        this.no = no;
        this.suit = suit;
        this.displayNo = displayNo;
    }
    public Suit getSuit(){
        return this.suit;
    }
    public int getNo(){
        return this.no;
    }
    public String toString(){
        return this.displayNo+", "+this.suit;
    }
    public int compareTo(Card o) {
       return this.no-o.no;
    }
   
}
