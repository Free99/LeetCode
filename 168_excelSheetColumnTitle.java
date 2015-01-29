public class Solution {
    public String convertToTitle(int n) {
        if (n<=0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        while (n>0) {
            n--;
            res.insert(0,(char)('A'+n%26));
            n /= 26;
        }
        return res.toString();
    }
}