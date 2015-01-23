public class Solution {
    public int maximumGap(int[] num) {
        if (num==null || num.length<2){
            return 0;
        }
        int min = num[0];
        int max = num[0];
        for (int i:num) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int gap = (max-min-1)/(num.length-1)+1;
        int[] bucketsMin = new int[num.length-1];
        int[] bucketsMax = new int[num.length-1];
        Arrays.fill(bucketsMin, Integer.MAX_VALUE);
        Arrays.fill(bucketsMax, Integer.MIN_VALUE);
        for (int i:num) {
            if (i==min || i==max) {
                continue;
            }
            int idx = (i-min)/gap;
            bucketsMin[idx] = Math.min(i, bucketsMin[idx]);
            bucketsMax[idx] = Math.max(i, bucketsMax[idx]);
        }
        int maxGap = Integer.MIN_VALUE;
        int prev = min;
        for (int i=0; i<num.length-1; i++) {
            if (bucketsMin[i]==Integer.MAX_VALUE && bucketsMax[i]==Integer.MIN_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, bucketsMin[i]-prev);
            prev = bucketsMax[i];
        }
        maxGap = Math.max(maxGap, max-prev);
        return maxGap;
    }
}