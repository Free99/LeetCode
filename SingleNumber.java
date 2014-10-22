public class Solution {
    public int singleNumber(int[] A) {
        if (A.length < 1 || A.length % 2 != 1) {
            return -1;
        }
        int ans = A[0];
        for (int i = 1; i < A.length; i++) {
            ans ^= A[i];
        }
        return ans;
    }
}
