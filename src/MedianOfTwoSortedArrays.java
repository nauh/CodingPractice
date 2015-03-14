public class MedianOfTwoSortedArrays implements Runnable {

    int iteration = 0;

    @Override
    public void run() {
        int[] a = new int[] {1};
        int[] b = new int[] {1};
        System.out.println(findMedianSortedArrays(a, b));
    }

    public double findMedianSortedArrays(int[] a, int[] b) {
        if ((a.length + b.length) % 2 != 0) {
            return getKthElement(a, 0, a.length, b, 0, b.length, (a.length + b.length) / 2 + 1);
        } else {
            return (getKthElement(a, 0, a.length, b, 0, b.length, (a.length + b.length) / 2)
            + getKthElement(a, 0, a.length, b, 0, b.length, (a.length + b.length) / 2 + 1)) / 2.0;
        }
    }

    // [startX, endX): zero based index
    // k: nonzero based index
    int getKthElement(int[] a, int startA, int endA, int[] b, int startB, int endB, int k) {
        int lengthA = endA - startA;
        int lengthB = endB - startB;
        // base condition
        if (lengthA <= 0) {
            return b[startB + k - 1];
        }
        if (lengthB <= 0) {
            return a[startA + k - 1];
        }
        if (k <= 1) {
            return Math.min(a[startA], b[startB]);
        }

        int middleA = (startA + endA) / 2;
        int middleB = (startB + endB) / 2;
        // recursive condition
        if (lengthA / 2 + lengthB / 2 + 1 >= k) { // "+1" makes sure it's okay to remove the element at (start + end) / 2 (so it can evolve to the base case where one of the input array is empty)
            if (a[middleA] >= b[middleB]) {
                return getKthElement(a, startA, middleA, b, startB, endB, k);
            } else {
                return getKthElement(a, startA, endA, b, startB, middleB, k);
            }
        } else {
            if (a[middleA] >= b[middleB]) {
                return getKthElement(a, startA, endA, b, middleB + 1, endB, k - (middleB + 1 - startB));
            } else {
                return getKthElement(a, middleA + 1, endA, b, startB, endB, k - (middleA + 1 - startA));
            }
        }
    }

    void print(int startA, int endA, int startB, int endB, int k) {
        System.out.println("------------------");
        System.out.println("K : " + k);
        System.out.println("A: " + startA + " <=> " + endA);
        System.out.println("B: " + startB + " <=> " + endB);
        System.out.println("------------------");
    }

}
