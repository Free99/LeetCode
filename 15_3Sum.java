public class Solution {
	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		int len = num.length;

		int i = 0;
		while (i <= len - 3) {
			while (i - 1 >= 0 && i <= len - 3 && num[i] == num[i - 1]) {
				i++;
				continue;
			}
			int left = i + 1, right = len - 1;
			while (left < right) {
				int sum = num[i] + num[left] + num[right];
				if (sum == 0) {
					List<Integer> a1 = new ArrayList<Integer>();
					a1.add(num[i]);
					a1.add(num[left]);
					a1.add(num[right]);
					ret.add(a1);
					do {
						left++;
					} while (left < right && num[left] == num[left - 1]);
					do {
						right--;
					} while (left < right && num[right] == num[right + 1]);
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
			i++;
		}
		return ret;
	}
}