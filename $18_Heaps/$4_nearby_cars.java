package $18_Heaps;

import java.util.PriorityQueue;

public class $4_nearby_cars {
    static class Point implements Comparable<Point> {
        int s_no;
        int x;
        int y;
        int distSq; //square of distance from origin

        public Point(int s_no, int x, int y, int distSq) {
            this.s_no = s_no;
            this.x = x;
            this.y = y;
            this.distSq = distSq;
        }

        @Override
        public int compareTo(Point pt) {
            return this.distSq - pt.distSq;
        }
    }
    public static void main(String[] args) {
        int pts[][] = {{3,3}, {5,-1}, {-2,4}};
        int K = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i=0; i<pts.length; i++) {
            int sqDist = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
            pq.add(new Point(i, pts[i][0], pts[i][1], sqDist));
        }

        //nearest k cars
        for (int k=1; k<=K; k++) {
            System.out.println("C"+pq.remove().s_no);
        }
    }
}
