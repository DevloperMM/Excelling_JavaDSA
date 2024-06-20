package $18_Heaps;

import java.util.PriorityQueue;

public class $6_weakest_soldier {
    static class row implements Comparable<row> {
        int s_no;
        int soldiers;
        
        public row(int s_no, int soldiers) {
            this.s_no = s_no;
            this.soldiers = soldiers;
        }

        @Override
        public int compareTo(row r) {
            if (this.soldiers == r.soldiers) {
                return this.s_no - r.s_no;
            }
            return this.soldiers - r.soldiers;
        }
    }
    public static void main(String[] args) {
        int army[][] = {{1,0,0,0},
                        {1,1,1,1},
                        {1,1,0,0},
                        {1,0,0,0},
                        {1,0,0,0}};
        int K = 2;

        PriorityQueue<row> pq = new PriorityQueue<>();
        for (int i=0; i<army.length; i++) {
            int count = 0;
            for (int j=0; j<army[i].length; j++) {
                // count += army[i][j];
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new row(i, count));
        }

        for (int k=0; k<K; k++) {
            System.out.println("R" + pq.remove().s_no);
        }
    }
}
