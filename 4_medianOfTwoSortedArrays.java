public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        if((A.length+B.length)%2==1) {
            return helper(A,B,0,A.length-1,0,B.length-1,(A.length+B.length)/2+1);
        } else {
            return (helper(A,B,0,A.length-1,0,B.length-1,(A.length+B.length)/2)  
                   +helper(A,B,0,A.length-1,0,B.length-1,(A.length+B.length)/2+1))/2.0;
        }
    }
    private int helper(int A[], int B[], int i, int i2, int j, int j2, int k) {
        int m = i2-i+1;
        int n = j2-j+1;
        if (m>n) {
            return helper(B, A, j, j2, i, i2, k);
        }
        if (m==0) {
            return B[j+k-1];
        }
        if (k==1) {
            return Math.min(A[i], B[j]);
        }
        int partA = Math.min(k/2, m);
        int partB = k-partA;
        if (A[i+partA-1]==B[j+partB-1]) {
            return A[i+partA-1];
        } else if (A[i+partA-1]<B[j+partB-1]) {
            return helper(A, B, i+partA, i2, j, j+partB-1, k-partA);
        } else {
            return helper(A, B, i, i+partA-1, j+partB, j2, k-partB);
        }
    }
}