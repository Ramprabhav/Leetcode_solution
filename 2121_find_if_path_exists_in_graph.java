import java.util.*;

class Solution {

    public static class Edge {
        int src;
        int dst;

        Edge(int s, int d) {
            this.src = s;
            this.dst = d;
        }
    }

    public boolean validPath(int n, int[][] edges, int src, int dst) {

        // Create graph
        ArrayList<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph[u].add(new Edge(u, v));
            graph[v].add(new Edge(v, u));
        }

        // BFS
        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[n];

        q.add(src);
        visited[src] = true;

        while (!q.isEmpty()) {

            int current = q.remove();

            if (current == dst) {
                return true;
            }

            for (Edge e : graph[current]) {

                int neighbor = e.dst;

                if (!visited[neighbor]) {

                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }

        return false;
    }
}