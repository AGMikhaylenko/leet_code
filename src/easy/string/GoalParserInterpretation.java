package easy.string;

/**
 * https://leetcode.com/problems/goal-parser-interpretation/
 * Runtime 100% Memory 41.26%
 */
public class GoalParserInterpretation {

    public static void main(String[] args) {
        var res = new GoalParserInterpretation().interpret("(al)G(al)()()G");
        System.out.println(res);
    }

    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();

        char[] symbols = command.toCharArray();
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] == 'G') {
                sb.append('G');
            } else {
                if (symbols[i + 1] == ')') {
                    sb.append('o');
                    i++;
                } else {
                    sb.append("al");
                    i += 3;
                }
            }
        }

        return sb.toString();
    }
}
