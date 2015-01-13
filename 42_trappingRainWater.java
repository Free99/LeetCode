public class Solution {
    public int trap(int[] A) {
        if (A==null || A.length==0) {
            return 0;
        }
        int max = 0;
        int res = 0;
        int[] container = new int[A.length];
        for (int i=0; i<A.length; i++) {
            container[i] = max;
            max = Math.max(max,A[i]);
        }
        max = 0;
        for (int i=A.length-1; i>=0; i--) {
            container[i] = Math.min(max,container[i]);
            max = Math.max(max,A[i]);
            res += container[i]-A[i]>0? container[i]-A[i]:0;
        }
        return res;
    }
}

public class Solution {
    public int trap(int[] A) {
        if (A==null || A.length==0) {
            return 0;
        }
        int l = 0;
        int r = A.length-1;
        int res = 0;
        while(l<r) {
            int min = Math.min(A[l],A[r]);
            if (A[l] == min) {
                l++;
                while(l<r && A[l]<min) {
                    res += min-A[l];
                    l++;
                }
            } else {
                r--;
                while(l<r && A[r]<min) {
                    res += min-A[r];
                    r--;
                }
            }
        }
        return res;
    }
}