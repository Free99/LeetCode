public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s==null || s.length()==0) {
            return true;
        }
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for (int i=0; i<s.length(); i++) {
            for (int j=0; j<=i; j++) {
                String str = s.substring(j, i+1);
                if (res[j] && dict.contains(str)) {
                    res[i+1] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
}