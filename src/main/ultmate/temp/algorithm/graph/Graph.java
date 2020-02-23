package temp.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {


  private Map<Integer, List<Integer>> graph = new HashMap<>();

  //     图结构如下
//          1
//        /   \
//       2     3
//      / \   / \
//     4  5  6  7
//      \ | / \ /
//        8    9
  {
    graph.put(1, Arrays.asList(2, 3));
    graph.put(2, Arrays.asList(1, 4, 5));
    graph.put(3, Arrays.asList(1, 6, 7));
    graph.put(4, Arrays.asList(2, 8));
    graph.put(5, Arrays.asList(2, 8));
    graph.put(6, Arrays.asList(3, 8, 9));
    graph.put(7, Arrays.asList(3, 9));
    graph.put(8, Arrays.asList(4, 5, 6));
    graph.put(9, Arrays.asList(6, 7));
  }

  /***************************DFS*****************************/
  public List<Integer> dfs(Map<Integer, List<Integer>> graph) {
    graph = this.graph;
    Map<Integer, Boolean> visited = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    Integer[] a = new Integer[9];
    for (Integer vertex : graph.keySet().toArray(a)) {
      dfsCore(vertex, graph, visited, res);
    }
    return res;
  }

  private void dfsCore(Integer vertex, Map<Integer, List<Integer>> graph,
      Map<Integer, Boolean> visited, List<Integer> res) {
    if (visited.getOrDefault(vertex, false) != true) {
      //记录访问过的节点
      visited.put(vertex, true);
      res.add(vertex);
      List<Integer> adjacentVertex = graph.get(vertex);
      //遍历所有相邻点
      for (Integer vertexNext : adjacentVertex) {
        dfsCore(vertexNext, graph, visited, res);
      }
    }
  }

  /***************************BFS*****************************/
  public List<Integer> bfs(Map<Integer, List<Integer>> graph) {
    graph = this.graph;
    Map<Integer, Boolean> visited = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    Integer[] a = new Integer[9];
    for (Integer vertex : graph.keySet().toArray(a)) {
      bfsCore(vertex, graph, visited, res);
    }
    return res;
  }


  private void bfsCore(Integer vertex, Map<Integer, List<Integer>> graph,
      Map<Integer, Boolean> visited, List<Integer> res) {

    //图，有可能会存在孤立的节点，不和其他节点相连
    if (!visited.getOrDefault(vertex, false)) {
      List<Integer> vertexs = new LinkedList<>();

      ((LinkedList<Integer>) vertexs).addLast(vertex);
      visited.put(vertex, true);
      res.add(vertex);
      //利用队列的先进先出特性，实现图的层次遍历
      while (!vertexs.isEmpty()) {
        graph.get(((LinkedList<Integer>) vertexs).pop()).forEach(i -> {
          if (!visited.getOrDefault(i, false)) {
            ((LinkedList<Integer>) vertexs).addLast(i);
            visited.put(i, true);
            res.add(i);
          }
        });
      }
    }

  }

  /***************************dijkstra*****************************/

  /***************************floyd*****************************/


}
