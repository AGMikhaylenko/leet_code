package medium.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 * Runtime 13.41% Memory 47.60%
 */
public class FlattenNestedListIterator implements Iterator<Integer> {

    final List<Integer> queue = new ArrayList<>();

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        prepareQueue(nestedList, queue);
    }

    private void prepareQueue(List<NestedInteger> nestedList, List<Integer> queue) {
        for (NestedInteger element : nestedList) {
            if (element.isInteger()) {
                queue.add(element.getInteger());
            } else {
                prepareQueue(element.getList(), queue);
            }
        }
    }

    @Override
    public Integer next() {
        return queue.remove(0);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public interface NestedInteger {

        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }

}
