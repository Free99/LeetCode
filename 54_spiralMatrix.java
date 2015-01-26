public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix==null || matrix.length==0 || matrix[0].length==0) {
            return res;
        }
        int min = Math.min(matrix.length, matrix[0].length);
        int levelNum = min/2;
        for (int level=0; level<levelNum; level++) {
            for (int i=level; i<matrix[0].length-level-1; i++) {
                res.add(matrix[level][i]);
            }
            for (int i=level; i<matrix.length-level-1; i++) {
                res.add(matrix[i][matrix[0].length-level-1]);
            }
            for (int i=matrix[0].length-1-level;i>level;i--) {
                res.add(matrix[matrix.length-level-1][i]);
            }
            for (int i=matrix.length-level-1; i>level; i--) {
                res.add(matrix[i][level]);
            }
        }
        if (min%2==1) {
            if (matrix.length<matrix[0].length) {
                for (int i=levelNum; i<matrix[0].length-levelNum; i++) {
                    res.add(matrix[levelNum][i]);
                }
            } else {
                for (int i=levelNum; i<matrix.length-levelNum; i++) {
                    res.add(matrix[i][levelNum]);
                }
            }
        }
        return res;
    }
}