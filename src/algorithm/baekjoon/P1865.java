package algorithm.baekjoon;

import java.util.*;

/**
 * https://www.acmicpc.net/problem/1865
 */
public class P1865 {

    static class Edge {
        int from, to, cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    private static final int inf = 100000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

        while (c-- > 0) {
            int node = sc.nextInt();
            int way = sc.nextInt();
            int wormhole = sc.nextInt();
            List<Edge> edgeList = new ArrayList<>();
            for (int i = 0; i < way; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                int cost = sc.nextInt();
                edgeList.add(new Edge(from, to, cost));
                edgeList.add(new Edge(to, from, cost));
            }
            for (int i = 0; i < wormhole; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                int cost = sc.nextInt();
                edgeList.add(new Edge(from, to, -cost));
            }

            int[] bf = new int[node + 1];
            Arrays.fill(bf, inf);
            bf[1] = 0;

            boolean isCycle = false;
            for (int i = 1; i <= node; i++) {
                for (Edge edge : edgeList) {
                    int from = edge.from;
                    int to = edge.to;
                    int cost = edge.cost;
                    if (bf[to] > bf[from] + cost) {
                        bf[to] = bf[from] + cost;
                        if (i == node) {
                            isCycle = true;
                        }
                    }
                }
            }
            System.out.println(isCycle ? "YES" : "NO");
        }
    }
}
