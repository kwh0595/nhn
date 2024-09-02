import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Scanner;
import java.util.Iterator;
public class JBGW08_014_Poker{
    static List<Card> pokerCard = new ArrayList<>();
    static Map<Rank, Integer> score = Rank.rankScore();
    static void generateCard(){
        String JQKA[] = {"J","Q","K","A"};
        for(int i=2;i<=14;i++){
            for(Suit s: Suit.values()){
                if(i>=11){
                    pokerCard.add(new Card(i,s,JQKA[i-11]));
                }
                else{
                    pokerCard.add(new Card(i,s,Integer.toString(i)));
                }
            }
        }
    }
    static List<Card> selectCard(){
        List<Card> myCard = new ArrayList<>();
        for(int i=0;i<5;i++){
            myCard.add(pokerCard.get(i));
            pokerCard.remove(i);
        }
        return myCard;
    }
    public static void main(String []args){
        generateCard();
        Collections.shuffle(pokerCard);

        Scanner sc = new Scanner(System.in);
        System.out.print("Write your name: ");
        String name = sc.nextLine();
       
        Player player = new Player(name, selectCard());
        Player computer = new Player("computer",selectCard());

        player.sort();
        computer.sort();

        Iterator<Card> playerIterator = player.iterator();
        Iterator<Card> computerIterator = computer.iterator();

        System.out.println(player.getName()+"'s Five Card");
        while(playerIterator.hasNext()){
            System.out.println(playerIterator.next());
        }System.out.println("\nComputer's Five Card");
        while(computerIterator.hasNext()){
            System.out.println(computerIterator.next());
        }

       Rank playerScore = player.pokerAlgorithm();
       Rank computerScore = computer.pokerAlgorithm();
       int pScore = score.get(playerScore);
       int cScore = score.get(computerScore);

       System.out.println(player.getName()+": "+playerScore+" "+pScore+"점");
       System.out.println(computer.getName()+": "+computerScore+" "+cScore+"점");
       
       if(pScore>cScore){
        System.out.println("winner: "+player.getName());
       }else if(pScore<cScore){
        System.out.println("winner: "+computer.getName());
       }else{
        System.out.println("No winner");
       }
       if(playerScore==Rank.HighCard && computerScore==Rank.HighCard){
        System.out.println("player high card : "+player.getCardNo(4));
        System.out.println("computer high card :"+computer.getCardNo(4));
       }

        sc.close();
    }
}