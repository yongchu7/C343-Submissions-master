/*1.
a.Un-sorted array or Un-sorted linked list
Since the data are received sorted: in the insert, the BST will not be balanced but will be more like a
linked list, so both the insert and search will be actually O(n) not O(log n)

b.Un-sorted array or Un-sorted linked list
The number of insertions is very very high and search is very low, so, we must first choose the best 
complexity in the insert (since it has the highest impact). This will make 
Un-sorted array or Un-sorted linked list are the best choices Since we previously know the size 
(number of items to be inserted),Un-sorted arraywill be a better choice

c.BST
The number of insertions is equal to the number of search operations, which means they both have 
the same impact

d.BST
The number of search operations is very high so we need to choice the DS with the best search time
complexity. That would be either 
BST or sorted array. BST is better in the insert, so we will choose it.*/

// 2
//0.5N*1 -> FOR A
//0.35N*2 -> FOR T
//0.1N*3 -> FOR G
//0.05N*3 -> FOR C 
//compression ratio : (2*50% + 2*35% + 2*10% + 2*5%)/(1* 50% + 2*35% + 3*10% + 3*5%)
// = (1 + 0.7 + 0.2 + 0.1)/(0.5 + 0.7 + 0.3 + 0.15) = 2/1.65=1.2121

//3 
import java.io.*;
import java.util.*;

public class EDC {
   public static int minDistance(String string1, String string2) {
    int length1 = string1.length();
    int length2 = string2.length();
   
    int[][] sum = new int[length1 + 1][length2 + 1];
    
    for (int i = 0; i <= length1; i++) {
      sum[i][0] = i;
    }
    
    for (int j = 0; j <= length2; j++) {
      sum[0][j] = j;
    }
    
 
    for (int i = 0; i < length1; i++) {
      char char1 = string1.charAt(i);
      for (int j = 0; j < length2; j++) {
        char char2 = string2.charAt(j);
        
        //if last two chars equal
        if (char1 == char2) {
          //update sum value for +1 length
          sum[i + 1][j + 1] = sum[i][j];
        } else {
          int replace = sum[i][j] + 1;
          int insert = sum[i][j + 1] + 1;
          int delete = sum[i + 1][j] + 1;
          
          int min = replace > insert ? insert : replace;
          min = delete > min ? min : delete;
          sum[i + 1][j + 1] = min;
        }
      }
    }
    
    return sum[length1][length2];
  }  
  public static String[] readStr(String filePath) {
    try{
      final File file = new File(filePath);
      final Scanner scanner = new Scanner(file);
      String[] result = new String[2];
      int index=0;
      while(scanner.hasNext()) {
        result[index] = scanner.nextLine();
        index+=1;
      }
      return result;
    }catch (Exception e) {
      System.out.println("error");
      return null;
    }
  }
  public static void main(String[] args){
    final String[] strs = readStr("/Users/51565/Desktop/HW6/string.txt");
    System.out.println(strs[0]);
    System.out.println(strs[1]);
    System.out.println(minDistance(strs[0], strs[1]));
  }
}

