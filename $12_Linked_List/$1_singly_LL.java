package $12_Linked_List;

public class $1_singly_LL {
    public static class Node {
        int data;
        Node next; //the data type of 'next' is the address of some object of this class

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size; //Java initialize it as 0 by default


    //Adding element in the Linked List
    public void addFirst(int data) {
        //step-1 : create new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //step-2 : newNode's head = next
        newNode.next = head; //link
        //step-3 : update head
        head = newNode;
    }
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < idx-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    
    // Printing the Linked list
    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }


    // Removing element from the linked list
    public int removeFirst() {
        if (size == 0) {
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    public int removeLast() {
        if (size == 0) {
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        //prev : i = size-2
        Node prev = head;
        for (int i=0; i<size-2; i++) { //size can be used directly bcoz of being static
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }


    // Finding index of any element of the linked list
    public int iterSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        //key not found
        return -1;
    }
    public int recSearch(Node head, int key, int i) {
        //return helper(head, key);
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return i;
        }
        int idx = recSearch(head.next, key, i+1);
        return idx;
    }
    // public int helper(Node head, int key) {
    //     if (head == null) {
    //         return -1;
    //     }
    //     if (head.data == key) {
    //         return 0;
    //     }
    //     int idx = helper(head.next, key);
    //     if (idx == -1) {
    //         return -1;
    //     }
    //     return idx+1;
    // }

    
    // Reversing the linked list
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }


    // Deleting Nth element from the linked list
    public void delNthFromEnd(int n) {
        //calculate size
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            sz++;
            temp = temp.next;
        }

        if (n == sz) {
            head = head.next;
            return;
        }

        int i=1;
        int iToFind = sz-n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }


    // Finding mid node w.r.t checking palindrome
    public Node midNode(Node head) {
        //Slow Fast approach
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }

        return slow;
    }
    public boolean chkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        //step-1 : find mid
        Node mid = midNode(head);

        //step-2 : reverse 2nd Half
        Node prev = null;
        Node curr = mid;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node rightHead = prev; //basically the tail of linked list
        Node leftHead = head; //head of the linked list

        //step-3 : check 1st and 2nd Half equality
        while(rightHead != null) {
            if (leftHead.data != rightHead.data) {
                return false;
            }
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }
        return true;
    }


    //Detecting cycle in the linked list
    public static boolean isCycle() { //private can also be used bcoz of same class
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }


    //Removing cycle from the linked list
    public static void removeCycle() {
        //detect cycle
        Node slow = head;
        Node track = slow; //This track is made to cater the corner case
        Node fast = head;
        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
            // When cycle will be found it breaks without updating the prev which we want
            track = slow;
        }

        if (cycle == false)  {
            return;
        }

        if (track.next != head) {
            //find meeting point
            slow = head;
            Node prev = null;
            while (slow != fast) {
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }
            //remove cylce - last.next = null
            prev.next = null;
        }
        //Actually in this case it become a circular linked list
        else {
            track.next = null;
        }
    }


    //Finding mid node w.r.t merge sort
    public Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow;
    }
    public Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            } else {
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
            temp = temp.next;
            head1 = head1.next;
        }
        while (head2 != null) {
            temp.next = head2;
            temp = temp.next;
            head2 = head2.next;
        }

        return mergedLL.next;
    }
    public Node mergeSort(Node head) {
        //base case
        if (head == null || head.next == null) {
            return head;
        }

        //find mid
        Node mid = getMid(head);
        
        //left & right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft, newRight);
    }


    //Print linked list in zigZag fashion
    public void zigZag(Node head) {
        //find mid node
        Node mid = getMid(head);

        //reverse 2nd half
        Node prev = null;
        Node curr = mid.next;
        mid.next = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //alternate merging
        Node LH = head;
        Node RH = prev;
        Node nextL, nextR;
        while (LH != null && RH != null) {
            //zig-zag
            nextL = LH.next;
            LH.next = RH;
            nextR = RH.next;
            RH.next = nextL;
            //update
            LH = nextL;
            RH = nextR;
        }
    }
    
    public static void main(String[] args) {
        $1_singly_LL ll = new $1_singly_LL();
        ll.addFirst(1);
        ll.addFirst(10);
        ll.addLast(3);
        ll.addLast(4);
        ll.add(2, 9);
        ll.printLL();

        // System.out.println(ll.removeFirst() + " is Removed");
        // System.out.println(ll.removeLast() + " is Removed");
        // ll.printLL();

        // System.out.println(ll.iterSearch(9));
        // System.out.println(ll.iterSearch(10));

        // System.out.println(ll.recSearch(head, 3, 0));
        // System.out.println(ll.recSearch(head, 15, 0));

        // ll.reverse();
        // ll.printLL();

        // ll.delNthFromEnd(1);
        // ll.printLL();

        /* Remember there can be called only one LinkedList in the main function when
        we have static head and tail as all the functions are written w.r.t them only. */
        // LinkedList_1 ll = new LinkedList_1();
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(2);
        // ll.addLast(1);
        // ll.printLL();
        // System.out.println(ll.chkPalindrome());

        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp; //First traverse LL then assign name.
        // head.next.next = new Node(3);
        // head.next.next.next = temp;

        // System.out.println(ll.isCycle()); // -> where LL is the object of the LinkedList
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        // ll.head = ll.mergeSort(ll.head);
        // ll.printLL();

        ll.zigZag(head);
        ll.printLL();
    }
}