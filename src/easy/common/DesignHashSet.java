package easy.common;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/design-hashset/
 */
public class DesignHashSet {

    List<Integer> list;

    public DesignHashSet() {
        list = new LinkedList<>();
    }

    public void add(int key) {
        if(!contains(key)){
            list.add(key);
        }
        System.gc();
    }

    public void remove(int key) {
        if(contains(key)){
            list.remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        for (Integer i : list) {
            if (i == key) {
                return true;
            }
        }
        return false;
    }
}
