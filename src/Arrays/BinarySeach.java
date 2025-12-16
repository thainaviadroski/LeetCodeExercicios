package Arrays;

public class BinarySeach {
    public static void main(String[] args) {
        int[] nums10 = {1, 4, 6, 9, 12, 17, 25, 33, 48, 50, 69};
        int[] nums20 = {1, 3, 7, 10, 15, 21, 30, 34, 42, 49, 56, 60, 69, 72, 81, 90, 150, 300, 500, 900, 1200};
        int[] nums40 = {1, 2, 4, 5, 6, 7, 10, 13, 16, 19, 23, 25, 28, 31, 34, 38, 42, 47, 52, 56, 61, 65, 69, 72, 75, 78, 81, 85, 87, 88, 95, 103, 150, 207, 344, 556, 1024, 2048, 3444, 5555, 9999};
        int[] nums80 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57, 60, 64, 68, 72, 76, 80, 85, 90, 95, 100, 110, 120, 130, 140, 150, 155, 160, 170, 180, 190, 200, 210, 230, 250, 275, 300, 325, 350, 375, 400, 450, 500, 550, 600, 700, 800, 900, 1000, 1200, 1400, 1600, 1800, 2000, 2500, 3000, 3500, 4000, 5000, 6000, 7000, 8000, 9999};

        System.out.println(binarySearch(nums10, 9));
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length ;
        int steps = 0;
        while (left < right) {
            steps++;
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                System.out.println("steps:" + steps);
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
