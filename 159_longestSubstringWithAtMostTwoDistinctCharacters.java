public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s==null || s.length()==0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int max = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else if (map.size()<2) {
                map.put(c, 1);
            } else {
                while (map.size()==2 && start<i) {
                    char temp = s.charAt(start);
                    int x = map.get(temp);
                    if (--x==0) {
                        map.remove(temp);
                    } else {
                        map.put(temp, x);
                    }
                    ++start;
                }
                map.put(c, 1);
            }
            max = Math.max(max, i-start+1);
        }
        return max;
    }
}