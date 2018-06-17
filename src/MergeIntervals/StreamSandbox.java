package MergeIntervals;

import java.util.*;
import java.util.stream.Collectors;


public class StreamSandbox {
    public static void main(String[] args) {
        ArrayList<Integer> theNumbers = new ArrayList<Integer>(){{
            add(2);
            add(4);
            add(6);
            add(7);
        }};

        ArrayList<Integer> theEvens = theNumbers
                .stream()
                .filter(inEven -> inEven % 2 == 0)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(theEvens);
    }

}
