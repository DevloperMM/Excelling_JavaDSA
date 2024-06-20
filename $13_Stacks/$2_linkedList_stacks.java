package $13_Stacks;

public class $2_linkedList_stacks {
    static class Node {
        int data;
        Node next;
        
        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        static Node head = null;

        public boolean isEmpty() {
            return head == null;
        }

        //push
        public void push(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        //pop
        public int pop() {
            if (head == null) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }
        
        //peek
        public int peek() {
            if (head == null) {
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(4);
        s.push(6);
        s.push(23);

        //Printing Stack elements
        while (! s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
