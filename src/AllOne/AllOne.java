package AllOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 */

public class AllOne {
    HashMap<String, Key> retrievalMap = new HashMap<String, Key>();
    HashMap<Integer, List<Key>> occurrences = new HashMap<Integer, List<Key>>();

    /** Initialize your data structure here. */
    public AllOne() {

    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Key keyObj = null;
        if (!retrievalMap.containsKey(key)) {
            keyObj = new Key(key);
            retrievalMap.put(key, keyObj);
            if (!occurrences.containsKey(1)) {
                occurrences.put(1, new ArrayList<Key>());
            }
            occurrences.get(1).add(keyObj);
        } else {
            keyObj = retrievalMap.get(key);
            occurrences.get(keyObj.value).remove(keyObj);
            keyObj.value++;
            if (occurrences.get(keyObj.value - 1).size() == 0) {
                occurrences.remove(keyObj.value - 1);
            }
            if (!occurrences.containsKey(keyObj.value)) {
                occurrences.put(keyObj.value, new ArrayList<Key>());
            }
            occurrences.get(keyObj.value).add(keyObj);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!retrievalMap.containsKey(key)) {
            return;
        }
        Key keyObj = retrievalMap.get(key);
        if (keyObj.value == 1) {
            retrievalMap.remove(key);

            occurrences.get(1).remove(keyObj);
            if (occurrences.get(1).size() == 0) {
                occurrences.remove(1);
            }
            return;
        }
        occurrences.get(keyObj.value).remove(keyObj);
        if (occurrences.get(keyObj.value).size() == 0) {
            occurrences.remove(keyObj.value);
        }
        keyObj.value--;

        if (!occurrences.containsKey(keyObj.value)) {
            occurrences.put(keyObj.value, new ArrayList<Key>());
        }
        occurrences.get(keyObj.value).add(keyObj);
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (retrievalMap.size() == 0) {
            return "";
        }
        Integer maxInteger = occurrences.entrySet().stream().max(Map.Entry.comparingByKey()).get().getKey();
        return occurrences.get(maxInteger).get(0).key;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (retrievalMap.size() == 0) {
            return "";
        }
        Integer minInteger = occurrences.entrySet().stream().min(Map.Entry.comparingByKey()).get().getKey();
        return occurrences.get(minInteger).get(0).key;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */