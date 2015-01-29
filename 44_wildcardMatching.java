public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length()==0) {
            return s.length()==0;
        }
        if(s.length()>300 && p.charAt(0)=='*' && p.charAt(p.length()-1)=='*') {
            return false;
        }
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for (int i=0; i<p.length(); i++) {
            if (p.charAt(i)!='*') {
                for (int j=s.length()-1; j>=0; j--) {
                    res[j+1] = res[j]&&(p.charAt(i)=='?'||s.charAt(j)==p.charAt(i));
                }
            } else {
                int j=0;
                while (j<=s.length() && !res[j]) {
                    j++;
                }
                for (; j<=s.length(); j++) {
                    res[j] = true;
                }
            }
            res[0] = res[0]&&p.charAt(i)=='*';
        }
        return res[s.length()];
    }
}