package $17_BST;

import java.util.ArrayList;

public class $3_problems {
    static class Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public static void getInorder(Node root, ArrayList<Integer> seq) {
        if (root == null) {
            return;
        }
        
        getInorder(root.left, seq);
        seq.add(root.data);
        getInorder(root.right, seq);
    }
// --------------------------------------------
    public static Node createBST(int arr[], int si, int ei) {
        if (si > ei) {
            return null;
        }
        int mid = (si+ei)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, si, mid-1);
        root.right = createBST(arr, mid+1, ei);
        return root;
    }
// -------------------------------------------
    public static Node balancedBST(Node root) {
        //inorder seq
        ArrayList<Integer> seq = new ArrayList<>();
        getInorder(root, seq);
        
        //sorted array => balancedBST
        root = formBST(seq, 0, seq.size()-1);
        
        return root;
    }
    public static Node formBST(ArrayList<Integer> seq, int si, int ei) {
        if (si > ei) {
            return null;
        }
        int mid = (si+ei)/2;
        Node root = new Node(seq.get(mid));
        root.left = formBST(seq, si, mid-1);
        root.right = formBST(seq, mid+1, ei);
        return root;
    }
// -------------------------------------------
    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBSTsize = 0;
    public static Node maxBSTroot = null;

    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }

        if (leftInfo.isBST && rightInfo.isBST) {
            if (size > maxBSTsize) {
                maxBSTsize = size;
                maxBSTroot = root;
            }
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }
// -------------------------------------------\
    public static Node mergerBSTs(Node root1, Node root2) {
        //step1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        //step2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        //step3
        int i=0, j=0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while (i<arr1.size() && j<arr2.size()) {
            if (arr1.get(i) < arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        while (i<arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }
        while (j<arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }

        //step4 : sorted AL => balanced BST
        return arrToBST(finalArr, 0, finalArr.size()-1);
    }
    public static Node arrToBST(ArrayList<Integer> arr, int si, int ei) {
        if (si>ei) {
            return null;
        }
        int mid = (si+ei)/2;
        Node root = new Node(arr.get(mid));
        root.left = arrToBST(arr, si, mid-1);
        root.right = arrToBST(arr, mid+1, ei);
        return root;
    }
// -------------------------------------------
    public static void main(String[] args) {
    // ---------------------------------------
        int arr[] = {3,5,6,8,10,11,12};
        /*           8
         *         /   \
         *        5    11
         *       / \   / \
         *      3   6 10  12
         *      Expected BST
         */
        Node rootA = createBST(arr, 0, arr.length-1);
        preOrder(rootA); System.out.println();

    // ---------------------------------------
        /*          8
         *         / \
         *        7   10
         *       /      \
         *      6       11
         *     /          \  
         *    3           12
         *      Given BST
         */
        Node rootB = new Node(8);
        rootB.left = new Node(7);
        rootB.left.left = new Node(6);
        rootB.left.left.left = new Node(3);
        rootB.right = new Node(10);
        rootB.right.right = new Node(11);
        rootB.right.right.right = new Node(12);
        /*           8
         *         /   \
         *        5    11
         *       / \   / \
         *      3   6 10  12
         *      Expected BST
         */
        rootB = balancedBST(rootB);
        preOrder(rootB); System.out.println();
    // ---------------------------------------
        /*           50
         *         /    \
         *        30     60
         *       / \     / \
         *      5  20   45  70
         *                  / \  
         *                 65  80
         *      Given BT
         */
        Node rootC = new Node(50);
        rootC.left = new Node(30);
        rootC.left.left = new Node(5);
        rootC.left.right = new Node(20);
        rootC.right = new Node(60);
        rootC.right.left = new Node(45);
        rootC.right.right = new Node(70);
        rootC.right.right.left = new Node(65);
        rootC.right.right.right = new Node(80);
        // Node rootC = new Node(50);
        // rootC.left = new Node(60);
        // rootC.left.left = new Node(45);
        // rootC.left.right = new Node(70);
        // rootC.left.right.left = new Node(65);
        // rootC.left.right.right = new Node(80);
        // rootC.right = new Node(30);
        // rootC.right.left = new Node(10);
        // rootC.right.right = new Node(40);
        
         /*           60
         *           /  \
         *          45   70
         *               / \  
         *              65  80
         *   expected BST : maxSize = 5
         */
        largestBST(rootC);
        System.out.println("Largest BST size = " + maxBSTsize);
        preOrder(maxBSTroot); System.out.println();
    // ---------------------------------------
        /*          2
         *         / \
         *        1   4
         *        BST-1
         */
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);
        /*          9
         *         / \
         *        3   12
         *        BST-1
         */
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);
        /*           3
         *         /   \
         *        1      9
         *         \    / \
         *          2  4  12
         *        Expected BST
         */
        Node rootD = mergerBSTs(root1, root2);
        preOrder(rootD); System.out.println();
    }
}
