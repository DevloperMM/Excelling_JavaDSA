package $18_Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class $1_PriorityQ_JCF {
    static class Student implements Comparable<Student> { 
        //Comparable has compareTo fn which needs to be implemented by fn over-riding.
        String name;
        int rank;

        public Student(String nm, int rk) {
            this.name = nm;
            this.rank = rk;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // By default w/o any constructor, priotity is given to lowest number.

        pq.add(new Student("A", 4)); //O(logn)
        pq.add(new Student("B", 1));
        pq.add(new Student("C", 9));
        pq.add(new Student("D", 2));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + " -> " + pq.peek().rank);
            pq.remove();
        }
    }
}
