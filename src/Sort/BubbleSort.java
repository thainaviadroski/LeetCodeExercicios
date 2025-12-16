package Sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {

    /*
     * Time complexity: O(N^2)
     * Space complexity: O(1)
     * */

    static void main() {
        int[] arr = {4,2,5,6,7,9,3,1};
        bubbleSort(arr);
    }


    public static void bubbleSort(int[] nums) {
        System.out.println("Entrou assim: " + Arrays.toString(nums));

        for (int i = 0; i < nums.length - 1; i++) {
            System.out.println(Arrays.toString(nums));
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        System.out.println("Saiu assim: " + Arrays.toString(nums));
    }

}
