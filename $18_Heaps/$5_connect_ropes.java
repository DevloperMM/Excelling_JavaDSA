package $18_Heaps;

import java.util.PriorityQueue;

public class $5_connect_ropes {
    public static void main(String[] args) {
        // int ropes[] = {4,3,2,6};
        int ropes[] = {2,3,3,4,6};
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;
        while (pq.size() > 1) {
            int min1 = pq.remove();
            int min2 = pq.remove();
            int sum = min1 + min2;
            pq.add(sum);
            cost += sum;
        }

        System.out.println("Cost of Connecting N ropes = " + cost);
    }
}
