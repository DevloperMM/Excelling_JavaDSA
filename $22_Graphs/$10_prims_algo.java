package $22_Graphs;
import java.util.*;

public class $10_prims_algo {
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

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    static class Pair implements Comparable<Pair> {
        int v;
        int par; //parent
        int cost;

        public Pair(int v, int p, int c) {
            this.v = v;
            this.cost = c;
            this.par = p;
        }

        @Override
        public int compareTo(Pair p) {
            return this.cost - p.cost; //ascending
        }
    }


    public static void prims(ArrayList<Edge> graph[]) { //O([V+E]*logV)
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, -1, 0));

        int finalCost = 0; //MST Cost or total min weight
        ArrayList<Edge> mstEdges = new ArrayList<>();

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;

                finalCost += curr.cost;
                if (curr.par != -1) { //Ignore starting vertex as no cost to reach that
                    mstEdges.add(new Edge(curr.par, curr.v, curr.cost));
                }

                for (int i=0; i<graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    if (!vis[e.dest]) {
                        pq.add(new Pair(e.dest, curr.v, e.wt));
                    }
                }

            }
        }

        System.out.println("Total Cost = " + finalCost);
        System.out.println("Edges in MST:");
        for (Edge e : mstEdges) {
            System.out.println(e.src + " - " + e.dest + " : " + e.wt);
        }
    }

    public static void main(String[] args) {
        int v=4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        prims(graph);
    }
}
