package week6.lesson2;

import week5.lesson1.Node;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.out;
import static week6.lesson2.AVLNode.NodeState.*;

/**
 * AVL Tree
 *
 * @param <T>
 */
public class AVLTree<T extends Comparable<T>> {

    private AVLNode<T> root;

    public void insert(T i) {
        if (root == null) {
            root = new AVLNode<>(i);
            return;
        }

        insert(root, i);
    }

    /**
     * Try to add one node into AVL Tree
     *
     * @param root
     * @param i
     */
    public void insert(AVLNode<T> root, T i) {
        // 跟BST一样不断比较找到合适的位置放节点
        if (i.compareTo(root.data) < 0) {
            if (root.left != null) {
                insert(root.left, i);
            } else {
                root.left = new AVLNode<>(i);
                root.left.parent = root;
            }
        } else {
            if (root.right != null) {
                insert(root.right, i);
            } else {
                root.right = new AVLNode<>(i);
                root.right.parent = root;
            }
        }

        // 插入完新节点后检查当前root的balance
        root.balance = calcBalance(root);

        /* 左子树高，应该右旋 */
        if (root.balance >= 2) {
	    /* 右孙高，先左旋 */
            if (root.left.balance == -1)
                leftRotate(root.left);

            rightRotate(root);
        }

        if (root.balance <= -2)
        {
            if (root.right.balance == 1)
                rightRotate(root.right);

            leftRotate(root);
        }

        root.balance = calcBalance(root);
        root.depth = calcDepth(root);
    }

    /**
     * Calc the balance of a node(a tree uses this node as root)
     *
     * @param p
     * @return
     */
    private int calcBalance(AVLNode p) {
        int leftDepth = (p.left != null) ? p.left.depth : 0;
        int rightDepth = (p.right != null) ? p.right.depth : 0;
        return leftDepth - rightDepth;
    }

    /**
     * Calc the depth of a node(a tree uses this node as root)
     *
     * @param p
     * @return
     */
    private int calcDepth(AVLNode p) {
        int depth = 0;
        if (p.left != null) {
            depth = p.left.depth;
        }
        if (p.right != null && depth < p.right.depth) {
            depth = p.right.depth;
        }
        return depth + 1;
    }

    /**
     * 右旋子树
     * @param p
     */
    private void rightRotate(AVLNode p) {
        /* 一次旋转涉及到的结点包括祖父，父亲，右儿子 */
        AVLNode pParent = p.parent, pLeftSon = p.left;
        AVLNode pRightGrandSon = pLeftSon.right;

	    /* 左子僭为父 */
	    // 断开原root与其父节点, 并把root的左儿子接驳到root的父节点
        pLeftSon.parent = pParent;
        if (pParent != null) {
            if (p == pParent.left)
                pParent.left = pLeftSon;
            else if (p == pParent.right)
                pParent.right = pLeftSon;
        }
        /********  教程里漏了这个!!! ********/
        /********  不加上这个的话, 整颗树的root在翻转后就会指向某个子树, 而不是整棵树的根  ******/
        else {
            root = pLeftSon;
        }

        // 把原root变成原左孩子的右孩子
        pLeftSon.right = p;
        p.parent = pLeftSon;

        /* 上面两步做完相当于把原root与原root的左孩子的父子关系对调了 */

	    /* 右孙变左孙 */
        p.left = pRightGrandSon;
        if (pRightGrandSon != null)
            pRightGrandSon.parent = p;

	    /* 重新计算平衡因子 */
        p.depth = calcDepth(p);
        p.balance = calcBalance(p);

        pLeftSon.depth = calcDepth(pLeftSon);
        pLeftSon.balance = calcBalance(pLeftSon);
    }

    /**
     * 左旋子树
     * @param p
     */
    private void leftRotate(AVLNode p) {
        AVLNode pParent = p.parent, pRightSon = p.right;
        AVLNode pLeftGrandSon = pRightSon.left;

        pRightSon.parent = pParent;
        if (pParent != null) {
            if (p == pParent.left)
                pParent.left = pRightSon;
            else if (p == pParent.right)
                pParent.right = pRightSon;
        }
        else {
            root = pRightSon;
        }

        pRightSon.left = p;
        p.parent = pRightSon;

        p.right = pLeftGrandSon;
        if (pLeftGrandSon != null)
            pLeftGrandSon.parent = p;

	    /* 重新计算平衡因子 */
        p.depth = calcDepth(p);
        p.balance = calcBalance(p);

        pRightSon.depth = calcDepth(pRightSon);
        pRightSon.balance = calcBalance(pRightSon);
    }

    /**
     * Go through BST by layer from top to bottom.
     */
    public void layerOrder() {

        if (root == null) {
            return;
        }

        // Root as the 1st node to be the queue head.
        AVLNode current = root;
        Queue<AVLNode> queue = new LinkedList();
        queue.offer(current);

        while (!queue.isEmpty()) {
            current = queue.peek();
            switch (current.state) {
                case NOOP: {
                    out.print(current.data + " ");
                    current.state = LEFT;
                    break;
                }
                case LEFT: {
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    current.state = RIGHT;
                    break;
                }
                case RIGHT: {
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                    current.state = END;
                    break;
                }
                case END:
                default: {
                    current.state = NOOP;
                    queue.poll();
                }
            }
        }
    }

    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(5);
        avlTree.insert(3);
        avlTree.insert(6); 
        avlTree.insert(2);
        avlTree.insert(4);
        avlTree.insert(1);
        

        avlTree.layerOrder(); 
    }

}
