import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        } else if (points.length < 3) {
            return points.length;
        }

        int result = 0;
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            map.clear();
            int num = 1;
            for (int j = i + 1; j < points.length; j++) {
                double slope;
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    num += 1;
                    continue;
                } else if (points[i].x == points[j].x) {
                    slope = Double.POSITIVE_INFINITY;
                } else if (points[i].y == points[j].y) {
                    slope = 0;
                } else {
                    slope = (1.0 * points[i].y - 1.0 * points[j].y) / (1.0 * points[i].x - 1.0 * points[j].x);
                }
                if (map.containsKey(slope)) {
                    map.put(slope, map.get(slope) + 1);
                } else {
                    map.put(slope, 1);
                }
            }
            int localMax = 0;
            for (Integer count : map.values()) {
                localMax = Math.max(localMax, count);
            }
            result = Math.max(result, localMax + num);
        }
        return result;
    }

    private class Point {
        int x;
        int y;

        Point() {
            this.x = 0;
            this.y = 0;
        }

        Point(int a, int b) {
            this.x = a;
            this.y = b;
        }
    }

}
