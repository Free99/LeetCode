public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers==null || numbers.length<2) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<numbers.length-1; i++) {
            int start = i+1, end = numbers.length-1, gap = target-numbers[i];
            while (start<=end) {
                int m = start + ((end-start)>>1);
                if (numbers[m]==gap) {
                    res[0] = i+1;
                    res[1] = m+1;
                    return res;
                } else if (numbers[m]>gap) {
                    end = m-1;
                } else {
                    start = m+1;
                }
            }
        }
        return null;
    }
}

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers==null || numbers.length<2) {
            return null;
        }
        int l = 0;
        int r = numbers.length-1;
        while (l<r) {
            if (numbers[l]+numbers[r]==target) {
                return new int[] {l+1, r+1};
            } else if (numbers[l]+numbers[r]>target) {
                r--;
            } else {
                l++;
            }
        }
        return null;
    }
}