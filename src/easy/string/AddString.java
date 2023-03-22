package easy.string;

/**
 * https://leetcode.com/problems/add-strings/
 * Runtime 86.16% Memory 92.80%
 */
public class AddString {

    public String addStrings(String num1, String num2) {
        byte added = 0;
        StringBuilder sb = new StringBuilder();

        int val1;
        int val2;
        short index = 1;
        while (index <= num1.length() || index <= num2.length()) {
            val1 = index <= num1.length() ? num1.charAt(num1.length() - index) - 48 : 0;
            val2 = index <= num2.length() ? num2.charAt(num2.length() - index) - 48 : 0;

            sb.append((val1 + val2 + added) % 10);
            added = val1 + val2 + added >= 10 ? (byte) 1 : 0;

            index++;
        }

        if (added == 1) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}
