package SingleOccurrence;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class Solution {
    public HashMap<Integer, Integer> occurrences = new HashMap<Integer, Integer>();

	public int singleNumber(final List<Integer> a) {
	    a.forEach((occurrence)->{
	        if (occurrences.containsKey(occurrence)) {
	            occurrences.put(occurrence, occurrences.get(occurrence) + 1);
            } else {
	            occurrences.put(occurrence, 1);
            }
        });

	    List<Integer> result = occurrences.keySet().stream().filter((inKey)->{
	        return occurrences.get(inKey) == 1;
        }).collect(Collectors.toList());
	    return result.get(0);
	}
}

