public class countingsort {
  public static int[] CountingSort(int[] A){
  int maxnumber = maxnumber(A)+1;
int[] c = new int[maxnumber];
  for (int i = 0; i < A.length; i++) {
     c[A[i]] += 1;
}
  

for (int i = 1; i < maxnumber; i++){
     c[i] += c[i-1];
}
int[] sorted = new int[A.length];
  
  for (int i = A.length-1; i >= 0; i--){
    int x = A[i];
    int count = c[x];
    sorted[count-1] = x;
    c[x] -= 1;
  }
  return sorted;
  }
  
  public static int maxnumber (int[] A) {
    int maxnumber = -1;
    for (int i = 0; i < A.length; i+=1) {
      if(A[i] > maxnumber){
        maxnumber = A[i];
      }
    }
    return maxnumber;
  }
  
  public static void printArr(int[] A) {
    int len = A.length;
    for(int index=0; index<len; index+=1) {
      System.out.print(A[index]);
      System.out.print(" ");
    }
    System.out.println();
  }
  
  public static void main(String[] argx) {
    int[] arr = new int[] {1,2,1,0,3,4,5,1,2,4,5,6,1};
   
    printArr(CountingSort(arr));
  }
}