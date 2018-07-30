import java.io.*;
import java.net.*;
import java.util.*;

public class TweetCollection {
  
  ArrayList<Tweet> x = new ArrayList<Tweet>();
  
  public void said(String o, String p ) {
   System.out.print(o +" " +  "said " + p);
   }
  
  public int getSize() {
    int a =0;
    for(int i=0; i<this.x.size();i++){
    a++;
    }
    return a;  
   }
  public String toString(){
    String result ="";  
      for (Tweet a : this.x){
       result+= a +"\n" ;
      }
      return result;
   }
  public static void main(String[] argv) throws IOException {
    TweetCollection as = new TweetCollection();
    URL url = new URL("http://homes.soic.indiana.edu/classes/spring2016/csci/c343-yye/tweet-data-Jan16.txt");
    Scanner in = new Scanner(url.openStream());
     while (in.hasNext()) {
            String str = in.nextLine();
            System.out.println("Line=" + str);
              int c = str.indexOf(" ");
              String x = str.substring(0,c);
              String y = str.substring(c+1);
              as.said(x, y);
        }   
        in.close();
        System.out.println(as.toString());
        System.out.println(as.getSize());
    }
}

  
        
         
       
