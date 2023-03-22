package easy.binary;

/**
 * Easy
 * https://leetcode.com/problems/add-binary/
 */
public class AddBinary {

    byte nil = 0;
    byte one = 1;

    public static void main(String[] args) {
        String a = "1";
        String b = "11";

        System.out.println(new AddBinary().addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        char[] symbolsA = a.toCharArray();
        char[] symbolsB = b.toCharArray();

        int delta = symbolsA.length - symbolsB.length;

        byte added = 0;
        byte cA;
        byte cB;
        int buf;

        StringBuilder sb = new StringBuilder();

        for (int i = symbolsA.length - 1; i >= 0 || i >= delta; i--) {
            cA = i >= 0 ? convertCharToByte(symbolsA[i]) : nil;
            cB = i >= delta ? convertCharToByte(symbolsB[i - delta]) : nil;

            buf = cA + cB + added;
            added = buf > 1 ? one : nil;

            sb.append(buf % 2 == 0 ? '0' : '1');
        }
        if (added == 1) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }

    private byte convertCharToByte(char c) {
        return c == '0' ? nil : one;
    }
}
