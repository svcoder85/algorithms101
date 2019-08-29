package datastructures;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

    static class Node {
        int key;
        String val;
        Node left, right;

        Node(int key, String val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public java.lang.String toString() {
            return "{" +
                    "key=" + key +
                    ", val=" + val +
                    '}';
        }
    }

    Node root;

    public BinarySearchTree insert(int key, String val) {
        insertRecursive(this.root, key, val);
        return this;
    }

    private Node insertRecursive(Node root, int key, String val) {
        if (root == null) {
            Node newNode = new Node(key, val);
            if (this.root == null) {
                this.root = newNode;
            }
            return newNode;
        }

        if (key < root.key) {
            root.left = insertRecursive(root.left, key, val);
        } else {
            root.right = insertRecursive(root.right, key, val);
        }

        return root;
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node node, int key) {
        if (node == null) {
            return null;
        } else if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            //case1: Node with 0 children
            if (node.left == null && node.right == null) {
                node = null;
            }

            //case2: Node with 1 child
            else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            }

            //case3: Node with 2 children
            else {
                //find the min node in right subtree
                Node minRight = findMin(node.right);

                //copy minRight node values to current node
                node.key = minRight.key;
                node.val = minRight.val;

                //set the right child to null
                node.right = delete(node.right, minRight.key);
            }
        }
        return node;
    }

    private Node findMin(Node node) {
        if (node == null) {
            return null;
        }

        Node curr = node;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public Node find(int key) {
        return findNode(this.root, key);
    }

    private Node findNode(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (root.key == key) {
            return root;
        } else if (key < root.key) {
            return findNode(root.left, key);
        } else {
            return findNode(root.right, key);
        }
    }

    public void prettyPrint() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Node> current = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                current.add(node);
            }

            System.out.println(current);
        }
    }
}
