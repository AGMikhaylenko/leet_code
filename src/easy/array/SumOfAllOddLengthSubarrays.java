package easy.array;

/**
 * https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
 * Runtime 62.82% Memory 38.33%
 */
public class SumOfAllOddLengthSubarrays {

    public static void main(String[] args) {
        int[] arr = {10, 11};
        int res = new SumOfAllOddLengthSubarrays().sumOddLengthSubarrays(arr);
        System.out.println(res);
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int step = 0; step < arr.length; step += 2) {

            for (int start = 0; start + step < arr.length; start++) {
                for (int i = start; i <= start + step; i++) {
                    sum += arr[i];
                }
            }
        }
        return sum;
    }
}
