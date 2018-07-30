public class  binarysearch <A extends Comparable<?super A>>{
  private static int Binarysearch(Object[] A, Object k){
    int l= -1;
    int r= A.length;
    Comparable v = (Comparable) k;
  while (l+1 != r) { // Stop when l and r meet
    int i = (l+r)/2; // Check middle of remaining subarray
    if (v.compareTo(A[i]) == 0) 
      return i; // Found it
    else if (v.compareTo(A[i]) < 0) 
      r = i; // In left half
    else 
      l = i; // In right half
 }
 return A.length; // Search value not in A
}
  
  public static void main(String[] args) {
    //int[] A = new int[] {1,2,3,4};
    Object[] A = new Object[] {1,4,5,6};
    Object[] B = new Object[] {"a", "b", "c"};
    
    Object k = 8;
      
    binarysearch bs = new binarysearch();
    int res = bs.Binarysearch(A,k);
    System.out.println(res);
    System.out.println(bs.Binarysearch(B,B[2]));
  }
}
 