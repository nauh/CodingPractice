public class CountAndSay implements Runnable {

    @Override
    public void run() {
        System.out.println(countAndSay(5));
    }

    public String countAndSay(int n) {
        if (n <= 1) {
            return "1";
        }

        StringBuilder stringBuilder = new StringBuilder();
        String previous = countAndSay(n - 1);
        char number = previous.charAt(0);
        int count = 1;
        for (int i = 1; i < previous.length(); i++) {
            if (previous.charAt(i) == number) {
                count++;
            } else {
                stringBuilder.append(count).append(number);
                number = previous.charAt(i);
                count = 1;
            }
        }
        stringBuilder.append(count).append(number);
        return stringBuilder.toString();
    }

}
