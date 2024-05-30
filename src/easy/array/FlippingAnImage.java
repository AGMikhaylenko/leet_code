package easy.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/flipping-an-image/
 */
public class FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] image) {
        int[] buf = new int[image.length];

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image.length; j++) {
                buf[buf.length - 1 - j] = image[i][j] == 1 ? 0 : 1;
            }
            image[i] = Arrays.copyOf(buf, buf.length);
        }

        return image;
    }
}
