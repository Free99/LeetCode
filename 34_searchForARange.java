public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = {-1,-1};
        if (A==null || A.length==0) {
            return res;
        }
        int ll = 0;
        int lr = A.length-1;
        while (ll<=lr) {
            int m = ll+((lr-ll)>>1);
            if (A[m]<target) {
                ll = m+1;
            } else {
                lr = m-1;
            }
        }
        int rl = 0;
        int rr = A.length-1;
        while (rl<=rr) {
            int m = rl+((rr-rl)>>1);
            if (A[m]<=target) {
                rl = m+1;
            } else {
                rr = m-1;
            }
        }
        if (ll <= rr) {
            res[0] = ll;
            res[1] = rr;
        }
        return res;
    }
}