package medium.operations_with_numbers;

import java.util.ArrayList;
import java.util.List;

/**
 *  https://leetcode.com/problems/reverse-integer/
 *  Runtime 35.43% Memory 88.12%
 */
public class ReverseInteger {

    public static void main(String[] args) {
        int x = -2147483648;
        int res = new ReverseInteger().reverse(x);
        System.out.println(res);
    }

    static List<Byte> max = new ArrayList<>();

    static {
        int x = Integer.MAX_VALUE;
        while (x != 0) {
            max.add((byte) (x % 10));
            x /= 10;
        }
    }

    public int reverse(int x) {
        boolean isNegative = x < 0;

        List<Byte> digits = new ArrayList<>();

        while (x != 0) {
            digits.add((byte) Math.abs(x % 10));
            x /= 10;
        }

        if (digits.size() == 10 && !check(digits, isNegative)) {
            return 0;
        }

        byte power = (byte) (digits.size() - 1);
        for (Byte b : digits) {
            x += b * Math.pow(10, power--);
        }

        return isNegative ? -1 * x : x;
    }

    private boolean check(List<Byte> digits, boolean isNegative) {
        if (isNegative) {
            max.remove(0);
            max.add(0, (byte) 8);
        }

        for(int i =0;i<digits.size();i++){
            if(digits.get(i).equals(max.get(9 - i))){
                continue;
            }
            remakeMax();
            if(digits.get(i) > max.get(9 - i)){
                return false;
            }
            return true;
        }

        remakeMax();
        return true;
    }

    private void remakeMax(){
        max.remove(0);
        max.add(0, (byte) 7);
    }
}
