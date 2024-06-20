package $14_Queues;

public class $3_linkedList_queues {
    static class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node tail = null;

        // No need for isFull -> LinkedList has no fixed size

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        //Add
        public static void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        //Remove
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Empty Queue!!");
                return -1;
            }
            int front = head.data;
            if (tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return front;
        }

        //Peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty Queue!!");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Queue.add(1);
        Queue.add(2);
        Queue.add(3);

        while (!Queue.isEmpty()) {
            System.out.println(Queue.peek());
            Queue.remove();
        }
    }
}
