public class StringToInteger implements Runnable {

    @Override
    public void run() {
        String input = "-1";
        System.out.println(atoi(input));
    }

    public int atoi(String string) {
        int result = 0;
        int sign = 1;
        int extremeValue = Integer.MAX_VALUE;

        // find first digit
        int start = 0;
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (' ' == character) {
                continue;
            } else if (isDigit(character)) {
                start = i;
                break;
            } else if ('+' == character) {
                start = i + 1;
                break;
            } else if ('-' == character) {
                sign = -1;
                extremeValue = Integer.MIN_VALUE;
                start = i + 1;
                break;
            } else {
                return result;
            }
        }

        for (int i = start; i < string.length(); i++) {
            char character = string.charAt(i);
            if (isDigit(character)) {
                int digit = Character.getNumericValue(character) - Character.getNumericValue('0');
                if (sign * (extremeValue / 10) < sign * result) {
                    return extremeValue;
                } else if (extremeValue / 10 == result && sign * (sign * digit) % 10 > sign * (extremeValue % 10)) {
                    // overflow
                    return extremeValue;
                } else {
                    result = result * 10 + sign * digit;
                }
            } else {
                break;
            }
        }

        return result;
    }

    private boolean isDigit(char character) {
        return character >= '0' && character <= '9';
    }

}
