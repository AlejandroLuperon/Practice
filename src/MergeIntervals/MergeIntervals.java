package MergeIntervals;

import java.util.ArrayList;


public class MergeIntervals {
    public static void main(String[] args) {
        ArrayList<Integer[]> theIntervals = new ArrayList<Integer[]>(){{
            add(new Integer[]{2,6});
            add(new Integer[]{8,10});
            add(new Integer[]{1,3});
            add(new Integer[]{15,18});
            add(new Integer[]{0,19});

        }};

        ArrayList<Integer[]> theMergedIntervals = new ArrayList<Integer[]>();

        Integer theBeginning = 0;
        Integer theEnd = 0;
        Integer theMergedBeginning = 0;
        Integer theMergedEnd = 0;

        for (Integer[] theInterval : theIntervals) {
            if (theMergedIntervals.size() == 0) {
                theMergedIntervals.add(theInterval);
            } else {
                theBeginning = theInterval[0];
                theEnd = theInterval[1];
                boolean isOverlap = false;
                for (Integer[] theMergedInterval : theMergedIntervals) {
                    theMergedBeginning = theMergedInterval[0];
                    theMergedEnd = theMergedInterval[1];
                    if (theMergedBeginning >= theBeginning && theMergedEnd <= theEnd) {
                        theMergedIntervals.remove(theMergedInterval);
                        theMergedIntervals.add(theInterval);
                    }

                    if ((theEnd >= theMergedBeginning && theEnd <= theMergedEnd)) {
                        isOverlap = true;
                        if (theBeginning < theMergedBeginning) {
                            theMergedInterval[0] = theBeginning;
                        }
                    }
                }
                if (!isOverlap) {
                    theMergedIntervals.add(theInterval);
                }
            }
        }
        theMergedIntervals.forEach(item->{
            System.out.println(item[0] + " " + item[1]);
        });
    }
}
