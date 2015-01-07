public class Solution {
    public String intToRoman(int num) {
        int[] map = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] r = {
                        "M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"
        };
        String rNum = "";
        for (int i=0; i<map.length; i++) {
            while (num >= map[i]) {
                rNum += r[i];
                num -= map[i];
            }
        }
        return rNum;
    }
}