import java.util.Random;

public class InterleafSort implements Runnable {

    private final Random random = new Random();

    private int[] getRandomIntegerArray(int size, int lowerBound, int higherBound) {
        return random.ints(size, lowerBound, higherBound).toArray();
    }

    @Override
    public void run() {
        int[] numbers = getRandomIntegerArray(10, 0, 100);
        System.out.println("Input Array: " + toString(numbers));
        sort(numbers);
        System.out.println("Output Array: " + toString(numbers));
    }

    private void sort(int[] numbers) {
        boolean oddIndex = true;
        for (int i = 1; i < numbers.length; i++) {
            if (oddIndex && numbers[i] < numbers[i - 1]) {
                swap(numbers, i, i - 1);
            } else if (!oddIndex && numbers[i] > numbers[i - 1]) {
                swap(numbers, i, i - 1);
            }
            oddIndex = !oddIndex;
        }
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private String toString(int[] numbers) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int number : numbers) {
            stringBuffer.append(number).append(" ");
        }
        return stringBuffer.toString();
    }

}
