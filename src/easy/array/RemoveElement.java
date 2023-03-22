package easy.array;

/**
 * https://leetcode.com/problems/remove-element/
 * Runtime 100% Memory 23.31%
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        new RemoveElement().removeElement(nums, 3);
    }

    public int removeElement(int[] nums, int val) {
        byte shift = 0;
        boolean change;
        int i = 0;
        for (; i < nums.length - shift; i++) {
            if (nums[i] == val) {
                change = false;
                while (!change && i < nums.length - shift) {
                    if (nums[nums.length - 1 - shift] != val) {
                        nums[i] = nums[nums.length - 1 - shift];
                        change = true;
                    }
                    shift++;
                }
                if(!change){
                    break;
                }
            }
        }
        System.out.println("s");
        return i;
    }
}
