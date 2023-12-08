package easy.string;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/keyboard-row/
 * Runtime 17.93% Memory 25.56%
 */
public class KeyboardRow {

    public String[] findWords(String[] words) {
        String [] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> res = new LinkedList<>();
        int first;
        boolean correct;
        for(String s: words){
            first = -1;
            correct = true;
            for(char c: s.toCharArray()){
                String sChar = String.valueOf(c).toLowerCase();
                if(first == -1){
                    for(int i =0;i< rows.length;i++){
                        if(rows[i].contains(sChar)){
                            first = i;
                        }
                    }
                }else{
                    if(!rows[first].contains(sChar)){
                        correct = false;
                    }
                }
            }
            if(correct){
                res.add(s);
            }
        }

        return res.stream().toArray(String[]::new);
    }
}
