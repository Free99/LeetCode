public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) {
            return 0;
        }
        for (int i=triangle.size()-2; i>=0; i--) {
            for (int j=0; j<triangle.get(i).size(); j++) {
                triangle.get(i).set(j, triangle.get(i).get(j)+
                                    Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[] res = new int[triangle.size()];
        int len = triangle.size()-1;
        for (int i=0; i<triangle.get(len).size(); i++) {
            res[i] = triangle.get(len).get(i);
        }
        for (int i=triangle.size()-2; i>=0; i--) {
            for (int j=0; j<triangle.get(i+1).size()-1; j++) {
                res[j] = triangle.get(i).get(j) + 
                         Math.min(res[j], res[j+1]);
            }
        }
        return res[0];
    }
}