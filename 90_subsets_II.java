public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        if (num == null) {
            return null;
        }
        Arrays.sort(num);
        List<Integer> lastSize = new ArrayList<Integer>();
        lastSize.add(0);
        return helper(num, num.length-1, lastSize);
    }
    private List<List<Integer>> helper(int[] num, int index, List<Integer> lastSize) {
        if (index == -1) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> elem = new ArrayList<Integer>();
            res.add(elem);
            return res;
        }
        List<List<Integer>> res = helper(num, index-1, lastSize);
        int size = res.size();
        int start = 0;
        if (index>0 && num[index]==num[index-1]) {
            start = lastSize.get(0);
        }
        for (int i=start; i<size; i++) {
            List<Integer> elem = new ArrayList<Integer>(res.get(i));
            elem.add(num[index]);
            res.add(elem);
        }
        lastSize.set(0, size);
        return res;
    }
}

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        if (num==null || num.length==0) {
            return res;
        }
        Arrays.sort(num);
        int start = 0;
        for (int i=0; i<num.length; i++) {
            int size = res.size();
            for (int j=start; j<size; j++) {
                List<Integer> newItem = new ArrayList<Integer>(res.get(j));
                newItem.add(num[i]);
                res.add(newItem);
            }
            if (i<num.length-1 && num[i]==num[i+1]) {
                start = size;
            } else {
                start = 0;
            }
        }
        return res;
    }
}