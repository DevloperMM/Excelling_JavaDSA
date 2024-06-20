package $22_Graphs;
import java.util.*;

public class $8_dijkstras_algo {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 5, 5));
        graph[4].add(new Edge(4, 3, 2));
    }

    static class Pair implements Comparable<Pair> {
        int v; //vertex
        int path;

        public Pair(int n, int path) {
            this.v = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p) {
            return this.path - p.path; //path based sorting for my pairs
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[], int src) { //O(V+E*logV)
        int dist[] = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                for (int j=0; j<graph[curr.v].size(); j++) {
                    Edge e = graph[curr.v].get(j);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] + wt < dist[v]) { //updated distance from src to v
                        dist[v] = wt + dist[u];
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        //print all source to vertices shortest path
        for (int i=0; i<dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int v=6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        
        createGraph(graph);
        int src = 1;
        dijkstra(graph, src);
    }
}
