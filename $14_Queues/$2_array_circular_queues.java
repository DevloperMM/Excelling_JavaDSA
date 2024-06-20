package $14_Queues;

public class $2_array_circular_queues {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public boolean isFull() {
            return ((rear + 1) % size) == front;
        }

        //Add
        public void add(int data) {
            if (isFull()) {
                System.err.println("Size exceeding!!");
                return;
            }

            //first element
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
            //I am updating rear here because rear is representing the last element and in queues all the elements are added at the last position
            return;
        }

        //Remove
        public int remove() {
            if (isEmpty()) {
                System.out.println("Empty Queue!!");
                return -1;
            }

            int result = arr[front];
            //last element
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
                //While removing it is clear in the queue that always first element is removed that is why we are updating the front
            }
            return result;
        }

        //peek
        public int peek() {
            if (isEmpty()) {
                System.out.println("Empty Queue!!");
                return -1;
            }
            return arr[front];
        }
    }
    public static void main(String[] args) {     
        Queue q = new Queue(4);

        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();
        q.add(4);
        q.remove();
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
         
        /* We are here able to use the class directly as object because of static definitions */
    }
}
