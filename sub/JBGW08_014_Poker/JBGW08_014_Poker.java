import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Scanner;
import java.util.Iterator;
public class JBGW08_014_Poker{
    static List<Card> pokerCard = new ArrayList<>();
    static Map<Rank, Integer> score = Rank.rankScore();

    static void generateCard(){     //generate 52Cards
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
    static List<Card> selectCard(){     //provide 5cards
        List<Card> myCard = new ArrayList<>();
        for(int i=0;i<5;i++){
            myCard.add(pokerCard.get(i));
            pokerCard.remove(i);
        }
        return myCard;
    }
    static void printCard(Player player, Player computer){
        //generate iterator
        Iterator<Card> playerIterator = player.iterator();
        Iterator<Card> computerIterator = computer.iterator();

        //print Player's card(using iterator)
        System.out.println(player.getName()+"'s Five Card");
        while(playerIterator.hasNext()){
            System.out.println(playerIterator.next());
        }System.out.println("\nComputer's Five Card");
        while(computerIterator.hasNext()){
            System.out.println(computerIterator.next());
        }System.out.println();
    }
    static void printRank(Player p){
        Rank playerScore = p.pokerAlgorithm();
        int pScore = score.get(playerScore);
        System.out.println(p.getName()+": "+playerScore+" "+pScore+"점");
        if(playerScore==Rank.HighCard){
            System.out.println(p.getName()+"'s high card : "+p.getCardNo(4)+"\n");
        }
    }
    static void whoisWinner(Player player, Player computer){
        int pScore = score.get(player.pokerAlgorithm());
        int cScore = score.get(computer.pokerAlgorithm());
        //who is winner
        if(pScore>cScore){
            System.out.println("winner: "+player.getName());
        }else if(pScore<cScore){
            System.out.println("winner: "+computer.getName());
        }else{
            System.out.println("No winner");
        }
    }

    public static void main(String []args){
        generateCard();
        Collections.shuffle(pokerCard);     //card shuffle

        Scanner sc = new Scanner(System.in);
        System.out.print("Write your name: ");
        String name = sc.nextLine();
       
        Player player = new Player(name, selectCard());   //player
        Player computer = new Player("computer",selectCard());   //computer
        //card sort
        player.sort();
        computer.sort();

        printCard(player, computer);
        
        //result
        printRank(player);
        printRank(computer);
        
        whoisWinner(player, computer);
        sc.close();
    }
}