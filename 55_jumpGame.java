public class Solution {
    public boolean canJump(int[] A) {
        if (A==null || A.length==0) {
            return false;
        }
        int reach = 0;
        for (int i=0; i<=reach&&i<A.length; i++) {
            reach = Math.max(A[i]+i,reach);
        }
        if (reach<A.length-1) {
            return false;
        } else {
            return true;
        }
    }
}