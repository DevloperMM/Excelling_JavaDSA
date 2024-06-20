package $22_Graphs;
import java.util.*;

public class $6_topological_sort {
    static class Edge {
        int src;
        int dest;

        Edge (int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topoSort(ArrayList<Edge> graph[]) { //O(V+E)
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i=0; i<graph.length; i++) {
            if (!vis[i]) {
                topoSortUtil(graph, i, vis, s); //modified dfs
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }

    public static void topoSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for (int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topoSortUtil(graph, e.dest, vis, s);
            }
        }

        s.push(curr);
    }

    public static void calcInDegree(ArrayList<Edge> graph[], int inDegree[]) {
        for (int i=0; i<graph.length; i++) {
            for (int j=0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                inDegree[e.dest]++;
            }
        }
    }
    
    public static void kahnAlgo(ArrayList<Edge> graph[]) {
        int inDegree[] = new int[graph.length];
        calcInDegree(graph, inDegree);
        Queue<Integer> q = new LinkedList<>();

        for (int i=0; i<inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        //bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDegree[e.dest]--;
                if (inDegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int v=6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);
        topoSort(graph);
        kahnAlgo(graph);
    }
}
