public class IntegerToRoman implements Runnable {

    @Override
    public void run() {
        System.out.println(intToRoman(2016));
    }

    public String intToRoman(int num) {
        if (num < 0 || num > 3999) {
            throw new IllegalStateException("Input number should be between 0 to 3999");
        }

        String[] ranks = new String[] {"IVX", "XLC", "CDM", "M??"};
        StringBuilder stringBuilder = new StringBuilder();
        int rank = 0;
        while (num > 0) {
            String numeral = ranks[rank];
            int remainder = num % 10;
            if (remainder % 5 == 4) {
                char base = numeral.charAt(remainder / 5 + 1);
                stringBuilder.append(base).append(numeral.charAt(0));
            } else {
                for (int i = 0; i < remainder % 5; i++) {
                    stringBuilder.append(numeral.charAt(0));
                }
                if (remainder >= 5) {
                    stringBuilder.append(numeral.charAt(1));
                }
            }
            num = num / 10;
            rank++;
        }
        return stringBuilder.reverse().toString();
    }

}
