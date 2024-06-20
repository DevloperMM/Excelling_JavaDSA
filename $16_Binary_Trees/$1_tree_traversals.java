package $16_Binary_Trees;

import java.util.*;

public class $1_tree_traversals {
    static class Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) { //O(N)
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes); //to build left subtree with or w/o branches
            newNode.right = buildTree(nodes); //to build right subtree

            return newNode;
        }

        public static void preOrder(Node root) { // O(N)
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root) { // O(N)
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void postOrder(Node root) { // O(N)
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        //Level Order Traversal
        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        // BinaryTree tree = new BinaryTree();
        Node root = BinaryTree.buildTree(nodes);
        //Tree can also be build using object of Binary Tree i.e. tree

        System.out.println("Root of tree = " + root.data);

        System.out.print("PreOrder of tree = ");
        BinaryTree.preOrder(root);
        System.out.println();

        System.out.print("InOrder of tree = ");
        BinaryTree.inOrder(root);
        System.out.println();

        System.out.print("PostOrder of tree = ");
        BinaryTree.postOrder(root);
        System.out.println();

        System.out.println("Level Order is : ");
        BinaryTree.levelOrder(root);
    }
}
