public class Solution {
    public int maxSubArray(int[] A) {
        int max = A[0];
        int maxEndHere = A[0];
        for (int i=1; i<A.length; i++) {
            maxEndHere = Math.max(A[i], maxEndHere+A[i]);
            max = Math.max(max, maxEndHere);
        }
        return max;
    }
}


public class Solution {
    public int maxSubArray(int[] A) {
        int len = A.length;
        if (len == 0) {
            return 0;
        }
        int curSum = A[0];
        int max = A[0];
        for (int i=1; i<len; i++) {
            if (curSum < 0) {
                curSum = A[i];
            } else {
                curSum += A[i];
            }
            max = Math.max(max, curSum);
        }
        return max;
    }
}