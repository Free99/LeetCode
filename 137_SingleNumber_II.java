public class Solution {
    public int singleNumber(int[] A) {
        int[] digits = new int[32];
        for (int i=0; i<32; i++) {
            for (int j=0; j<A.length; j++) {
                digits[i] += (A[j]>>i)&1;
            }
        }
        int res = 0;
        for (int i=0; i<32; i++) {
            res += (digits[i]%3)<<i;
        }
        return res;
    }
}



import java.util.Hashtable;
public class Solution {
    public int singleNumber(int[] A) {
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
        for (int i=0; i<A.length; i++) {
            Integer val = ht.get(A[i]);
            if(val != null) {
                ht.put(A[i], val+1);
                if (ht.get(A[i]) == 3) {
                    ht.remove(A[i]);
                }
            } else {
                ht.put(A[i], 1);
            }
        }
        for (Integer key : ht.keySet()) {
            if (ht.get(key) != 3) {
                return key;
            }
        }
        return -1;
    }
}