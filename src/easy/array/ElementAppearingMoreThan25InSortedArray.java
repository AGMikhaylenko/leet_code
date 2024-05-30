package easy.array;

/**
 * https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 * Runtime 100% Memory 58.02%
 */
public class ElementAppearingMoreThan25InSortedArray {

    public int findSpecialInteger(int[] arr) {
        final int rangeSize = arr.length / 4 + 1;
        int currentRange = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i] == arr[i - 1]) {
                currentRange++;
                if (currentRange >= rangeSize) {
                    return arr[i];
                }
            } else {
                currentRange = 1;
            }
        }

        return arr[arr.length - 1];
    }
}
