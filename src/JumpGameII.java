public class JumpGameII implements Runnable {

    @Override
    public void run() {
        System.out.println(jump(new int[] {0}));
    }

    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = -1;
        int end = 0;
        int jumps = 0;
        while (end < A.length - 1) {
            int maxEnd = end;
            for (int i = start + 1; i <= end; i++) {
                maxEnd = Math.max(maxEnd, i + A[i]);
            }
            start = end;
            end = maxEnd;
            jumps++;
        }
        return jumps;
    }

    public int jumpMemory(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int[] destination = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            destination[i] = i + A[i];
        }

        int nextDestination = A.length - 1;
        int jumps = 0;
        while (nextDestination > 0) {
            for (int i = 0; i <= A.length - 1; i++) {
                if (destination[i] >= nextDestination) {
                    nextDestination = i;
                    jumps++;
                    break;
                }
            }
        }
        return jumps;
    }
}
