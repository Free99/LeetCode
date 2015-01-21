public class Solution {
    public int numDistinct(String S, String T) {
        if (T.length()==0) {
            return 1;
        }
        if (S.length()==0) {
            return 0;
        }
        int[] res = new int[T.length()+1];
        res[0] = 1;
        for (int i=0; i<S.length(); i++) {
            for (int j=T.length()-1; j>=0; j--) {
                res[j+1] = (S.charAt(i)==T.charAt(j) ? res[j]:0)+res[j+1];
            }
        }
        return res[T.length()];
    }
}