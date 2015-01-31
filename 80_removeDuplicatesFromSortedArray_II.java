public class Solution {
    public int removeDuplicates(int[] A) {
        if (A==null || A.length==0) {
            return 0;
        }
        if (A.length<=2) {
            return A.length;
        }
        int idx = 2;
        int count = 0;
        for (int i=2; i<A.length; i++) {
            if (A[i] != A[idx-2]) {
                A[idx++]=A[i];
            }
        }
        return idx;
    }
}