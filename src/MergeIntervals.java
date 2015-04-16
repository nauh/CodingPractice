import java.util.ArrayList;
import java.util.List;

public class MergeIntervals implements Runnable {

    @Override
    public void run() {
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) {
            return result;
        }
        sort(intervals, 0, intervals.size() - 1);
        result.add(intervals.get(0));
        int current = 0;
        for (int i = 1; i < intervals.size(); i++) {
            if (canMerge(result.get(current), intervals.get(i))) {
                result.set(current, merge(result.get(current), intervals.get(i)));
            } else {
                result.add(intervals.get(i));
                current += 1;
            }
        }
        return result;
    }

    private void sort(List<Interval> intervals, int start, int end) {
        if (start >= end) {
            return;
        }
        Interval pivot = intervals.get(end);
        int lastLeft = start - 1;
        for (int i = start; i < end; i++) {
            if (intervals.get(i).start < pivot.start) {
                lastLeft += 1;
                swap(intervals, lastLeft, i);
            }
        }
        swap(intervals, lastLeft + 1, end);
        sort(intervals, start, lastLeft);
        sort(intervals, lastLeft + 2, end);
    }

    private void swap(List<Interval> intervals, int x, int y) {
        intervals.set(y, intervals.set(x, intervals.get(y)));
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
