package Sort;

import java.util.Arrays;

public class QuickSort {
    static void main() {
        int[] testArray = {10, 7, 8, 9, 1, 5};
        System.out.println(Arrays.toString(testArray));
        int[] sortedArray = quickSort(testArray);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] quickSort(int[] arr) {
        quickSortRecursive(arr, 0, arr.length - 1);
        return arr;
    }

    public static void quickSortRecursive(int[] arr, int l, int r) {
        if (l < r) {
            int pivot = partition(arr, l, r);
            quickSortRecursive(arr, l, pivot - 1);
            quickSortRecursive(arr, pivot + 1, r);
        }
    }

    public static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;

        for (int j = l; j < r; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = tmp;

        return i + 1;
    }

}
