public class Solution {
    public String reverseWords(String s) {
        if (s==null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        
        String temp = s.trim();
        String[] str = temp.split("\\s+");
        for (int i=str.length-1; i>=0; i--) {
            sb.append(str[i]);
            if (i!=0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}


public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        return helper(s, 0).toString();
    }
    private StringBuilder helper(String s, int index) {
        if (index>=s.length()) {
            return new StringBuilder();
        }
        StringBuilder cur = new StringBuilder();
        int lastIndex = index;
        while (index<s.length()&&s.charAt(index)!=' ') {
            cur.append(s.charAt(index++));
        }
        while (index<s.length()&&s.charAt(index)==' ') {
            index++;
        }
        if (lastIndex==0) {
            return helper(s, index).append(cur);
        }
        return helper(s, index).append(cur).append(' ');
    }
}