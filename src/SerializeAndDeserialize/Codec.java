package SerializeAndDeserialize;

import java.util.HashMap;
import java.util.LinkedList;


public class Codec {
    HashMap<Integer, TreeNode> indexToTreeNodeMap = new HashMap<Integer, TreeNode>();
    public String serialize(TreeNode root) {
        String serialzied = "[";
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        serialzied = serialzied + root.val;
        queue.add(root);

        TreeNode current = null;

        while (!queue.isEmpty()) {
            current = queue.getFirst();
            if (current.left != null) {
                queue.addLast(current.left);
                serialzied = serialzied + "," + current.left.val;
            } else {

            }

            if (current.right != null) {
                queue.addLast(current.right);
                serialzied = serialzied + "," + current.left.val;
            } else {

            }
        }

        return "";
    }

    public TreeNode deserialize(String data) {
        data = "[1,2,3,null,null,4,5]".substring(1);
        data = data.substring(0, data.length()-1);
        String[] payloads = data.split(",");

        for (int i = 0; i < data.length(); i++) {
            TreeNode treeNode = new TreeNode(Integer.parseInt(payloads[i]));
            indexToTreeNodeMap.put(i, treeNode);
        }

        Integer leftChildIndex = 0, rightChildIndex = 0;
        TreeNode leftChild = null, rightChild = null, current = null;

        for (int i = 0; i < indexToTreeNodeMap.size(); i++) {
            current = indexToTreeNodeMap.get(i);

            leftChildIndex = 2*i + 1;
            rightChildIndex = 2*i + 2;

            if (indexToTreeNodeMap.containsKey(leftChildIndex)) {
                leftChild = indexToTreeNodeMap.get(leftChildIndex);
                current.left = leftChild;
            }

            if (indexToTreeNodeMap.containsKey(rightChildIndex)) {
                rightChild = indexToTreeNodeMap.get(rightChildIndex);
                current.right = rightChild;
            }
        }

        return current;
    }

    private String fill(String data) {
        data = data + ",null,null";
        return data;
    }



}

