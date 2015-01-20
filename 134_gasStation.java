public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas==null || gas.length==0 || cost==null || cost.length==0) {
            return -1;
        }
        int total = 0;
        int sum = 0;
        int pointer = -1;
        for (int i=0; i<gas.length; i++) {
            int diff = gas[i]-cost[i];
            sum += diff;
            total += diff;
            if (sum<0) {
                sum = 0;
                pointer = i;
            }
        }
        return total>=0 ? pointer+1:-1;
    }
}


public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] remain = new int[gas.length];
        for (int i=0; i<gas.length; i++) {
            remain[i] = gas[i]-cost[i];
        }
        for (int i=0; i<gas.length; i++) {
            int capacity = 0;
            int j = i;
            boolean complete = true;
            do {
                capacity += remain[j];
                if (capacity<0) {
                    complete = false;
                    break;
                }
                j++;
                if (j==gas.length) {
                    j = 0;
                }
            } while(i!=j);
            if (complete) {
                return i;
            }
        }
        return -1;
    }
}