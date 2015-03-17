public class LongestCommonPrefix implements Runnable {

    @Override
    public void run() {
    }

    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if (strs.length != 0) {
            for (int i = 0; i < strs[0].length(); i++) {
                char character = strs[0].charAt(i);
                for (int j = 0; j < strs.length; j++) {
                    if (strs[j].length() <= i || strs[j].charAt(i) != character) {
                        return prefix;
                    }
                }
                prefix += character;
            }
        }
        return prefix;
    }

}
