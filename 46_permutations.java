public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return res;
        }
        List<Integer> init = new ArrayList<Integer>();
        init.add(num[0]);
        res.add(init);
        for (int i=1; i<num.length; i++) {
            List<List<Integer>> newRes = new ArrayList<List<Integer>>();
            for (int j=0; j<res.size(); j++) {
                List<Integer> cur = res.get(j);
                for (int k=0; k<cur.size()+1; k++) {
                    List<Integer> item = new ArrayList<Integer>(cur);
                    item.add(k,num[i]);
                    newRes.add(item);
                }
            }
            res = newRes;
        }
        return res;
    }
}


public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return res;
        }
        helper(num, new boolean[num.length], new ArrayList<Integer>(), res);
        return res;
    }
    private void helper(int[] num, boolean[] used, ArrayList<Integer> item, 
                        List<List<Integer>> res) {
        if (item.size() == num.length) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i=0; i<num.length; i++) {
            if (!used[i]) {
                used[i] = true;
                item.add(num[i]);
                helper(num, used, item, res);
                item.remove(item.size()-1);
                used[i] = false;
            }
        }
    }
}w