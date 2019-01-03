package WordBreak;

import java.util.*;

public class DidntWorkSolution {
    //List<String, Word>
    public static void main(String[] args) {
        HashMap<String, ArrayList<DidntWorkWord>> theWordLookup = new HashMap<String, ArrayList<DidntWorkWord>>();
        DidntWorkWord theHead;
        List<String> theWordDictionary = new ArrayList<String>() {{
            add("apple");
            add("pen");
        }};

        String theString = "applepenapple";

        int indexOfCurrentWord = 0;
        int index = 0;

        for (String theCurrentWord : theWordDictionary) {
            index = 0;
            while (true) {
                if (index == 0) {
                    indexOfCurrentWord = theString.indexOf(theCurrentWord);
                } else {
                    indexOfCurrentWord = theString.indexOf(theCurrentWord, index);
                }

                if (indexOfCurrentWord >= 0) {
                    if (!theWordLookup.containsKey(theCurrentWord)) {
                        theWordLookup.put(theCurrentWord, new ArrayList<DidntWorkWord>());
                    }
                    DidntWorkWord theEncounteredWord = new DidntWorkWord(indexOfCurrentWord, indexOfCurrentWord + theCurrentWord.length(), theCurrentWord);
                    theWordLookup.get(theCurrentWord).add(theEncounteredWord);

                    if (index == 0) {
                        theHead = theEncounteredWord;
                    }
                    index = indexOfCurrentWord + theCurrentWord.length();

                } else {
                    break;
                }
            }
        }
        System.out.println(theWordLookup);

        theWordLookup.values().forEach((inList) -> {
            inList.forEach((inWord -> {
                inWord.print();
            }));
        });

    }

    /*public boolean wordBreak(String s, List<String> wordDict) {

        return true;
    }*/
}
