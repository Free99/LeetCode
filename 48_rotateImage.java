public class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        if (matrix == null || len == 0) {
            return;
        }
        for (int i=0; i<len/2; i++) {
            for (int j=0; j<len; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len-1-i][j];
                matrix[len-1-i][j] = tmp;
            }
        }
        for (int i=0; i<len; i++) {
            for (int j=i+1; j<len; j++) {
                int tmp = matrix[i][j];  
                matrix[i][j] = matrix[j][i];  
                matrix[j][i] = tmp;  
            }
        }
    }
}


public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int layerNum = matrix.length/2;
        for (int layer=0; layer<layerNum; layer++) {
            for (int i=layer; i<matrix.length-layer-1; i++) {
                int tmp = matrix[layer][i];
                matrix[layer][i] = matrix[matrix.length-1-i][layer];
                matrix[matrix.length-1-i][layer] = matrix[matrix.length-1-layer][matrix.length-1-i];
                matrix[matrix.length-1-layer][matrix.length-1-i] = matrix[i][matrix.length-1-layer];
                matrix[i][matrix.length-1-layer] = tmp;
            }
        }
    }
}