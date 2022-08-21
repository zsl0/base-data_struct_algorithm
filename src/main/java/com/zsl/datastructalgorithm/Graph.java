package com.zsl.datastructalgorithm;

import lombok.Data;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

@Data
public class Graph {
    // 顶点个数
    private int v;
    // 无向图(邻接表)
    private List<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
        addEdge(0, 1);
        addEdge(1, 2);
        addEdge(0, 3);
        addEdge(1, 4);
        addEdge(2, 5);
        addEdge(3, 4);
        addEdge(4, 5);
        addEdge(4, 6);
        addEdge(5, 7);
        addEdge(6, 7);

        /**
         * init graph
         *  0-1-2
         *  | | |
         *  3-4-5
         *    | |
         *    6-7
         */
//        List<Integer> integers = adj[0];
//        integers.add(1);
//        integers.add(3);
//        List<Integer> integers1 = adj[1];
//        integers1.add(0);
//        integers1.add(2);
//        integers1.add(4);
//        List<Integer> integers2 = adj[2];
//        integers2.add(1);
//        integers2.add(5);
//        List<Integer> integers3 = adj[3];
//        integers3.add(0);
//        integers3.add(3);
//        List<Integer> integers4 = adj[4];
//        integers4.add(1);
//        integers4.add(3);
//        integers4.add(5);
//        integers4.add(6);
//        List<Integer> integers5 = adj[5];
//        integers5.add(2);
//        integers5.add(4);
//        integers5.add(7);
//        List<Integer> integers6 = adj[6];
//        integers6.add(4);
//        integers6.add(7);
//        List<Integer> integers7 = adj[7];
//        integers7.add(5);
//        integers7.add(6);
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先搜索
     *
     * @param s
     * @param t
     */
    private void bfs(int s, int t) {
        if (s == t) {
            return;
        }

        // 容器队列
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];
        visited[s] = true;
        int[] prev = new int[adj.length];
        Arrays.fill(prev, -1);

        queue.add(s);
        while (!queue.isEmpty()) {
            Integer element = queue.poll();

            for (int i = 0; i < adj[element].size(); i++) {
                List<Integer> integers = adj[element];
                Integer integer = integers.get(i);
                if (visited[integer]) {
                    continue;
                }
                prev[integer] = element;
                visited[integer] = true;
                if (integer == t) {
                    print(prev, s, t);
                    return;
                }
                queue.add(integer);
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);

        }
        System.out.print(t + " ");
    }

    /**
     * 深度优先搜索
     *
     * @param s
     * @param t
     */
    private void dfs(int s, int t) {

    }

    /**
     * 0-1-2
     * | | |
     * 3-4-5
     * | |
     * 6-7
     *
     * @param args
     */
    public static void main(String[] args) {
        // create a graph
        Graph graph = new Graph(8);
        graph.bfs(0, 6);
    }


}
