public class RemoveDuplicatesFromSortedArrayII implements Runnable {

    @Override
    public void run() {
    }

    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int current = A[0], count = 0;
        int index = 0, insert = 0;
        while (index < A.length) {
            A[insert] = A[index];
            if (A[index] == current) {
                if (count < 2) {
                    count++;
                    insert++;
                }
            } else {
                current = A[index];
                count = 1;
                insert++;
            }
            index++;
        }
        return insert;
    }

}
