package $17_BST;

public class $1_implementation {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
// --------------------------------------------------
    public static Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        //insert in left subtree
        if (value < root.data) {
            Node node = insert(root.left, value);
            root.left = node;
        }
        //insert in right subtree
        else if (value > root.data) {
            root.right = insert(root.right, value);
        }
        
        return root;
    }
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
// -----------------------------------------------------
    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (key == root.data) {
            return true;
        }
        
        if (key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }

    }
// ----------------------------------------------------
    public static Node delete(Node root, int val) {
        if (val > root.data) {
            root.right = delete(root.right, val);
        }
        else if (val < root.data) {
            root.left = delete(root.left, val);
        }
        else { //voila

            //case-1: Leaf Node
            if (root.left == null && root.right == null) {
                return null;
            }

            //case-1: Single Child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case-3: Both Children
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data; //value replaced with IS
            root.right = delete(root.right, IS.data);
                //IS deleted which exist in right subtree
                //It is returning the tree with deleted node to root.right

        }

        return root;
    }
    public static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
// --------------------------------------------
    public static void main(String[] args) {
        /*          8
         *         / \
         *        5   10
         *       / \    \
         *      3   6    11
         *     / \         \
         *    1   4         14
         */

        Node root = null;
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};


        for (int i=0; i<values.length; i++) {
            root = insert(root, values[i]);
        }
        inOrder(root); System.out.println();


        if (search(root, 6)) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }


        root = delete(root, 5);
        inOrder(root); System.out.println();
    }
}
