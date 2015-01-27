public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()) {
            return false;
        }
        boolean[][] res = new boolean[s1.length()+1][s2.length()+1];
        res[0][0] = true;
        for (int i=0; i<=s1.length(); i++) {
            for (int j=0; j<=s2.length(); j++) {
                if (j>0 && s2.charAt(j-1)==s3.charAt(i+j-1) && res[i][j-1]) {
                    res[i][j] = true;
                } else if (i>0 && s1.charAt(i-1)==s3.charAt(i+j-1) && res[i-1][j]) {
                    res[i][j] = true;
                }
            }
        }
        return res[s1.length()][s2.length()];
    }
}