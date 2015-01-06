public class Solution {
    public static List<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        Search(n, 0, new int[n], res);
        return res;
    }
    
    public static void Search(int n, int r, int[] c, ArrayList<String[]> res) {
        if (r == n) {
            String[] board = new String[n];
            for (int i=0; i<n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j=0; j<n; j++) {
                    if (c[i] == j) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                board[i] = sb.toString();
            }
            res.add(board);
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