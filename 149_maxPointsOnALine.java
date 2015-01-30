/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points==null || points.length==0) {
            return 0;
        }
        if (allSamePoints(points)) {
            return points.length;
        }
        int max = 0;
        for (int i=0; i<points.length-1; i++) {
            for(int j=i+1; j<points.length; j++) {
                if (points[j].y==points[i].y && points[j].x==points[i].x) {
                    continue;
                }
                int cur = 2;
                for (int k=0; k<points.length; k++) {
                    if (k!=i && k!=j &&
                       (points[k].y-points[i].y)*(points[j].x-points[i].x)==
                        (points[j].y-points[i].y)*(points[k].x-points[i].x)) {
                        cur++;        
                    }
                }
                max = Math.max(max, cur);
            }
        }
        return max;
    }
    private boolean allSamePoints(Point[] points) {
        for (int i=1; i<points.length; i++) {
            if (points[0].y!=points[i].y || points[0].x!=points[i].x) {
                return false;
            }
        }
        return true;
    }
}


/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points==null || points.length==0) {
            return 0;
        }
        int max = 1;
        double ratio = 0.0;
        for (int i=0; i<points.length-1; i++) {
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            int numOfSame = 0;
            int localMax = 1;
            for (int j=i+1; j<points.length; j++) {
                if (points[j].x==points[i].x && points[j].y==points[i].y) {
                    numOfSame++;
                    continue;
                } else if (points[j].x==points[i].x) {
                    ratio = (double) Integer.MAX_VALUE;
                } else if (points[j].y==points[i].y) {
                    ratio = 0.0;
                } else {
                    ratio = (double) (points[j].y-points[i].y)/
                            (double) (points[j].x-points[i].x);
                }
                int num;
                if (map.containsKey(ratio)) {
                    num = map.get(ratio)+1;
                } else {
                    num = 2;
                }
                map.put(ratio, num);
            }
            for (Integer value : map.values()) {
                localMax = Math.max(localMax, value);
            }
            localMax += numOfSame;
            max = Math.max(max, localMax);
        }
        return max;
    }
}