public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator==0) {
            return "";
        }
        if (numerator==0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        res.append((numerator^denominator)>>>31==1 ? "-":"");
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        res.append(n/d);
        if (n%d==0) {
            return res.toString();
        } else {
            res.append(".");
        }
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        
        while ((n %= d)>0) {
            if (map.containsKey(n)) {
                res.insert(map.get(n), "(");
                res.append(")");
                break;
            }
            map.put(n, res.length());
            n *= 10;
            res.append(n/d);
        }
        return res.toString();
    }
}