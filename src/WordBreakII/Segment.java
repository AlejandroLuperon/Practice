package WordBreakII;

import java.util.HashMap;

public class Segment {
    public HashMap<String, Integer> occurrences = new HashMap<String, Integer>();

    public Segment() {

    }

    public boolean equals(HashMap<String, Integer> segment) {
        if (segment.keySet().size() != occurrences.keySet().size()) {
            return false;
        }

        for (String key : occurrences.keySet()) {
            if (segment.containsKey(key) && segment.get(key).equals(occurrences.get(key))) {
                continue;
            } else {
                return false;
            }
        }
        System.out.println("SURR");
        return true;
    }
}
