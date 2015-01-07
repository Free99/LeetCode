public class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int f1 = 1;
        int f2 = 2;
        int f3 = 0;
        for (int i=3; i<=n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }
}


public class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        ArrayList<Integer> map = new ArrayList<Integer>();
        map.add(0, new Integer(0));
        map.add(1, new Integer(1));
        map.add(2, new Integer(2));
        for (int i=3; i<=n; i++) {
            map.add(i, map.get(i-1)+map.get(i-2));
        }
        return (map.get(n)).intValue();
    }
}


public class Solution {
    public int climbStairs(int n) {
        double root5 = Math.sqrt(5);
        double phi = (1+root5)/2;
        return (int)Math.floor((Math.pow(phi,n+1)/root5)+0.5);
    }
}
