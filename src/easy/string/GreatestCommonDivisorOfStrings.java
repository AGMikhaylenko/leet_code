package easy.string;

import java.util.Objects;

/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/
 * Runtime 87.42% Memory 8.54%
 */
public class GreatestCommonDivisorOfStrings {

    public static void main(String[] args) {
        String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX", str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        System.out.println(new GreatestCommonDivisorOfStrings().gcdOfStrings(str1, str2));
    }

    public String gcdOfStrings(String str1, String str2) {
        if (!Objects.equals(str1 + str2, str2 + str1)) {
            return "";
        }

        int min = Integer.min(str1.length(), str2.length());
        while (str1.length() % min != 0
                || str2.length() % min != 0) {
            min--;
        }

        return str1.substring(0, min);
    }
}
