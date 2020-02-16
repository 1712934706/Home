package temp;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import temp.algorithm.tree.BTree;

public class hello {

  public static void main(String[] args) {

    /**************************排序和搜索**************************/
//    AllSort allSort = new AllSort();
//    AllQuery allQuery = new AllQuery();
//    int[] data = new int[]{18, 1, 23, 3, 5, 65, 3, 54, 31, 47};
////    allSort.insertSort(data);
////    allSort.shellSort(data);
////    allSort.quickSort(data, 0, data.length - 1);
////    allSort.heapSort(data);
//    allSort.mergeSort(data);
//
//    int val = allQuery.binarySearch(data, 65);
//    System.out.println(val);
//
//    for (int i = 0; i < data.length; i++) {
//      System.out.println(data[i]);
//    }

    /*****************************树********************************/

    BTree bTree = new BTree();
    BTree.BinaryTree binaryTree = bTree.new BinaryTree();
    binaryTree.setVal(1);
    BTree.BinaryTree binaryTree1 = bTree.new BinaryTree();
    binaryTree1.setVal(2);
    BTree.BinaryTree binaryTree2 = bTree.new BinaryTree();
    binaryTree2.setVal(3);
    binaryTree.setLeft(binaryTree1);
    binaryTree.setRight(binaryTree2);
    BTree.BinaryTree binaryTree3 = bTree.new BinaryTree();
    binaryTree3.setVal(4);
    BTree.BinaryTree binaryTree4 = bTree.new BinaryTree();
    binaryTree4.setVal(5);
    binaryTree1.setLeft(binaryTree3);
    binaryTree1.setRight(binaryTree4);
    List<Integer> res = bTree.InorderTraverse(binaryTree);
    for (Integer a : res) {
      System.out.println(a);
    }
    System.out.println();
    res = bTree.notRecursionInorderTraverse(binaryTree);
    for (Integer a : res) {
      System.out.println(a);
    }
    System.out.println();
    res = bTree.colorInorderTraverse(binaryTree);
    for (Integer a : res) {
      System.out.println(a);
    }

    System.out.println();
    res = bTree.notRecursionPreorderTraverse(binaryTree);
    for (Integer a : res) {
      System.out.println(a);
    }

    System.out.println();
    res = bTree.notRecursionPostorderTraverse(binaryTree);
    for (Integer a : res) {
      System.out.println(a);
    }


  }


  class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public int[][] updateMatrix(int[][] matrix) {
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    int[][] res = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; i < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          res[i][j] = 0;
        } else {
          res[i][j] = cal(visited, matrix, 0, 0, 0);
          for (int k = 0; k < matrix.length; k++) {
            for (int p = 0; p < matrix[0].length; p++) {
              visited[k][p] = false;
            }
          }
        }
      }
    }

    return res;
  }

  public int cal(boolean[][] visited, int[][] matrix, int row, int col, int value) {
    if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
      return Integer.MAX_VALUE;
    }
    if (visited[row][col] = true) {
      return Integer.MAX_VALUE;
    }
    visited[row][col] = true;
    if (matrix[row][col] == 1) {
      value++;
      int a = Math.min(value, cal(visited, matrix, row++, col, value));
      a = Math.min(a, cal(visited, matrix, row, col++, value));
      a = Math.min(a, cal(visited, matrix, row--, col, value));
      a = Math.min(a, cal(visited, matrix, row, col--, value));
      return a;
    } else {
      return value;
    }

  }


  /**
   * 线程池以及任务，callable接口
   */
  public void testThread() {

    ThreadCall threadCall = new ThreadCall();

    //线程池
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 100,
        TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

    ExecutorService executorService = Executors.newCachedThreadPool();

    //Future任务
    //Future<Integer> result = executorService.submit(threadCall);

    //FutureTask任务
    FutureTask<Integer> result = new FutureTask<Integer>(threadCall);
    executorService.submit(result);

    executorService.shutdown();

    try {
      Integer a = result.get();
      System.out.println(a);
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }


  /**
   * runable线程测试
   */
  public String test(String s, int numRows) {
    if (null == s || s.length() < 1) {
      return "";
    }
    if (numRows < 2) {
      return s;
    }
    Character[][] str = new Character[numRows][s.length()];

    int row = 0, col = 0;

    for (int i = 0; i < s.length(); i++) {
      if (row == numRows - 1) {
        str[row][col] = s.charAt(i);
        while (true) {
          if (--row == 0) {
            i++;
            break;
          } else {
            if (i < s.length() - 1) {
              str[row][++col] = s.charAt(++i);
            }
          }

        }

      } else {
        str[row][col] = s.charAt(i);
        while (true) {
          if (++row == numRows - 1) {
            i++;
            break;
          } else {
            if (i < s.length() - 1) {
              str[row][col] = s.charAt(++i);
            }
          }

        }

      }

    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < s.length(); j++) {
        if (null != str[i][j]) {
          sb.append(str[i][j]);
        }
      }
    }

    return sb.toString();

  }


}
