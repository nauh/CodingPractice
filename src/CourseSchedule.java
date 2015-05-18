import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule implements Runnable {

    @Override
    public void run() {
        int[][] prerequisites = new int[2][2];
        prerequisites[0][0] = 1;
        prerequisites[0][1] = 0;
        prerequisites[1][0] = 2;
        prerequisites[1][1] = 1;
        System.out.println(canFinish(3, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites.length == 0) {
            return true;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int row = 0; row < prerequisites.length; row++) {
            int course = prerequisites[row][0];
            int prerequisite = prerequisites[row][1];
            Set<Integer> set = map.containsKey(course) ? map.get(course) : new HashSet<>();
            set.add(prerequisite);
            map.put(course, set);
        }

        List<Integer> current = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!map.containsKey(i)) {
                current.add(i);
            }
        }

        while (!current.isEmpty()) {
            Integer course = current.remove(0);
            Iterator<Map.Entry<Integer, Set<Integer>>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Set<Integer>> entry = iterator.next();
                Set<Integer> dependencies = entry.getValue();
                dependencies.remove(course);
                if (dependencies.isEmpty()) {
                    iterator.remove();
                    current.add(entry.getKey());
                }
            }
        }
        return map.isEmpty();
    }

}
