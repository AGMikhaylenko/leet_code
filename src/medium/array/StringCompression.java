package medium.array;

/**
 * https://leetcode.com/problems/string-compression/
 * Runtime 98.42% Memory 57.67%
 */
public class StringCompression {

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'b'};
        System.out.println(new StringCompression().compress(chars));
    }

    public int compress(char[] chars) {
        short buf = 0;
        short index = 0;
        byte n = 0;
        for (int i = 0; i < chars.length; i++) {
            buf++;
            if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
                chars[index] = chars[i];
                if (buf != 1) {
                    n = getCountByNumber(buf);
                    index += n;
                    while (buf != 0) {
                        chars[index--] = (char) (buf % 10 + 48);
                        buf /= 10;
                    }
                    index += n;
                }
                index++;
                buf = 0;
            }
        }
        return index;
    }

    private byte getCountByNumber(int number) {
        byte res = 0;
        while (number != 0) {
            res++;
            number /= 10;
        }
        return res;
    }
}
