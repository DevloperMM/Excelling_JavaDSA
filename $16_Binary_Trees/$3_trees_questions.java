package $16_Binary_Trees;

import java.util.*;

public class $3_trees_questions {
// ---------------------
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
// --------------------------
    //Print Top View of Tree
    static class TopInfo {
        Node node;
        int horzDist;

        public TopInfo(Node node, int dist) {
            this.node = node;
            this.horzDist = dist;
        }
    }

    public static void topView(Node root) {
        //Level Order traversal
        Queue<TopInfo> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new TopInfo(root, 0));
        q.add(null);

        while (! q.isEmpty()) {
            TopInfo curr = q.remove();

            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                // key = curr.hd;
                // value = curr.node;
                if (! map.containsKey(curr.horzDist)) { //first time my hd is occuring
                    map.put(curr.horzDist, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new TopInfo(curr.node.left, curr.horzDist-1));
                    min = Math.min(min, curr.horzDist-1);
                }
                if (curr.node.right != null) {
                    q.add(new TopInfo(curr.node.right, curr.horzDist+1));
                    max = Math.max(max, curr.horzDist+1);
                }
            }
        }

        for (int i=min; i<=max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }
// -------------------------------
    //Print Bottom View of Tree
    static class BottomInfo {
        Node node;
        int hd;

        public BottomInfo (Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    //My Approach => Write Code whenever become able to write
    // public static int inOrder(Node root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     int left = inOrder(root.left);
    //     int right = inOrder(root.right);
    // }
    // public static void bottomView(Node root) {
    //     //traverse inOrder
    //     //add it's hd and node in map if not exist in map
    // }

    //GFG Approach
    static void printBottomView(Node root) {
        if (root == null) {
            return;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<BottomInfo> q = new ArrayDeque<>();

        int min = 0;
        q.add(new BottomInfo(root, 0));

        while (!q.isEmpty()) {
            BottomInfo top = q.remove();

            Node curr = top.node;
            int dist = top.hd;

            map.put(dist, curr.data);
            min = Math.min(dist, min);
        
            if (curr.left != null) {
                q.add(new BottomInfo(curr.left, dist - 1));
            } 
            if (curr.right != null) {
                q.add(new BottomInfo(curr.right, dist + 1));
            }
        }
        
        while (map.containsKey(min)) {
            System.out.print(map.get(min) + " ");
            min++;
        }
    }
// -------------------------------------------
    //Print the values of tree at Kth level
    //Iterative Approach
    public static void KLevel(Node root, int k) {
        if (root == null) {
            System.out.println("Empty tree!");
            return;
        }

        Queue<Node> q = new LinkedList<>();
        int level = 1;
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            
            if (currNode != null) {
                if (level == k) {
                    System.out.print(currNode.data + " ");
                }
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
            
            else if (! q.isEmpty()) {
                q.add(null);
                level++;
            }
        }
        
        System.out.println();
    }

    //Recursive Approach
    public static void KLevel(Node root, int lvl, int k) { //O(N)
        if (root == null) {
            return;
        }
        if (lvl == k) {
            System.out.print(root.data + " ");
            return;
        }

        KLevel(root.left, lvl+1, k);
        KLevel(root.right, lvl+1, k);
    }
// --------------------------------
    //Find Lowest Common Ancestor
    //Approach-1
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }

        path.add(root);
        
        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }
    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        boolean p1 = getPath(root, n1, path1);
        boolean p2 = getPath(root, n2, path2);

        //Last Common Ancestor
        if (p1 && p2) {
            int i=0;
            while (i<path1.size() && i<path2.size()) {
                if (path1.get(i) != path2.get(i)) {
                    break;
                }
                i++;
            }

            //last equal node -> (i-1)th
            Node lca = path1.get(i-1); //or path2.get(i-1)

            return lca;
        }
        return null;
    }

    //Approach2
    public static Node lca2(Node root, int n1, int n2) {

        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        //leftLca = valid and rightLca = null or vice-versa
        if (rightLca == null) {
            return leftLca;
        }
        if (leftLca == null) {
            return rightLca;
        }

        return root;
    }
// ------------------------------------
    //Minimum Distance between nodes
    public static int distFromLca(Node node, int n) {
        if (node == null) {
            return -1;
        }

        if (node.data == n) {
            return 0;
        }

        int left = distFromLca(node.left, n);
        int right = distFromLca(node.right, n);

        if (left == -1 && right == -1) {
            return -1;
        } else if (left == -1) {
            return right+1;
        } else {
            return left+1;
        }
    }
    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = distFromLca(lca, n1);
        int dist2 = distFromLca(lca, n2);

        return dist1 + dist2;
    }
// ------------------------------
    //find Kth Ancestor
    public static int KAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int leftTree = KAncestor(root.left, n, k);
        int rightTree = KAncestor(root.right, n, k);

        if (leftTree == -1 && rightTree == -1) {
            return -1;
        }

        //This assumes no duplicates exist in tree
        int max = Math.max(rightTree, leftTree);

        if (max+1 == k) {
            // it is printing the Kth ancestor
            System.out.println(root.data);
        }

        //it is returning the ancestor less than k in case not the Kth ancestor
        return max+1;
    }
// -----------------------------------------
    //Transform the tree to the corresponding sum of left and right subtree
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static int transform(Node root) {
        if (root == null) {
            return 0;
        }

        int lc = transform(root.left);
        int rc = transform(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;
        root.data = (newLeft + lc) + (newRight + rc);

        return data;
    }
// -----------------------------------------
    public static void main(String[] args) {
        /* 
         *          1
         *         / \
         *        2   3
         *       / \ / \
         *      4  5 6  7
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        // topView(root);
        // printBottomView(root);

        // int K=2;
        // KLevel(root, K);
        // KLevel(root, 1, K);
        // System.out.println();


        // int n1 = 4, n2 = 2;
        //Caters if any one or both node do no exist in tree
        // System.out.println("LCA : " + (lca(root, n1, n2) == null ? -1 : lca(root, n1, n2).data));
        //both node should exist and only once in tree
        // System.out.println("Lowest Common Ancestor = " + lca2(root, n1, n2).data);

        // System.out.println("Minimum Distance = " + minDist(root, n1, n2));

        // int n=5, k=1;
        // KAncestor(root, n, k);


        /* expected sum tree :
         *          27
         *         /  \
         *        9    13
         *       / \  /  \
         *      0   0 0   0
         */
        preOrder(root); System.out.println();
        transform(root);
        preOrder(root); System.out.println();
    }
}
