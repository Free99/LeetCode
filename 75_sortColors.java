public class Solution {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        int idx0 = 0;
        int idx1 = 0;
        for (int i=0; i<A.length; i++) {
            int v = A[i];
            A[i] = 2;
            if (v == 0) {
                A[idx1++] = 1;
                A[idx0++] = 0;
            } else if (v == 1) {
                A[idx1++] = 1;
            }
        }
    }
}