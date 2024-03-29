/*
 * 11.4
 * 1-->2-->3-->5-->4-->6
 * 
 * 11.6
 * 1-->2-->3
 * | \
 * |  \
 * V   V
 * 6    4-->5
 * 
 * 11.9
 * In the worst case, and algorithm for finding the shortest path between a given
 * pair of vertices i and j will have to visit every node in the graph. In the
 * process of visiting every node in the graph, we can determine the shortest
 * paths from the start vertex to all the nodes. Thus, in the worst case, the
 * cost for finding all of the shortest paths is no worse than the cost to find the
 * shortest path between a specified pair of vertices.
 * 
 * 11.10
 *           1 2  3  4  5  6
 * initial  �� �� �� 0  �� ��
 * Process4 20 5  �� 0 11 10
 * Process2 15 5  8  0 11 10
 * Process3 15 5  8  0 11 10
 * Process6 12 5  8  0 11 10
 * Process5 12 5  8  0 11 10
 * Process1 12 5  8  0 11 10
 */
 









