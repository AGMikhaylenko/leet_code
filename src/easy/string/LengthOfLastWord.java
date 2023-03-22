package easy.string;

/**
 * https://leetcode.com/problems/length-of-last-word/
 *  Runtime 44.77% Memory 25.53%
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "      ";
        System.out.println(new LengthOfLastWord().lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        String [] words =  s.trim().split(" ");
        return words[words.length-1].trim().length();
    }
}
