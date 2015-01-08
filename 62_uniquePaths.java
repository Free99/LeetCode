public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[] res = new int[n];
        res[0] = 1;
        for (int i=0; i<m; i++) {
            for (int j=1; j<n; j++) {
                res[j] += res[j-1];
            }
        }
        return res[n-1];
    }
}


public class Solution {
    public int uniquePaths(int m, int n) {
        int N = n+m-2;
        int small = m<n? m:n;
        int k = small-1;
        double res = 1;
        for (int i=1; i<= k; i++) {
            res = res*(N-k+i)/i;
        }
        return (int)res;
    }
}