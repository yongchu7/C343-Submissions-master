import java.util.*;
import java.io.*;

public class Tweet {
  public String twitter;
  public String name;
  public Tweet(String pushtwitter, String pushname){
      twitter = pushtwitter;
      name = pushname;
    System.out.println( twitter + "wrote by " + name);
   }
  public static void main(String args[]){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your twitter:");
    String twitter = input.nextLine();
    
    System.out.println("What is your name?");
    String name = input.nextLine();
    Tweet twt = new Tweet(twitter, name);
    
    
}
}