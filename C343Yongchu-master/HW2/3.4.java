/*3.12(a)
(a) a = b + c;
    d = a + e;
    ��(1)
    
(b) sum = 0;
    for (i=0; i<3; i++)
    for (j=0; j<n; j++)
    sum++;
    ��(n)

(c) sum=0;
    for (i=0; i<n*n; i++)
    sum++;
    ��(n^2)
(d)
for (i=0; i < n-1; i++)
for (j=i+1; j < n; j++) {
tmp = AA[i][j];
AA[i][j] = AA[j][i];
AA[j][i] = tmp;
} 
��(n!)

(e) sum = 0;
 for (inti=1; i<=n; i++){
    for (int j=1; j<=n; j*=2){
        sum++;
        }
       }
 ��(n*log2 ^n)
 
(f) sum = 0;
 for (int i=1; i<=n; i*=2){
  for (int j=1; j<=n; j++){
   sum++;}
  }
 ��(n*log2 ^n)
 
(g) Assume that array A contains n values, Random takes constant time,
 and sort takes n log n steps.
 for (i=0; i<n; i++) {
  for (j=0; j<n; j++){
   A[j] = DSutil.random(n);
    sort(A);
    }
    ��(n^2log n)
   
(h) Assume array A contains a random permutation of the values from 0 to n ? 1.
sum = 0;
for (i=0; i<n; i++)
for (j=0; A[j]!=i; j++)
sum++; 
��(n^2)    
  */
