public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        res.add("");
        if (digits==null || digits.length()==0) {
            return res;
        }
        for (int i=0; i<digits.length(); i++) {
            String letters = getLetters(digits.charAt(i));
            List<String> newRes = new ArrayList<String>();
            for (int j=0; j<res.size(); j++) {
                for (int k=0; k<letters.length(); k++) {
                    newRes.add(res.get(j)+Character.toString(letters.charAt(k)));
                }
            }
            res = newRes;
        }
        return res;
    }
    private String getLetters(char digit) {
        switch(digit) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            case '0':
                return " ";
            default:
                return "";
        }
    }
}

public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] map = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        List<String> res = new ArrayList<String>();
        helper(digits, map, res, new StringBuilder(), 0);
        return res;
    }
    private void helper(String digits, String[] map, List<String> res, StringBuilder sb, int pos) {
        if (pos == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String s = map[digits.charAt(pos)-'0'];
        for (int i=0; i<s.length(); i++) {
            sb.append(s.charAt(i));
            helper(digits, map, res, sb, pos+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}