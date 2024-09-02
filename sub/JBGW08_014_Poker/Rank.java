import java.util.Map;
public enum Rank {
    StraightFlush,
    FourofaKind,
    FullHouse,
    Flush,
    Straight,
    ThreeofaKind,
    TwoPair,
    OnePair,
    HighCard;

    public static Map<Rank,Integer> rankScore(){
        return Map.of(Rank.StraightFlush,100, Rank.FourofaKind,90, 
        Rank.FullHouse,80,Rank.Flush,70,
        Rank.Straight,60,Rank.ThreeofaKind,50,
        Rank.TwoPair,40,Rank.OnePair,30, Rank.HighCard,20);
    }
}
