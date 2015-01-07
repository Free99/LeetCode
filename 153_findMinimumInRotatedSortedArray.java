public class Solution {
    public int findMin(int[] num) {
        int l = 0;
        int r = num.length - 1;
        int m = 0;
        while (l<r) {
            m = l+(r-l)/2;
            if (num[m]>=num[l] && num[l]>num[r]) {
                l = m+1;
            } else {
                r = m;
            }
        }
        return num[r];
    }
}