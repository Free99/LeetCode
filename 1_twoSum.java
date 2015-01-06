import java.util.*; 

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
        int[] ret = {0, 0};
        for (int i = 0; i < numbers.length; i++) {
            Integer index = ht.get(target - numbers[i]);
            if (index != null) {
                ret[0] = index + 1;
                ret[1] = i + 1;
            }
            ht.put(numbers[i], i);
        }
        return ret;
    }
}
