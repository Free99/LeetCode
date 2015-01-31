public class Solution {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        int pre = lower-1;
        for (int i=0; i<A.length; i++) {
            if (A[i]!=pre+1) {
                
                if (A[i]-pre>2) {
                    res.add((pre+1)+"->"+(A[i]-1));
                } else {
                    res.add((pre+1)+"");
                }
            }
            pre = A[i];
        }
        if (pre!=upper) {
            if (pre+1!=upper) {
                res.add((pre+1)+"->"+upper);
            } else {
                res.add((pre+1)+"");
            }
            
        }
        return res;
    }
}