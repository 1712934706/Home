package temp.algorithm.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BTree {

  public class BinaryTree {

    int val;
    BinaryTree left;
    BinaryTree right;

    public int getVal() {
      return val;
    }

    public void setVal(int val) {
      this.val = val;
    }

    public BinaryTree getLeft() {
      return left;
    }

    public void setLeft(BinaryTree left) {
      this.left = left;
    }

    public BinaryTree getRight() {
      return right;
    }

    public void setRight(BinaryTree right) {
      this.right = right;
    }
  }

  /**************************递归的中序遍历**************************/
  List<Integer> resTemp = new ArrayList<>();

  public List<Integer> InorderTraverse(BinaryTree root) {
    if (null != root) {
      InorderTraverse(root.left);
      resTemp.add(root.val);
      InorderTraverse(root.right);
    }
    return resTemp;
  }

  /**************************非递归的前序遍历**************************/
  public List<Integer> notRecursionPreorderTraverse(BinaryTree root) {
    List<Integer> res = new ArrayList<>();
    Stack<BinaryTree> stack = new Stack<>();
    BinaryTree cur = root;
    while (null != cur || !stack.isEmpty()) {
      while (null != cur) {
        stack.push(cur.right);
        res.add(cur.val);
        cur = cur.left;
      }
      cur = stack.pop();
    }
    return res;
  }

  /**************************非递归的中序遍历**************************/
  public List<Integer> notRecursionInorderTraverse(BinaryTree root) {
    List<Integer> res = new ArrayList<>();
    Stack<BinaryTree> stack = new Stack<>();
    BinaryTree cur = root;
    while (null != cur || !stack.isEmpty()) {
      while (null != cur) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      res.add(cur.val);
      cur = cur.right;
    }
    return res;
  }

  /**************************非递归的后序遍历**************************/
  public List<Integer> notRecursionPostorderTraverse(BinaryTree root) {
    List<Integer> res = new ArrayList<>();
    Stack<BinaryTree> stack = new Stack<>();
    BinaryTree cur = root;
    while (null != cur || !stack.isEmpty()) {
      while (null != cur) {
        stack.push(cur.left);
        res.add(cur.val);
        cur = cur.right;
      }
      cur = stack.pop();
    }
    Collections.reverse(res);
    return res;
  }

  /**************************颜色标记法遍历**************************/
  //颜色标记遍历方法，兼具非递归遍历的速度和递归遍历简单的写法，针对不同的遍历方式，修改节点入栈的顺序即可
  //根节点初始化为白色，后面在栈中访问过以后变为黑色，把子节点入栈标记为白色
  public List<Integer> colorInorderTraverse(BinaryTree binaryTree) {
    List<Integer> res = new ArrayList<>();
    Stack<Map<Integer, Object>> stack = new Stack<>();
    Map<Integer, Object> node = new HashMap<>();
    node.put(0, binaryTree);
    node.put(1, "white");
    stack.push(node);
    while (null != binaryTree && !stack.isEmpty()) {

      Map<Integer, Object> nodeCur = stack.pop();
      if (null == nodeCur.get(0)) {
        continue;
      }

      if (String.valueOf(nodeCur.get(1)).equals("white")) {
        //子节点初始化时，白色
        if (((BinaryTree) nodeCur.get(0)).right != null) {
          Map<Integer, Object> nodeRight = new HashMap<>();
          nodeRight.put(0, ((BinaryTree) nodeCur.get(0)).right);
          nodeRight.put(1, "white");
          stack.push(nodeRight);
        }

        //访问过，变为黑色
        nodeCur.put(1, "black");
        stack.push(nodeCur);

        //子节点初始化时，白色
        if (((BinaryTree) nodeCur.get(0)).left != null) {
          Map<Integer, Object> nodeLeft = new HashMap<>();
          nodeLeft.put(0, ((BinaryTree) nodeCur.get(0)).left);
          nodeLeft.put(1, "white");
          stack.push(nodeLeft);
        }
      } else {
        res.add(((BinaryTree) nodeCur.get(0)).val);
      }
    }
    return res;
  }

}
