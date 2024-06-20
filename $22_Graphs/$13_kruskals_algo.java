package $22_Graphs;
import java.util.*;

public class $13_kruskals_algo {
// ---------------------------------------------------------------------------------------
 // Disjoint Set DS
    static int n = 4;
    static int parent[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        
        if (rank[parA] < rank[parB]) {
            parent[parA] = parB;
        }
        else if (rank[parA] > rank[parB]) {
            parent[parB] = parA;
        }
        else {
            parent[parB] = parA;
            rank[parA]++;
        }
    }
// ---------------------------------------------------------------------------------------
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e) {
            return this.wt - e.wt;
        }
    }

    public static void createGraph(ArrayList<Edge> edges) {
        //edges
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 50));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 15));
    }

    public static void kruskals(ArrayList<Edge> edges, int v) { //O(V+E*logE)
        init(); //This command just sets UnionFind DS

        Collections.sort(edges); //O(E*logE)
        int mstCost = 0;
        int count = 0;
        ArrayList<Edge> mstEdges = new ArrayList<>();

        for (int i=0; count < v-1; i++) { //O(V)
            Edge e = edges.get(i);
            //Edges are sorted, hence MST has minimum cost

            int parA = find(e.src);
            int parB = find(e.dest);
            if (parA != parB) {
                union(e.src, e.dest);
                mstCost += e.wt;
                mstEdges.add(e);
                count++;
            }
        }

        System.out.println("Min cost is = " + mstCost);
        for (int i=0; i<mstEdges.size(); i++) {
            Edge e = mstEdges.get(i);
            System.out.println(e.src + " - " + e.dest + " : " + e.wt);
        }
    }

    public static void main(String[] args) {
        // init();
        // union(1, 3);
        // System.out.println(find(3));
        // union(2, 4);
        // System.out.println(find(4));
        // union(3, 6);
        // union(1, 4);
        // System.out.println(find(3));
        // System.out.println(find(4));
        // union(1, 5);

        int v = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskals(edges, v);
    }
}
