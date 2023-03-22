package easy.string;

/**
 * https://leetcode.com/problems/to-lower-case/
 * Runtime 100% Memory 63.4%
 */
public class ToLowerCase {

    public String toLowerCase(String s) {
        char[] sym = s.toCharArray();
        for (int i = 0; i < sym.length; i++) {
            int d = sym[i];
            if(d < 91 && d > 64){
                sym[i] = (char) (d + 32);
            }
        }
        return String.valueOf(sym);
    }
}
