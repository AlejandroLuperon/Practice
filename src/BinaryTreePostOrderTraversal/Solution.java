package BinaryTreePostOrderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        one.setRight(two);
        two.setLeft(three);

        System.out.println(postorderTraversal(one));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> thePostorderTraversal = new ArrayList<Integer>();

        if (root != null) {
            traverse(root, thePostorderTraversal);
        }

        return thePostorderTraversal;
    }

    public static void traverse(TreeNode inTreeNode, List<Integer> inPostorderList) {
        if (inTreeNode.getLeft() != null) {
            traverse(inTreeNode.getLeft(), inPostorderList);
        }

        if (inTreeNode.getRight() != null) {
            traverse(inTreeNode.getRight(), inPostorderList);
        }

        inPostorderList.add(inTreeNode.getVal());
    }
}
