public class ExcelSheetColumnNumber implements Runnable {

    @Override
    public void run() {
    }

    public int titleToNumber(String s) {
        int result = 0;
        if (s == null || s.isEmpty()) {
            return result;
        }
        int base = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            result += (s.charAt(i) - 'A' + 1) * base;
            base *= 26;
        }
        return result;
    }

}
