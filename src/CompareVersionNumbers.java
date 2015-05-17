public class CompareVersionNumbers implements Runnable {

    @Override
    public void run() {
        System.out.println(compareVersion("1.1", "1.1"));
    }

    public int compareVersion(String version1, String version2) {
        if (version1 == null || version1.isEmpty() || version2 == null || version2.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");
        int current = 0;
        while (current < Math.min(versions1.length, versions2.length)) {
            int v1 = Integer.parseInt(versions1[current]);
            int v2 = Integer.parseInt(versions2[current]);
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
            current++;
        }
        if (current < versions1.length) {
            for (int i = current; i < versions1.length; i++) {
                if (Integer.parseInt(versions1[i]) > 0) {
                    return 1;
                }
            }
        } else if (current < versions2.length) {
            for (int i = current; i < versions2.length; i++) {
                if (Integer.parseInt(versions2[i]) > 0) {
                    return -1;
                }
            }
        }
        return 0;
    }

}
