package JumpGame;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class JumpGame {
    Node root;
    Node tail;
    HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
    List<Integer> distances = new ArrayList<Integer>();

    public JumpGame() {}

    public boolean canJump(int[] nums) {
        generateNodes(nums);
        return hasDistance(root);
    }

    public void generateNodes(int[] nums) {
        Node current;
        Integer leap;
        Node ahead;
        for (int index = 0; index < nums.length; index++) {
            leap = 1;
            distances.add(index, 0);
            if (!nodes.containsKey(index)) {
                current = new Node(index);
                nodes.put(index, current);
            } else {
                current = nodes.get(index);
            }

            if (nums[index] == 0) {
                continue;
            }

            while (leap <= nums[index]) {
                if (leap + index >= nums.length) {
                    break;
                }
                if (!nodes.containsKey(index + leap)) {
                    ahead = new Node(index + leap);
                    nodes.put(index + leap, ahead);
                } else {
                    ahead = nodes.get(index + leap);
                }
                current.neighbors.add(ahead);
                leap++;
            }
        }

        root = nodes.get(0);
        tail = nodes.get(nodes.size()-1);
    }

    public boolean hasDistance(Node node) {
        if (root.neighbors.contains(tail) || nodes.size() == 1) {
            return true;
        }
        Node current;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.addLast(node);

        while (!queue.isEmpty()) {
            current = queue.removeFirst();

            for (Node neighbor : current.neighbors) {
                if (!neighbor.visited) {
                    neighbor.visited = true;
                    neighbor.distance = current.distance + 1;
                    queue.addLast(neighbor);
                }
            }
        }

        return (tail.distance != 0 ? true : false);
    }
}
