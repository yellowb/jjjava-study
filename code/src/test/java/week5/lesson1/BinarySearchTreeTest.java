package week5.lesson1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by HUANGYE2 on 12/4/2017.
 */
public class BinarySearchTreeTest {

    private BinarySearchTree<Integer> bst;

    @Before
    public void buildBST() {
        bst = new BinarySearchTree<>();

        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(2);
    }

    @Test
    public void test_BST_should_contains_2() {
        assertTrue("Can't match 2 in BST.", bst.contains(2));
    }

    @Test
    public void test_BST_should_not_contains_5() {
        assertFalse("Can't match 5 in BST.", bst.contains(5));
    }

}