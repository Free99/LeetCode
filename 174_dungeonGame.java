public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon==null || dungeon.length==0 ||dungeon[0].length==0) {
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = Math.max(0-dungeon[m-1][n-1], 0);
        for (int i=m-2; i>=0; i--) {
            dp[i][n-1] = Math.max(dp[i+1][n-1]-dungeon[i][n-1], 0);
        }
        for (int i=n-2; i>=0; i--) {
            dp[m-1][i] = Math.max(dp[m-1][i+1]-dungeon[m-1][i], 0);
        }
        for (int i=m-2; i>=0; i--) {
            for (int j=n-2; j>=0; j--) {
                dp[i][j] = Math.max(Math.min(dp[i][j+1], dp[i+1][j])-dungeon[i][j], 0);
            }
        }
        return dp[0][0]+1;
    }
}