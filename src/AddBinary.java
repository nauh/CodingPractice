public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        char carry = '0';
        while (aIndex >= 0 || bIndex >= 0) {
            char aChar = aIndex >= 0 ? a.charAt(aIndex) : '0';
            char bChar = bIndex >= 0 ? b.charAt(bIndex) : '0';
            if (aChar == '0' && bChar == '0') {
                sb.append(carry);
                carry = '0';
            } else if (aChar == '0' || bChar == '0') {
                sb.append(carry == '0' ? '1' : '0');
            } else {
                sb.append(carry == '0' ? '0' : '1');
                carry = '1';
            }
            aIndex--;
            bIndex--;
        }
        if (carry == '1') {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
    
}
