// instructed by Weixi Ma

import java.util.*;

public class KDtree<Key extends Integer, E> {
  private BinNode<Key, E> root;
  private int totalNode;
  private BinNode<Key, E> curr;
  private String enumStr;
  private int dim;
  private int level;
  public ArrayList<BinNode> neighbors = new ArrayList<BinNode>();

  public KDtree(int d) {
    root = curr = null;
    totalNode = 0;
    dim = d;
    level = 0;
  }

  public BinNode<Key, E> find(Key[] k) {
    if(root == null) return null;
    else {
      return find(root, 0, k);
    }
  }

  public BinNode<Key, E> find(BinNode<Key, E> entry, int thislevel, Key[] k) {
    if(entry == null) return null;
    curr = entry;
    level = thislevel; //update level
    if(Arrays.equals(entry.getKey(),k)) {
      return curr;
    }
    else {
      if(entry.isLeaf()) return null;
      Key[] key2 = entry.getKey();
      if (k[level % dim].compareTo(key2[level % dim]) >= 0) { //make sure the "right" key is used
        return find(entry.getRight(), thislevel + 1, k); //note thislevel + 1
      }
      else {
        return find(entry.getLeft(), thislevel + 1, k);
      }
    }
  }

  public void insert(Key[] k, E v) {
    BinNode<Key, E> node = new BinNode <Key, E>(k, v);
    insert(node);
    //insert(root, node);
  }

  public void insert(BinNode<Key, E> node) {
    find(node.getKey());
    if(curr == null) {
      root = node;
    }
    else {
      Key[] key1 = node.getKey();
      Key[] key2 = curr.getKey();
      if (key1[level % dim].compareTo(key2[level % dim]) >= 0) {
        if(curr.getRight() != null) node.setRight(curr.getRight());
        curr.setRight(node);
      }
      else {
        if(curr.getLeft() != null) node.setLeft(curr.getLeft());
        curr.setLeft(node);
      }
    }
    totalNode ++;
  }

  public void preorder() {
    enumStr = "";
    System.out.println("Total node = " + totalNode);
    if(root != null) preorder(root);
    System.out.println("Preorder enumeration: " + enumStr);
  }

  private void preorder(BinNode<Key, E> node) {
    if(node != null) System.out.println("root " + node.toString());
    if(node.getLeft() != null) System.out.println("   left " + node.getLeft().toString());
    if(node.getRight() != null) System.out.println("   right " + node.getRight().toString());

    if(node != null) {
      enumStr += node.toString();
    }
    if(node.getLeft() != null) preorder(node.getLeft());
    if(node.getRight() != null) preorder(node.getRight());
  }

  // helper function: distance
  public int  distance(Key[] k1, Key[] k2) {
    int result = 0;
    for (int i = 0; i < k1.length; i += 1) {
      result += ((int)k1[i] - (int)k2[i])*((int)k1[i] - (int)k2[i]);
    }
    return (int)Math.sqrt(result);
  }

  // helper function: GetNeighborsHelp
  public void getNeighborsHelp(Key[] key, int n) {
    this.neighbors = new ArrayList<BinNode>();
    getNeighbors(key, n);
  }

  // implenmentation: getNeighbors
  public void getNeighbors(Key[] key, int r) {
    BinNode<Key, E> leftNode = root.getLeft();
    BinNode<Key, E> rightNode = root.getRight();

    if (distance(key, this.root.getKey()) < r) {
      neighbors.add(root);
    }
    if (leftNode != null) {
      this.root = leftNode;
      getNeighbors(key, r);
    }
    if (rightNode != null) {
      this.root = rightNode;
      getNeighbors(key, r);
    }
  }


  public static void main(String[] args) {

    KDtree <Integer, String> kdt = new KDtree<Integer, String>(2);
    Integer[] dataA = {40, 45};
    kdt.insert(dataA, "A");
    Integer[] dataB = {15, 70};
    kdt.insert(dataB, "B");
    Integer[] dataC = {70, 10};
    kdt.insert(dataC, "C");
    Integer[] dataD = {69, 50};
    kdt.insert(dataD, "D");
    Integer[] dataE = {66, 85};
    kdt.insert(dataE, "E");
    Integer[] dataF = {85, 95};
    kdt.insert(dataF, "F");
    kdt.preorder();

    Integer[] dataG = {85, 93}; //G, close to F
    System.out.println("Query location: " + dataG[0] + " " + dataG[1]);
    BinNode<Integer, String> node = kdt.find(dataG);
    if(node == null) {
      System.out.println("point not found");
    }
    else {
      System.out.println("point found: " + node.toString());
    }
    int r = 3;
    kdt.getNeighborsHelp(dataG, r); //get close neighbors
    System.out.println(kdt.neighbors);



    // test 3-dimensional:
    KDtree <Integer, String> kdt2 = new KDtree<Integer, String>(3);
    Integer[] a = {78, 92, 150};
    kdt2.insert(a, "1");
    Integer[] b = {40, 56, 76};
    kdt2.insert(b, "2");
    Integer[] c = {120, 30, 150};
    kdt2.insert(c, "3");
    Integer[] d = {126, 99, 134};
    kdt2.insert(d, "4");
    Integer[] e = {124, 127, 177};
    kdt2.insert(e, "5");
    Integer[] f = {170, 180, 188};
    kdt2.insert(f, "6");
    kdt2.preorder();

    Integer[] dataG2 = {170, 176, 185};
    System.out.println("Query location: " + dataG2[0] + " " + dataG2[1] + " " + dataG2[2]);
    BinNode<Integer, String> node2 = kdt2.find(dataG2);
    if(node2 == null) {
      System.out.println("point not found");
    }
    else {
      System.out.println("point found: " + node2.toString());
    }
    int s = 60;
    kdt2.getNeighborsHelp(dataG2, s); //get close neighbors
    System.out.println(kdt2.neighbors);
  }
}