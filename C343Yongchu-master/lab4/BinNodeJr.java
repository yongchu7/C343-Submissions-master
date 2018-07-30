public class BinNodeJr <E extends Comparable<?super E>>{ 
    private E value;
    private BinNodeJr<E> left;
    private BinNodeJr<E> right;
    public BinNodeJr(E e) {
        value = e;
        left = right = null;
    }
    public void setLeft(BinNodeJr<E> node) {
        left = node;
    }
    public void setRight(BinNodeJr<E> node) {
        right = node;
    }
    public boolean find(E q) {
      if(this.value == null) {
         return false;
      }
      else if (q.compareTo(this.value) == 0) {
         return true;
      }
      else if(this.left!=null&&this.right!=null) {
          return (this.left.find(q) || this.right.find(q)); 
        }
      else return false;
      }

    
    public static void main(String[] argv) {
        BinNodeJr<Integer> root = new BinNodeJr<Integer>(10);
        BinNodeJr<Integer> node1 = new BinNodeJr<Integer>(30);
        BinNodeJr<Integer> node2 = new BinNodeJr<Integer>(40);
        root.setLeft(node1);
        root.setRight(node2);
        //find() is to be implemented
        System.out.println("40 is found in the tree: " + root.find(40));
        //find(40) shall return true
        System.out.println("77 is found in the tree: " + root.find(77));
        //find(77) shall return false
    }
}
