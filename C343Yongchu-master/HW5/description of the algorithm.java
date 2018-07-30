/*
description of the algorithm
There are three help functions in my BSTJr.java and one forBinNode that I added here.
The getLeast helps me to get the smallest node,
after I get the smallest node, I use the previous function to get the node¡¯s parent 
if it is on the left side. else we recurse the lookup function on the node¡¯s parent.
I use find function to get the node which is bigger than the node I enter.
finally I use the search function to search Kth smallest value.
I run this function from root to the smallest node then get the Kth smallest value. 
The running time is log(n) + k, so the big 0 is log(n)
*/
