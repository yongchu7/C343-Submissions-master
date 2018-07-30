import java.util.*;
public class Implement implements twoDArray{
    int[][]ls;
    
public Implement(int a, int b){
  this.ls = new int[a][b]; 
 }

 public int[][] insert(int a , int b, int n){
  this.ls[a][b] = n;
  return this.ls;
 } 
 public int[][] delete(int a , int b){
  this.ls[a][b] = 0;
  return this.ls;
 }
public int[][] Initialize(int a, int b){
     this.ls = new int[a][b];
     return this.ls; 
    }
 public String toString(){
  String s= "" ;
  for (int[] list : this.ls){
   s = s + Arrays.toString(list) +"\n";
  }
  return s;
 }
}
