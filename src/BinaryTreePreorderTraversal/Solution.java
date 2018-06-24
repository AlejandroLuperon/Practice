package BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        one.setRight(two);
        two.setLeft(three);

        System.out.println(preorderTraversal(one));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> theOrderedList = new ArrayList<Integer>();
        if (root != null) {
            traverse(root, theOrderedList);
        }
        return theOrderedList;
    }

    public static void traverse(TreeNode root, List<Integer> inPreorderList) {
        inPreorderList.add(root.getVal());

        if (root.getLeft() != null) {
            traverse(root.getLeft(), inPreorderList);
        }

        if (root.getRight() != null) {
            traverse(root.getRight(), inPreorderList);
        }
    }
}
