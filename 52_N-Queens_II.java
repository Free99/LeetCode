public class Solution {
    public int totalNQueens(int n) {
        int[] res={0};
        Search(n, 0, new int[n], res);
        return res[0];
    }
    
    public void Search(int n, int r, int[] c, int[] res) {
        if (r == n) {
            res[0]++;
            return;
        }
        for (int i=0; i<n; i++) {
            c[r] = i;
            boolean ok = true;
            for (int j=0; j<r; j++) {
                if (c[r]==c[j] || r-j==c[r]-c[j] || r-j==c[j]-c[r]) {
                    ok = false;
                    break;
                }
            }
            if(ok) {
                Search(n, r+1, c, res);
            }
        }
    }
}