package easy.array;

/**
 * https://leetcode.com/problems/design-parking-system/
 * Runtime 100% Memory 48.52%
 */
public class DesignParkingSystem {

    class ParkingSystem {

        int[] spaces = new int[3];

        public ParkingSystem(int big, int medium, int small) {
            spaces[0] = big;
            spaces[1] = medium;
            spaces[2] = small;
        }

        public boolean addCar(int carType) {
            return spaces[carType - 1]-- > 0;
        }
    }
}
