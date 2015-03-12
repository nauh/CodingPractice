public class ZigZagConversion implements Runnable {

    @Override
    public void run() {
        String input = "PAYPALISHIRING";
        System.out.println(convert(input, 3));
    }

    public String convert(String s, int nRows) {
        if (nRows <= 1) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int step = (nRows - 1) * 2;
        for (int i = 0; i < nRows; i++) {
            int index = i;
            while (index < s.length()) {
                stringBuilder.append(s.charAt(index));
                int candidate = index + step - i * 2;
                if (i > 0 && i < nRows - 1 && candidate < s.length()) {
                    stringBuilder.append(s.charAt(candidate));
                }
                index += step;
            }
        }
        return stringBuilder.toString();
    }

}
