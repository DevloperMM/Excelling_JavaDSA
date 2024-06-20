package $22_Graphs;
import java.util.*;

public class $2_traversal_ways {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
            this.wt = 1;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));        

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    public static void bfs(ArrayList<Edge> graph[]) { //O(V+E)
        boolean vis[] = new boolean[graph.length];
        for (int i=0; i<graph.length; i++) {
            if (!vis[i]) {
                bfsUtil(graph, i, vis);
            }
        }
    }
    public static void bfsUtil(ArrayList<Edge> graph[], int node, boolean vis[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node); //source = 0

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                vis[curr] = true;
                System.out.print(curr + " ");
                for (int i=0; i<graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[]) { //O(V+E)
        boolean vis[] = new boolean[graph.length];
        for (int i=0; i<graph.length; i++) {
            if (!vis[i]) {
                dfsUtil(graph, i, vis);
            }
        }
    }
    public static void dfsUtil(ArrayList<Edge> graph[], int curr, boolean[] vis) {
        //visit
        vis[curr] = true;
        System.out.print(curr + " ");

        for (int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    //O(V+E)
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
        if (src == dest) {
            return true;
        }

        vis[src] = true;
        for (int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            //e.dest --> neighbour
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        /* 
         *          1 ---- 3
         *         /       | \
         *        0        |  5 -- 6
         *         \       | /
         *          2 ---- 4
         */

        int v = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);

        bfs(graph); System.out.println();
        dfs(graph); System.out.println();

        System.out.println(hasPath(graph, 5, 6, new boolean[v]));
    }
}
