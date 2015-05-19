import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseScheduleII implements Runnable {

    @Override
    public void run() {
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int row = 0; row < prerequisites.length; row++) {
            int course = prerequisites[row][0];
            int prerequisite = prerequisites[row][1];
            Set<Integer> set = map.containsKey(course) ? map.get(course) : new HashSet<>();
            set.add(prerequisite);
            map.put(course, set);
        }

        List<Integer> list = new ArrayList<>();
        int[] taken = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!canFinish(map, list, taken, i)) {
                return new int[0];
            }
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private boolean canFinish(Map<Integer, Set<Integer>> map, List<Integer> result, int[] taken, int course) {
        if (taken[course] == -1) {
            return false;
        } else if (taken[course] == 1) {
            return true;
        }
        taken[course] = -1;
        if (map.containsKey(course)) {
            for (int prerequisite : map.get(course)) {
                if (!canFinish(map, result, taken, prerequisite)) {
                    return false;
                }
            }
        }
        taken[course] = 1;
        result.add(course);
        return true;
    }

}
