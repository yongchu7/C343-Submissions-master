import java.util.*;
public class DNADist {
  public static void main(String[] args) {
    int distance = 0;
    
    Scanner input = new Scanner(System.in);
    
    System.out.println("Enter first DNA:");
    String DNA1 = input.nextLine();
    
    System.out.println("Enter second DNA:");
    String DNA2 = input.nextLine();
    
    for(int i = 0; i <= DNA2.length() - 1; i++){
      if (DNA1.length() != DNA2.length()){
        System.out.println("error");
        break;
      }
      else if( DNA1.charAt(i) != DNA2.charAt(i)){
         distance = distance + 1;
      }
  }
    System.out.println(distance);
}
}