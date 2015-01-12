public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int l = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int r = row*col-1;
        while (l<=r) {
            int mid = l+((r-l)>>1);
            if (matrix[mid/col][mid%col] == target) {
                return true;
            }
            if (matrix[mid/col][mid%col] > target) {
                r=mid-1;
            } else {
                l=mid+1;
            }
        }
        return false;
    }
}

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int l = 0;
        int r = matrix.length-1;
        while (l<=r) {
            int mid = l+((r-l)>>1);
            if (matrix[mid][0] == target) {
                return true;
            }
            if (matrix[mid][0] > target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        int row = r;
        if (row < 0) {
            return false;
        }
        l = 0;
        r = matrix[0].length-1;
        while (l<=r) {
            int mid = l+((r-l)>>1);
            if (matrix[row][mid] == target) {
                return true;
            }
            if (matrix[row][mid] > target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return false;
    }
}