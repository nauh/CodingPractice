import java.util.ArrayList;
import java.util.List;

public class FractionToRecurringDecimal implements Runnable {

    @Override
    public void run() {
        System.out.println(fractionToDecimal(-1, -2147483648));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            result.append("-");
        }
        long numeratorLong = Math.abs((long) numerator);
        long denominatorLong = Math.abs((long) denominator);
        result.append(numeratorLong / denominatorLong);
        long reminder = numeratorLong % denominatorLong;
        if (reminder == 0) {
            return result.toString();
        }
        result.append(".");
        int currentLength = result.length();
        List<Long> reminders = new ArrayList<>();
        while (reminder != 0) {
            reminders.add(reminder);
            long digit = reminder * 10 / denominatorLong;
            result.append(digit);
            reminder = reminder * 10 - digit * denominatorLong;
            int reminderIndex = reminders.indexOf(reminder);
            if (reminderIndex >= 0) {
                result.insert(currentLength + reminderIndex, "(");
                result.append(")");
                break;
            }
        }
        return result.toString();
    }

}
