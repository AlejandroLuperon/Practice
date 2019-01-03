package ReconstructItinerary;

public class SolutionHierholzer {

    public static void main(String[] args) {
        ItineraryFinderHierholzer itineraryFinderHierholzer = new ItineraryFinderHierholzer();
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

        String[][] tickets5 = new String[][] {
            {"EZE","TIA"},
            {"EZE","HBA"},
            {"AXA","TIA"},
            {"JFK","AXA"},
            {"ANU","JFK"},
            {"ADL","ANU"},
            {"TIA","AUA"},
            {"ANU","AUA"},
            {"ADL","EZE"},
            {"ADL","EZE"},
            {"EZE","ADL"},
            {"AXA","EZE"},
            {"AUA","AXA"},
            {"JFK","AXA"},
            {"AXA","AUA"},
            {"AUA","ADL"},
            {"ANU","EZE"},
            {"TIA","ADL"},
            {"EZE","ANU"},
            {"AUA","ANU"}
        };


        System.out.println(itineraryFinderHierholzer.findItinerary(tickets5));
    }
}
