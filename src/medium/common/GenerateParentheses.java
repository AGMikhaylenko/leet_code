package medium.common;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * Runtime 7.23% Memory 5.15%
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        return generateParenthesis(n, n);
    }

    private List<String> generateParenthesis(int opening, int closing) {
        List<String> r = new LinkedList<>();

        if (closing == 0) {
            return r;
        }

        if (opening > 0) {
            List<String> in = generateParenthesis(opening - 1, closing);
            for(String s: in){
                r.add("(" + s);
            }
        }

        if (closing > opening) {
            List<String> in = generateParenthesis(opening, closing - 1);
            if(in.isEmpty()){
                r.add(")");
            }
            for(String s: in){
                r.add(")" + s);
            }
        }

        return r;
    }
}
