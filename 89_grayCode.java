public class Solution {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (n<0) {
            return res;
        }
        res.add(0);
        for (int i=0; i<n; i++) {
            int inc = 1<<i;
            int size = res.size();
            for (int j=size-1; j>=0; j--) {
                res.add(res.get(j)+inc);
            }
        }
        return res;
    }
}


public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        if(n==0) {
            ArrayList<Integer> res = new ArrayList<Integer>();
            res.add(0);
            return res;
        }
        
        ArrayList<Integer> tmp = grayCode(n-1);
        int addNumber = 1 << (n-1);
        ArrayList<Integer> res = new ArrayList<Integer>(tmp);
        for (int i=tmp.size()-1; i>=0; i--) {
            res.add(addNumber+tmp.get(i));
        }
        return res;
    }
}