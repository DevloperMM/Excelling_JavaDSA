package $22_Graphs;

import java.util.ArrayList;

public class $3_undirected_cycles {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    public static int len = 0;
    
    //O(V+E): Since the approach is DFS based
    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i=0; i<graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                    //cycle can exist in one or more parts
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int parent) {
        vis[curr] = true;
        for (int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            //case-1
            if (vis[e.dest] && e.dest != parent) {
                len = e.dest - e.src + 1;
                return true;
            }
            //case-2: do nothing
            //case-3
            else if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr))
                    return true;
            }
        }

        return false;
    }

    public static boolean isBipartiteAlt() {
        //Return back after doing $4_bipartite_way1.java
        if (len == 0) {
            return true;
        } else if (len % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        /*             0 --- 3
         *           / |     |
         *          1  |     |
         *           \ |     |
         *             2     4
         */
        int v=5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);
        System.out.println(detectCycle(graph));
        System.out.println(isBipartiteAlt());
    }
}
