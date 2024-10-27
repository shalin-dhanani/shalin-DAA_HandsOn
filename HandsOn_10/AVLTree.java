import java.util.Scanner;

class AVLTree {

    class Node {
        int data;
        Node left, right;
        int height;

        public Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    private Node root;

    // Utility functions
    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        System.out.println("Right rotation performed on " + y.data);
        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        System.out.println("Left rotation performed on " + x.data);
        return y;
    }

    private Node insertNode(Node node, int data) {
        if (node == null) {
            System.out.println("Inserting " + data);
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insertNode(node.left, data);
        } else if (data > node.data) {
            node.right = insertNode(node.right, data);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && data < node.left.data) {
            return rotateRight(node);
        }

        // Right Right Case
        if (balance < -1 && data > node.right.data) {
            return rotateLeft(node);
        }

        // Left Right Case
        if (balance > 1 && data > node.left.data) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Left Case
        if (balance < -1 && data < node.right.data) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private Node deleteNode(Node root, int data) {
        if (root == null) {
            return root;
        }

        if (data < root.data) {
            root.left = deleteNode(root.left, data);
        } else if (data > root.data) {
            root.right = deleteNode(root.right, data);
        } else {
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }

                if (temp == null) {
                    temp = root;
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                Node temp = minValueNode(root.right);
                root.data = temp.data;
                root.right = deleteNode(root.right, temp.data);
            }
        }

        if (root == null) {
            return root;
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.left) >= 0) {
            return rotateRight(root);
        }

        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        if (balance < -1 && getBalance(root.right) <= 0) {
            return rotateLeft(root);
        }

        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    public void insert(int data) {
        root = insertNode(root, data);
    }

    public void delete(int data) {
        root = deleteNode(root, data);
    }

    public boolean search(int data) {
        Node node = searchHelper(root, data);
        return node != null;
    }

    private Node searchHelper(Node node, int data) {
        if (node == null || node.data == data) {
            return node;
        }

        if (data < node.data) {
            return searchHelper(node.left, data);
        }
        return searchHelper(node.right, data);
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void printInOrder() {
        inOrder(root);
        System.out.println();
    }

    public static void main(String[] args) {
        AVLTree avl = new AVLTree();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Insert\n2. Delete\n3. Search\n4. InOrder Traversal\n5. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter integer to insert: ");
                    int insertValue = scanner.nextInt();
                    avl.insert(insertValue);
                    System.out.println("Inserted " + insertValue);
                    break;
                case 2:
                    System.out.print("Enter integer to delete: ");
                    int deleteValue = scanner.nextInt();
                    avl.delete(deleteValue);
                    System.out.println("Deleted " + deleteValue);
                    break;
                case 3:
                    System.out.print("Enter integer to search: ");
                    int searchValue = scanner.nextInt();
                    boolean found = avl.search(searchValue);
                    System.out.println("Found: " + found);
                    break;
                case 4:
                    System.out.println("InOrder Traversal:");
                    avl.printInOrder();
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}

