public class ExcelSheetColumnTitle implements Runnable {

    @Override
    public void run() {
        System.out.println(convertToTitle(52090943));
    }

    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            int reminder = (n - 1) % 26;
            result.append((char) ('A' + reminder));
            n = (n - reminder - 1) / 26;
        }
        return result.reverse().toString();
    }

}
