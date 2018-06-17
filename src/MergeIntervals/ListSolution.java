package MergeIntervals;

import java.util.*;

class ListSolution {
    public static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }

    public static void main(String[] args) {
        //[[1,3],[2,6],[8,10],[15,18]]
        Interval a = new Interval(1,3);
        Interval b = new Interval(2,6);
        Interval c = new Interval(8,10);
        Interval d = new Interval(15,18);
        Interval e = new Interval(0,20);
        List<Interval> theUnmergedList = new ArrayList<Interval>(){{
            add(a);
            add(b);
            add(c);
            add(d);
            add(e);
        }};

        merge(theUnmergedList);
        List<Interval> theMergedList = merge(theUnmergedList);
        theMergedList.forEach(inInterval -> {
            System.out.println(inInterval.start + ", " + inInterval.end);
        });

    }
}