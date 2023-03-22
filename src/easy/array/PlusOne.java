package easy.array;

/**
 * https://leetcode.com/problems/plus-one/description/
 * Runtime 100% Memory 71.30%
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        boolean end = false;
        byte i = (byte) (digits.length - 1);
        while (!end && i >= 0) {
            if (digits[i] + 1 == 10) {
                digits[i] = 0;
            } else {
                digits[i]++;
                end = true;
            }
            i--;
        }

        if(!end){
            int [] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }else {
            return digits;
        }
    }
}
