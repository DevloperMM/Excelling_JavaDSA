package $14_Queues;

public class $1_array_queues {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        //We Have not stored front as it is fixed at arr[0]

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        //isEmpty
        public static boolean isEmpty() {
            return rear == -1;
        }

        //Add
        public static void add(int data) {
            //Checking isFull
            if (rear == size-1) {
                System.err.println("Size exceeding!!");
                return;
            }
            rear = rear + 1;
            arr[rear] = data;
            return;
        }

        //Remove
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Empty queue!!");
                return -1;
            }
            int front = arr[0];
            for (int i=0; i<=rear-1; i++) {
                arr[i] = arr[i+1];
            }
            rear = rear - 1;
            return front;
        }

        //peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Null");
                return -1;
            }
            return arr[0];
        }
    }
    public static void main(String[] args) {
        new Queue(4);

        Queue.add(1);
        Queue.add(2);
        Queue.add(3);
        Queue.add(4);

        while (! Queue.isEmpty()) {
            System.out.println(Queue.peek());
            Queue.remove();
        }
    }
}