import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class SimplifyPath implements Runnable {

    @Override
    public void run() {
        System.out.println(simplifyPath("/..."));
    }

    public String simplifyPath(String path) {
        StringJoiner sj = new StringJoiner("/");
        if (path == null || path.isEmpty()) {
            return sj.toString();
        }
        List<String> dirs = new ArrayList<>();
        int end = path.indexOf("/");
        int start = end + 1;
        while (start < path.length() && end >= 0) {
            end = path.indexOf("/", start);
            String dir = end == -1 ? path.substring(start) : path.substring(start, end);
            switch (dir) {
                case "" :
                case ".":
                    break;
                case ".." :
                    if (!dirs.isEmpty()) {
                        dirs.remove(dirs.size() - 1);
                    }
                    break;
                default:
                    dirs.add(dir);
                    break;
            }
            start = end + 1;
        }
        for (String dir : dirs) {
            sj.add(dir);
        }
        return "/" + sj.toString();
    }

}
