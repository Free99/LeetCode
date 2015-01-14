public class Solution {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        int res = 1;
        for (int i=0; i<num.length; i++) {
            set.add(num[i]);
        }
        while (!set.isEmpty()) {
            Iterator iter = set.iterator();
            int item = (Integer)iter.next();
            set.remove(item);
            int len = 1;
            int i = item-1;
            while(set.contains(i)) {
                set.remove(i--);
                len++;
            }
            i = item+1;
            while (set.contains(i)) {
                set.remove(i++);
                len++;
            }
            if (len>res) {
                res = len;
            }
        }
        return res;
    }
}