package BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;


/**
 */

public class Solution {
    public static void main(String[] main) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        one.setRight(two);
        two.setLeft(three);

        System.out.println(inorderTraversal(one));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> theInorderTraversal = new ArrayList<Integer>();

        if (root != null) {
            traverse(root, theInorderTraversal);
        }
        return theInorderTraversal;
    }

    public static void traverse(TreeNode inTreeNode, List<Integer> inInorderTraversal) {
        if (inTreeNode.getLeft() != null) {
            traverse(inTreeNode.getLeft(), inInorderTraversal);
        }

        inInorderTraversal.add(inTreeNode.getVal());

        if (inTreeNode.getRight() != null) {
            traverse(inTreeNode.getRight(), inInorderTraversal);
        }
    }
}
