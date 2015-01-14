public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        if (S == null) {
            return null;
        }
        Arrays.sort(S);
        return helper(S, S.length-1);
    }
    private List<List<Integer>> helper(int[] S, int index) {
        if (index == -1) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> elem = new ArrayList<Integer>();
            res.add(elem);
            return res;
        }
        List<List<Integer>> res = helper(S,index-1);
        int size = res.size();
        for (int i=0; i<size; i++) {
            List<Integer> elem = new ArrayList<Integer>(res.get(i));
            elem.add(S[index]);
            res.add(elem);
        }
        return res;
    }
}


public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        if (S == null || S.length == 0) {
            return res;
        }
        Arrays.sort(S);
        for (int i=0; i<S.length; i++) {
            int size = res.size();
            for (int j=0; j<size; j++) {
                List<Integer> item = new ArrayList<Integer>(res.get(j));
                item.add(S[i]);
                res.add(item);
            }
        }
        return res;
    }
}