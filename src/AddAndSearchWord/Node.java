package AddAndSearchWord;

import java.util.ArrayList;

public class Node {
    public boolean inserted = false;
    public String prefix;
    public ArrayList<Node> links = new ArrayList<Node>();

    public Node(String inPrefix) {
        prefix = inPrefix;
    }

    public boolean containsKey(String inPrefix) {
        if (!inPrefix.contains(".")) {
            for (Node link : links) {
                if (link.prefix.equals(inPrefix)) {
                    return true;
                }
            }
        } else {
            /*StringBuilder segment = new StringBuilder();
            for (String unit : inPrefix.split("")) {
                if (unit.equals(".")) {

                }
            }*/
            //TODO: get indices of periods and strip then match?
        }
        return false;
    }

    public Node get(String inPrefix) {
        for (Node link : links) {
            if (link.prefix.equals(inPrefix)) {
                return link;
            }
        }
        return null;
    }
}
