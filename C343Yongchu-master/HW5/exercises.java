/*
5.14
If equal valued nodes were allowed to appear in either subtree, then during a
search for all nodes of a given value, whenever we encounter a node of that
value the search would be required to search in both directions.
5.15
a)                    15
                  /         \
                 5           20
                  \         /    \
                   7      18       25 
                          /
                         16
b) Pre-orden: 15-5-7-20-18-16-25
   In-orden: 5-7-15-16-18-20-25
   Post-orden: 7-5-16-18-25-20-15 
5.24
The smallest element will be a leaf (because if it had a child, that child
would have to be smaller).
*/ 
