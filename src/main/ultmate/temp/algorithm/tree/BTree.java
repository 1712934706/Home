package temp.algorithm.tree;

public class BTree {
  class BinaryTree{
    int val;
    BinaryTree left;
    BinaryTree right;
  }

  /**************************递归的中序遍历**************************/
  public void InorderTraverse(BinaryTree root){
    if(null != root){
      InorderTraverse(root.left);
      System.out.println(root.val);
      InorderTraverse(root.right);
    }
  }

  /**************************非递归的中序遍历**************************/


}
