package RemoveDuplicateLetters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        ArrayList<String> theCharacters = new ArrayList<String>(Arrays.asList(s.split("")));
        HashMap<String, ArrayList<Integer>> theOccurrences = new HashMap<String, ArrayList<Integer>> ();
        HashMap<Integer, String> theOrder = new HashMap<Integer, String>();

        for (int i = 0; i < theCharacters.size(); i++) {
            String theCurrentCharacter = theCharacters.get(i);
            if (!theOccurrences.containsKey(theCurrentCharacter)) {
                ArrayList<Integer> theIndicesOfOccurrence = new ArrayList<Integer>();
                theIndicesOfOccurrence.add(i);
                theOccurrences.put(theCurrentCharacter, theIndicesOfOccurrence);
            } else {
                theOccurrences.get(theCurrentCharacter).add(i);
            }
            theOrder.put(i, theCurrentCharacter);
        }

        return "string";
    }

    /*
    private HashSet<String> itsHasBeenSeen = new HashSet<String>();
    public String removeDuplicateLetters(String s) {
        ArrayList<String> theCharacters = new ArrayList<String>(Arrays.asList(s.split("")));
        String theAnswer = "";
        TreeSet<String> theAnswers = new TreeSet<>();

        for (int i = 0; i < theCharacters.size(); i++) {
            if (!itsHasBeenSeen.contains(theCharacters.get(i))) {
                itsHasBeenSeen.add(theCharacters.get(i));
                theAnswers.add(theCharacters.get(i));
            }
        }

        String[] theOrderedArray = theAnswers.toArray(new String[theAnswers.size()]);

        for (int i = 0; i < theOrderedArray.length; i++) {
             theAnswer = theAnswer + theOrderedArray[i];
        }

        return theAnswer;
    }*/
}
