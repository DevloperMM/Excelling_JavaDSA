package $16_Binary_Trees;

public class $2_helper_functions {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        
        int lh = height(root.left);
        int rh = height(root.right);
        int h = Math.max(lh, rh) + 1;

        return h;
    }

    public static int count(Node root) {
        if (root == null) {
            return 0;
        }

        int leftCount = count(root.left);
        int rightCount = count(root.right);
        //int totalCount = leftCount + rightCount + 1;

        return leftCount + rightCount + 1;
    }

    public static int sum(Node root) { //O(N)
        if (root == null) {
            return 0;
        }

        int leftChildSum = sum(root.left);
        int rightChildSum = sum(root.right);
        //int treeSum = root.data + leftChildSum + rightChildSum;

        return root.data + leftChildSum + rightChildSum;
    }

    public static int diameter2(Node root) { //O(N^2)
        if (root == null) {
            return 0;
        }

        int ld = diameter2(root.left);
        int rd = diameter2(root.right);

        int lh = height(root.left);
        int rh = height(root.right);
        int self = lh + rh + 1;

        return Math.max(self, Math.max(ld, rd));
        //This is done bcoz max fn can compare only two at a time
    }

    static class Info {
        int dia;
        int ht;

        public Info(int dia, int ht) {
            this.dia = dia;
            this.ht = ht;
        }
    }
    public static Info diameter(Node root) { //O(N)
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int selfDia = Math.max(Math.max(leftInfo.dia, rightInfo.dia), leftInfo.ht + rightInfo.ht + 1);
        int selfHt = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(selfDia, selfHt);
        //an object of Info class is returned
    }

    public static boolean isIdentical(Node treeNode , Node subRoot) {
        if (treeNode == null && subRoot == null) {
            return true;
        } else if (treeNode == null || subRoot == null || treeNode.data != subRoot.data) {
            return false;
        }

        if (! isIdentical(treeNode.left, subRoot.left)) {
            return false;
        }
        if (! isIdentical(treeNode.right, subRoot.right)) {
            return false;
        }
        
        return true;
    }
    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }

        // First i check the node value is same, if it does i checked for structure
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        // boolean leftAns = isSubtree(root.left, subRoot);
        // boolean rightAns = isSubtree(root.right, subRoot);
        // return leftAns || rightAns;
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        //This way is more optimized as it will not check right if i get true from left
    }

    public static void main(String[] args) {
        /* 
         *          1
         *         / \
         *        2   3
         *       / \ / \
         *      4  5 6  7
         *     /
         *    8
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);


        System.out.println("Height of tree = " + height(root));
        System.out.println("Count of Nodes = " + count(root));
        System.out.println("Sum of Nodes = " + sum(root));
        System.out.println("Diameter of tree (M-1) = " + diameter2(root));
        System.out.println("Diameter of tree (M-2) = " + diameter(root).dia);
        System.out.println("Height of tree = " + diameter(root).ht);


        /* 
         *              2
         *             / \
         *            4   5
         *           /
         *          8
         */

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(7);
        subRoot.left.left = new Node(8);

        System.out.println(isSubtree(root, subRoot)); 
    }
}
