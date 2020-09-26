package temp;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
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
////    List<Integer> res = inorder(binaryTree);
////    List<Integer> res = bTree.InorderTraverse(binaryTree);
//    for (Integer a : res) {
//      System.out.println(a);
//    }
//    System.out.println();
//    res = bTree.notRecursionInorderTraverse(binaryTree);
//    for (Integer a : res) {
//      System.out.println(a);
//    }
//    System.out.println();
//    res = bTree.colorInorderTraverse(binaryTree);
//    for (Integer a : res) {
//      System.out.println(a);
//    }
//
//    System.out.println();
//    res = bTree.notRecursionPreorderTraverse(binaryTree);
//    for (Integer a : res) {
//      System.out.println(a);
//    }
//
//    System.out.println();
//    res = bTree.notRecursionPostorderTraverse(binaryTree);
//    for (Integer a : res) {
//      System.out.println(a);
//    }

    /*****************************图********************************/
//    Graph graph = new Graph();
//    List<Integer> res = graph.dfs(new HashMap<>());
//
//    res.forEach(i -> System.out.println(i));
//
//    System.out.println();
//    res = graph.bfs(new HashMap<>());

    int[] data = new int[]{
        2, 5, 3, 8, 12, 1, 34, 21, 24, 10
    };

//    qc(data, 0, data.length - 1);
    for (int i = 0; i < data.length; i++) {
      System.out.println(data[i]);
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


  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }

  }


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
    try {
      int res = result.get();
    } catch (Exception e) {

    }
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
  public void test(String s, int numRows) {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.pop();

    List<Integer> list = new ArrayList<>();
    list.add(1);

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(1);
    queue.poll();

    Deque<Integer> deque = new LinkedList<>();
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    priorityQueue.offer(1);

    Map<String, String> map = new HashMap<>();
    map.put("a", null);
  }

  public int testC() throws Exception {
    for (int i = 0; i < 2; i++) {
      try {
        throw new Exception("BB");
      } catch (Exception e) {
        throw e;
      } finally {
        continue;
      }
    }

    return 0;
  }


}
