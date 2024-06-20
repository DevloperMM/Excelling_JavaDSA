package $22_Graphs;
import java.util.*;

public class $4_bipartite_way1 {
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

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    public static boolean isBipartite(ArrayList<Edge> graph[]) { //O(V+E)
        int col[] = new int[graph.length];
        for (int i=0; i<col.length; i++) {
            col[i] = -1; //no colour
        }

        for (int i=0; i<graph.length; i++) {
            if (!isBipartiteUtil(graph, col, i)) {
                return false;
            }

            // Don't want Util fn -> Remove if condition & write whole Util fn content
        }

        return true;
    }

    public static boolean isBipartiteUtil(ArrayList<Edge> graph[], int col[], int i) {
        Queue<Integer> q = new LinkedList<>();

        if (col[i] == -1) {
            q.add(i);
            col[i] = 0; //yellow
            while (!q.isEmpty()) {
                int curr = q.remove();
                for (int j=0; j<graph[curr].size(); j++) {
                    Edge e = graph[curr].get(j); //neighbour = e.dest
                    //case-3
                    if (col[e.dest] == -1) {
                        int nextCol = col[curr] == 0 ? 1 : 0;
                        col[e.dest] = nextCol;
                        q.add(e.dest);
                    }
                    //case-1
                    else if (col[e.dest] == col[curr]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        /*          0
         *        /   \
         *       /     \
         *      /       \
         *     1         2
         *      \       /
         *       3 --- 4
         */

        int v=7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);
        System.out.println(isBipartite(graph));
    }
}
