import java.util.*;
public class MyCard {
 public void initialize(){
int[] deck = new int[52];
    String[] suits = {"S", "H", "D", "C"};
    String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    String card = new String();
  }


 public String drawCard() {
   int[] deck = new int[52];
    String[] suits = {"S", "H", "D", "C"};
    String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    String card = new String();
    Random rnd = new Random();
    int t = rnd.nextInt(53);
      String suit = suits[t / 13];
      String rank = ranks[t % 13];
      card =  rank + suit;
      return card;
  }


 public static void main(String[] args) {
   MyCard n = new MyCard();
   n.initialize();
   System.out.println(n.drawCard());
 }
}