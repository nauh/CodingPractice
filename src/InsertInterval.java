import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }
        int start = 0;
        int end = intervals.size() - 1;
        int middle = 0;
        while (start <= end) {
            middle = start + (end - start) / 2;
            if (intervals.get(middle).start < newInterval.start) {
                start = middle + 1;
            } else if (intervals.get(middle).start > newInterval.start) {
                end = middle - 1;
            } else {
                break;
            }
        }

        Interval merged = newInterval;
        int lastLeft;
        int firstRight;
        if (intervals.get(middle).start < newInterval.start) {            
            lastLeft = middle;
            firstRight = middle + 1;
        } else {
            lastLeft = middle - 1;
            firstRight = middle;
        }
        while (0 <= lastLeft && canMerge(merged, intervals.get(lastLeft))) {
            merged = merge(merged, intervals.get(lastLeft));
            lastLeft -= 1;
        }
        while (firstRight < intervals.size() && canMerge(merged, intervals.get(firstRight))) {
            merged = merge(merged, intervals.get(firstRight));
            firstRight += 1;
        }
        for (int i = 0; i <= lastLeft; i++) {
            result.add(intervals.get(i));
        }
        result.add(merged);
        for (int i = firstRight; i < intervals.size(); i++) {
            result.add(intervals.get(i));
        }
        return result;
    }

    private boolean canMerge(Interval a, Interval b) {
        Interval small = a.start < b.start ? a : b;
        return a.start <= b.start ? b.start <= a.end : a.start <= b.end;
    }

    private Interval merge(Interval a, Interval b) {
        return new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
    }

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

}
