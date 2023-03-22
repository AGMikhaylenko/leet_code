package easy.array;

/**
 * https://leetcode.com/problems/lemonade-change/
 * Runtime 18.75% Memory 32.93%
 */
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int[] cash = new int[3];

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                cash[0]++;
            }
            if (bills[i] == 10) {
                if (cash[0] == 0) {
                    return false;
                } else {
                    cash[0]--;
                    cash[1]++;
                }
            }
            if (bills[i] == 20) {
                if (cash[1] > 0) {
                    if (cash[0] > 0) {
                        cash[2]++;
                        cash[1]--;
                        cash[0]--;
                    } else {
                        return false;
                    }
                } else {
                    if (cash[0] >= 3) {
                        cash[2]++;
                        cash[0] -= 3;
                    }else{
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
