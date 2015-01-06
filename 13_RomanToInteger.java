public class Solution {
    public int romanToInt(String s) {
        int[] map = new int[256];
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
        char[] c = s.toCharArray();
        int res = map[c[0]];
        for (int i=0; i<c.length-1; i++) {
            if (map[c[i]] >= map[c[i+1]]) {
                res += map[c[i+1]];
            } else {
                res += map[c[i+1]] - 2*map[c[i]];
            }
        }
        return res;
    }
}