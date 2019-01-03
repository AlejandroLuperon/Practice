package ReconstructItinerary;

public class Solution {

    public static void main(String[] args) {
        ItineraryFinder itineraryFinder = new ItineraryFinder();
        String[][] tickets1 = new String[][]{
            {"MUC","LHR"},
            {"JFK","MUC"},
            {"SFO","SJC"},
            {"LHR","SFO"}
        };

        String[][] tickets2 = new String[][]{
            {"JFK","SFO"},
            {"JFK","ATL"},
            {"SFO","ATL"},
            {"ATL","JFK"},
            {"ATL","SFO"}
        };

        String[][] tickets3 = new String[][]{
            {"JFK","KUL"},
            {"JFK","NRT"},
            {"NRT","JFK"}
        };

        String[][] tickets4 = new String[][]{
            {"EZE","AXA"},
            {"TIA","ANU"},
            {"ANU","JFK"},
            {"JFK","ANU"},
            {"ANU","EZE"},
            {"TIA","ANU"},
            {"AXA","TIA"},
            {"TIA","JFK"},
            {"ANU","TIA"},
            {"JFK","TIA"}
        };


        System.out.println(itineraryFinder.findItinerary(tickets4));
    }
}
