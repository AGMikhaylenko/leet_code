package easy.string;

/**
 * https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 * Runtime 12.20% Memory 67.50%
 */
public class CheckIfTwoStringArraysAreEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int w1 = 0;
        int s1 = 0;
        int w2 = 0;
        int s2 = 0;

        boolean finish = false;

        while (!finish) {
            if (word1[w1].charAt(s1) != word2[w2].charAt(s2)) {
                return false;
            }
            s1++;
            s2++;
            if (word1[w1].length() == s1) {
                s1 = 0;
                w1++;
            }
            if (word2[w2].length() == s2) {
                s2 = 0;
                w2++;
            }

            if(word1.length == w1 ^ word2.length == w2){
                return false;
            }

            if(word1.length == w1 && word2.length == w2){
                finish = true;
            }
        }

        return true;
    }
}
