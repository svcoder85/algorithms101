package datastructures;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void insertAndFind() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10, "A").insert(5, "B").insert(15, "C").insert(7, "D");
        bst.prettyPrint();

        BinarySearchTree.Node node = bst.find(5);

        Assert.assertNotNull(node);
        Assert.assertEquals(5, node.key);

        BinarySearchTree.Node node2 = bst.find(25);
        Assert.assertNull(node2);
    }

    @Test
    public void delete_case1() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10, "A").insert(5, "B").insert(15, "C").insert(7, "D");
        bst.prettyPrint();

        bst.delete(7); // no children

        BinarySearchTree.Node node = bst.find(7);
        Assert.assertNull(node);
    }

    @Test
    public void delete_case2() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10, "A").insert(5, "B").insert(15, "C").insert(7, "D");
        bst.prettyPrint();

        bst.delete(5); // 1 child

        BinarySearchTree.Node node = bst.find(5);
        Assert.assertNull(node);
    }

    @Test
    public void delete_case3() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10, "A").insert(5, "B").insert(15, "C").insert(7, "D");
        bst.prettyPrint();

        bst.delete(10); // 2 children

        BinarySearchTree.Node node = bst.find(10);
        Assert.assertNull(node);
    }
}
