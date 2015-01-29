public class Solution {
    public String largestNumber(int[] num) {
        if (num==null || num.length==0) {
            return "";
        }
        String[] sNum = new String[num.length];
        for (int i=0; i<num.length; i++) {
            sNum[i] = num[i]+"";
        }
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1+str2;
                String s2 = str2+str1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(sNum, comp);
        if(sNum[0].charAt(0)=='0') {
            return "0";
        }
        String res = "";
        for (String s : sNum) {
            res += s;
        }
        return res;
    }
}