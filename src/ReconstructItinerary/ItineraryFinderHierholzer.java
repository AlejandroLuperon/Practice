package ReconstructItinerary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;


public class ItineraryFinderHierholzer {
    private Graph graph = new Graph();
    private List<String> itinerary = new ArrayList<String>();

    public ItineraryFinderHierholzer() {

    }

    public List<String> findItinerary(String[][] tickets) {
        Node arrivalNode = null, departureNode = null;
        for (int i = 0; i < tickets.length; i++) {
            String departure = tickets[i][0].toLowerCase();
            String arrival = tickets[i][1].toLowerCase();

            if (!graph.nodes.containsKey(departure)) {
                graph.nodes.put(departure, new Node(departure));
            }

            if (!graph.nodes.containsKey(arrival)) {
                graph.nodes.put(arrival, new Node(arrival));
            }

            departureNode = graph.nodes.get(departure);
            arrivalNode = graph.nodes.get(arrival);

            departureNode.destinations.add(arrivalNode);

            graph.edges.add(new Edge(departureNode, arrivalNode));

            if (graph.root == null && arrival.equals("jfk")) {
                graph.root = arrivalNode;
            }

            if (graph.root == null && departure.equals("jfk")) {
                graph.root = departureNode;
            }
        }


        graph.nodes.values().stream().forEach((node)->{ ;
            node.destinations = node.destinations.stream().sorted((a, b)->{
                if (a.destinations.size() == 0 && b.destinations.size() == 0) {
                    return 1;
                }

                if (a.destinations.size() > 0 && b.destinations.size() == 0) {
                    return -1;
                }

                if (a.destinations.size() == 0 && b.destinations.size() > 0) {
                    return 1;
                }
                return a.code.compareTo(b.code);
            }).collect(Collectors.toList());
        });

        Stack<Node> stack = new Stack<Node>(){{
           push(graph.root);
        }};
        dfs(stack);

        Collections.reverse(itinerary);
        return itinerary;
    }

    private void dfs(Stack<Node> stack) {
        Node arrival = stack.pop();
        System.out.println("arrival: " + arrival.code);
        arrival.destinations.forEach((destination) -> {
            Edge currentEdge = graph.getEdge(arrival, destination);

            if (currentEdge != null && !currentEdge.traversed) {
                currentEdge.traversed = true;
                stack.push(destination);
                dfs(stack);
            }
        });

        itinerary.add(arrival.code);
        stack.remove(arrival);
    }
}
