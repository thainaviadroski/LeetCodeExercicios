public class ExponentialSearch {
	public static void main(String[] args) {
		System.out.println("Vamos lá");
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40};
		int target = 22;
		int result = exponentialSearch(nums, target);
		System.out.println("Achei, tá na posição: " + result);
	}

	public static int exponentialSearch(int[] nums, int target) {
		if (nums[0] == target) {
			return 0;
		}
		int n = nums.length;
		int i = 1;
		while (i < n && nums[i] < target) {
			i *= 2;
		}
		if (i < n && nums[i] == target) {
			return i;
		}
		return binarySearch(nums, target, i / 2, Math.min(i, n - 1));
	}

	public static int binarySearch(int[] nums, int target, int left, int right) {
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
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
