package $17_BST;

import java.util.ArrayList;

public class $2_application {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
// -----------------------------------------
    //Tree Traversal
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
// -----------------------------------------
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        //lies in both left and right subtree
        if (root.data >= k1 && root.data <= k2) {
            //inOrder Sequence
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }
        //lies only in left subtree
        else if (root.data > k2) {
            printInRange(root.left, k1, k2);
        }
        else {
            printInRange(root.right, k1, k2);
        }
    }
// ---------------------------------------------
    public static void printPath(ArrayList<Integer> path) {
        for (int i=0; i<path.size(); i++) {
            System.out.print(path.get(i)+" -> ");
        }
        System.out.println("Null");
    }
    public static void root2LeafPath(Node root, ArrayList<Integer> path) {

        if (root == null) {
            return;
        }

        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
        }

        root2LeafPath(root.left, path);
        root2LeafPath(root.right, path);
        path.remove(path.size()-1);
    }
// -------------------------------------------
    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {
            return false;
        }
        else if (max != null && root.data >= max.data) {
            return false;
        }
        // I can also take the OR of both these condn and false will be returned

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
// -------------------------------------------
    public static Node mirrorTree(Node root) {
        if (root == null) {
            return null;
        }

        Node L_mirror = mirrorTree(root.left);
        Node R_mirror = mirrorTree(root.right);

        root.left = R_mirror;
        root.right = L_mirror;

        return root;
    }
// ---------------------------------------------
    public static void main(String[] args) {
        /*           6
         *         /   \
         *        4     8
         *       / \   / \
         *      2   5 7   10
         */
        Node root = new Node(6);
        root.left = new Node(4);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(10);


        int k1 = 5, k2 = 12;
        printInRange(root, k1, k2);

        
        System.out.println();
        root2LeafPath(root, new ArrayList<>());


        if (isValidBST(root, null, null)) {
            System.out.println("Valid BST");
        } else {
            System.out.println("InValid BST");
        }


        /*           6
         *         /   \
         *        8     4
         *       / \   / \
         *     10   7 5   2
         */
        root = mirrorTree(root);
        preOrder(root); System.out.println();
    }
}
