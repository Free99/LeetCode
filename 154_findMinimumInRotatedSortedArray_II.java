public class Solution {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int l = 0;
        int r = num.length-1;
        int mid = 0;
        while (l<r) {
            mid = l+((r-l)>>1);
            if (num[mid]<num[r]) {
                r=mid;
            } else if (num[mid]>num[r]) {
                l=mid+1;
            } else {
                r--;
            }
        }
        return num[l];
    }
}

public class Solution {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int l = 0;
        int r = num.length-1;
        int min = num[0];
        while (l<r-1) {
            int m = l+((r-l)>>1);
            if (num[l]<num[m]) {
                min = Math.min(num[l],min);
                l=m+1;
            } else if (num[l]>num[m]) {
                min = Math.min(num[m],min);
                r=m-1;
            } else {
                l++;
            }
        }
        min = Math.min(num[r],min);
        min = Math.min(num[l],min);
        return min;
    }
}