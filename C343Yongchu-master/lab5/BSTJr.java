//a simple BST tree (so we call it BSTJr) for C343
public class BSTJr <K extends Comparable<?super K>> {
 BinNode<K> root;
 BinNode<K> curr;
 //for balance checking: if a node is unbalanced, the tree will be unbalanced
 BinNode<K> unbalanced = null;
 public BSTJr() {
  root = null;
  curr = null;
 }
 public void build(K[] ks) {
  for(int i = 0; i < ks.length; i ++) insert(ks[i]);
 }
 public void insert(K k) {
  BinNode<K> t = new BinNode<K>(k);
  if(root == null) {
   root = curr = t;
  }
  else {
   curr = search(root, k);
   if(k.compareTo(curr.getKey()) < 0) curr.setLeft(t);
   else curr.setRight(t);
  }
 }
 public int getHeight(BinNode<K> root) {
  if (root == null)
   return 0;
  int left = getHeight(root.getLeft());
  int right = getHeight(root.getRight());
  if (left == -1 || right == -1)
   return -1;
  if (Math.abs(left - right) > 1) {
   return -1;
  }
  return Math.max(left, right) + 1;
 }

 public boolean isBalanced(BinNode<K> root) {
  if (root == null)
    return true;
  if (getHeight(root) == -1)
    return false;
    return true;
  }

     
 
 
 public BinNode<K> search(BinNode<K> entry, K k) {
  if(entry == null) return null;
  else { 
   entry.setSize(entry.getSize() + 1); //update the size of the subtree by one
   if(entry.isLeaf()) return entry;
   if(k.compareTo(curr.getKey()) < 0) {
    if(entry.getLeft() != null) return search(entry.getLeft(), k);
    else return entry;
   }
   else {
    if(entry.getRight() != null) return search(entry.getRight(), k);
    else return entry;
   }
  }
 }

 public void display() { 
  if(root == null) return;
  System.out.println("Preorder enumeration: key(size-of-the-subtree)");
  preorder(root); 
  System.out.println();
 }
 public void preorder(BinNode<K> entry) {
  System.out.print(entry.getKey() + "(" + entry.getSize() + ") ");
  if(entry.getLeft() != null) preorder(entry.getLeft());
  if(entry.getRight() != null) preorder(entry.getRight());
 }
 public static void main(String[] argv) {
  BSTJr<Integer> tree = new BSTJr<Integer>();
  Integer[] ks = {4, 2, 1, 3, 6, 5, 7};
  tree.build(ks);
  tree.display();
  tree.isBalanced(tree.root);
  System.out.println(tree.isBalanced(tree.root));
 }
}
 