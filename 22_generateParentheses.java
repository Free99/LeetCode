public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        if (n<=0) {
            return res;
        }
        helper(n,n,new String(), res);
        return res;
    }
    private void helper(int l, int r, String item, ArrayList<String> res) {
        if (r<l) {
            return;
        }
        if (l==0 && r==0) {
            res.add(item);
        }
        if (l>0) {
            helper(l-1,r,item+"(",res);
        }
        if (r>0) {
            helper(l,r-1,item+")",res);
        }
    }
}


public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) {
            res.add("");
        } else {
            for (int i=n-1; i>=0; i--) {
                List<String> insertSub = generateParenthesis(i);
                List<String> tailSub = generateParenthesis(n-1-i);
                for (String insert : insertSub) {
                    for (String tail : tailSub) {
                        res.add("("+insert+")"+tail);
                    }
                }
            }
        }
        return res;
        
    }
}