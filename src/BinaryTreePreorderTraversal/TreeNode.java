package BinaryTreePreorderTraversal;

public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int inVal) {
        val = inVal;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode inLeft) {
        left = inLeft;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode inRight) {
        right = inRight;
    }
}
