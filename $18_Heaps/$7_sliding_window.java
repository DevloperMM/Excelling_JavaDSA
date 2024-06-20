package $18_Heaps;

import java.util.PriorityQueue;

public class $7_sliding_window {
    static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p) {
            //ascending
            // return this.val - p.val;
            //descending
            return p.val - this.val;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int K=3;
        int res[] = new int[(arr.length)-(K-1)];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        //1st window
        for (int i=0; i<=K; i++) {
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().val;
        for (int i=K; i<arr.length; i++) {
            while (pq.size() > 0 && pq.peek().idx <= (i-K)) {
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));
            res[i-K+1] = pq.peek().val;
        }
        
        //print result
        for (int i=0; i<res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
