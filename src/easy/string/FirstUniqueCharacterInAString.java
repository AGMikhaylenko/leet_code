package easy.string;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * Runtime 65.27% Memory 68.19%
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        char[] symbols = s.toCharArray();

        boolean isUnique;
        for (int i = 0; i < symbols.length; i++) {
            isUnique = true;
            for (int j = 0; j < symbols.length; j++) {
                if (j != i && symbols[i] == symbols[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                return i;
            }
        }
        return -1;
    }
}
