package Graphs;

public class BFSSolution {
    public static void main(String[] args) {
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        zero.getNeighbors().add(one);

        one.getNeighbors().add(zero);
        one.getNeighbors().add(four);
        one.getNeighbors().add(five);

        two.getNeighbors().add(three);
        two.getNeighbors().add(four);
        two.getNeighbors().add(five);

        three.getNeighbors().add(two);
        three.getNeighbors().add(six);

        four.getNeighbors().add(one);
        four.getNeighbors().add(two);

        five.getNeighbors().add(one);
        five.getNeighbors().add(two);
        five.getNeighbors().add(six);

        six.getNeighbors().add(three);
        six.getNeighbors().add(five);

        BreadthFirstSearch theBreadthFirstSearchInterface = new BreadthFirstSearch();

        theBreadthFirstSearchInterface.bfs(zero);
    }
}
