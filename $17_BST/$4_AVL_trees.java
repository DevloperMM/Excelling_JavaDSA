package $17_BST;

public class $4_AVL_trees {
    static class Node {
        int data, height;
        Node left, right;

        Node (int data) {
            this.data = data;
            this.height = 1;
        }
    }
// ---------------------------------------------
    //Height of the node
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    //Get Balance Factor of Node
    public static int getBF(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    //PreOrder Traversal
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
// ---------------------------------------------
    //Left Rotate Subtree rooted with X
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        //Perform rotation
        y.left = x;
        x.right = T2;

        //Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        //Y is now the new root
        return y;
    }
// -----------------------------------------------
    //Right Rotate Subtree rooted with Y
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        //Perform rotation
        x.right = y;
        y.left = T2;

        //Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        //X is now the new root
        return x;
    }
// -----------------------------------------------
    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root; //Duplicates are not allowed for now
        }

        //Update root height
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        //Get root's balance factor
        int bf = getBF(root);

        //LL case
        if (bf > 1 && key < root.left.data) {
            return rightRotate(root);
        }

        //RR case
        if (bf < -1 && key > root.right.data) {
            return leftRotate(root);
        }

        //LR case
        if (bf > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        //RL case
        if (bf < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root; //AVL tree is already balanced and no need of rotations
    }
// ---------------------------------------------
    // Get the Minimum Node
    public static Node getMinNode(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Delete AVL tree node
    public static Node deleteNode(Node root, int key) {
        //BST is null already
        if (root == null) {
            return root;
        }

        //node in left subtree
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        }

        //node in right subtree
        else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        }

        //node to be deleted
        else {
            //Case: No Child or One Child
            if (root.left == null || root.right == null) {
                if (root.left == null) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }

            //Case: Two Children
            else {
                Node IS = getMinNode(root.right); //smallest in right subtree
                root.data = IS.data; //replace with IS
                root.right = deleteNode(root.right, IS.data); //delete the IS
            }
        }

        //Balancing the tree (if not) after deletion of node
        if (root == null) {
            return root;
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int bf = getBF(root);

        //Following 4 cases to balance after deletion (if not)
        //LL
        if (bf > 1 && getBF(root.left) >= 0) {
            return rightRotate(root);
        }
        //LR
        if (bf > 1 && getBF(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        //RR
        if (bf < -1 && getBF(root.right) <= 0) {
            return leftRotate(root);
        }
        //RL
        if (bf < -1 && getBF(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
// ---------------------------------------------
    public static void main(String[] args) {
        int values[] = {10, 20, 30, 40, 50, 25};
        Node root = null;
        for (int i=0; i<values.length; i++) {
            root = insert(root, values[i]);
        }
        /*           30
         *          /  \
         *         20  40
         *        / \    \
         *       10  25   50
         *      Expected AVL tree
         */
        preOrder(root); System.out.println();
        root = deleteNode(root, 10);
        preOrder(root); System.out.println();
    }
}
