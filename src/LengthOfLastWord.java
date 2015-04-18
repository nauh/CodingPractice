public class LengthOfLastWord implements Runnable {

    @Override
    public void run() {
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int start = -1, end = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                end = i;
                break;
            }
        }
        for (int i = end; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                start = i;
                break;
            }
        }
        return end - start;
    }

}
