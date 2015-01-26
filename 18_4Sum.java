public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num==null || num.length==0) {
            return res;
        }
        Arrays.sort(num);
        for (int i=num.length-1; i>2; i--) {
            if (i==num.length-1 || num[i]!=num[i+1]) {
                if (i==num.length-1 || num[i]!=num[i+1]) {
                    List<List<Integer>> curRes = threeSum(num, i-1, target-num[i]);
                    for (int j=0; j<curRes.size(); j++) {
                        curRes.get(j).add(num[i]);
                    }
                    res.addAll(curRes);
                }
            }
        }
        return res;
    }
    private List<List<Integer>> threeSum(int[] num, int end, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i=end; i>1; i--) {
            if (i==end || num[i]!=num[i+1]) {
                List<List<Integer>> curRes = twoSum(num, i-1, target-num[i]);
                for (int j=0; j<curRes.size(); j++) {
                    curRes.get(j).add(num[i]);
                }
                res.addAll(curRes);
            }
        }
        return res;
    }
    private List<List<Integer>> twoSum(int[] num, int end, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int l = 0;
        int r = end;
        while (l<r) {
            if (num[l]+num[r]==target) {
                List<Integer> item = new ArrayList<Integer>();
                item.add(num[l]);
                item.add(num[r]);
                res.add(item);
                l++;
                r--;
                while (l<r && num[l]==num[l-1]) {
                    l++;
                }
                while (l<r && num[r]==num[r+1]) {
                    r--;
                }
            } else if (num[l]+num[r]>target) {
                r--;
            } else {
                l++;
            }
        }
        return res;
    }
}


public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int len = num.length;
        Arrays.sort(num);
        for (int i=0; i<len; i++) {
            if (i>=1 && i<len && num[i]==num[i-1]) {
                continue;
            }
            for (int j=i+1; j<len; j++) {
                if (j>=i+2 && j<len && num[j]==num[j-1]) {
                    continue;
                }
                int left = j+1;
                int right = len-1;
                while (left<right) {
                    int sum = num[i]+num[j]+num[left]+num[right];
                    if (sum==target) {
                        List<Integer> al = new ArrayList<Integer>();
                        al.add(num[i]);
                        al.add(num[j]);
                        al.add(num[left]);
                        al.add(num[right]);
                        ret.add(al);
                        do {
                            left++;
                        } while (left<right && num[left]==num[left-1]);
                        do {
                            right--;
                        } while (left<right && num[right]==num[right+1]);
                    } else if (sum<target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ret;
    }
}


public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        HashMap<Integer, ArrayList<ArrayList<Integer>>> dict = new HashMap<>();
        for (int i=0; i<num.length-1; i++) {
            for (int j=i+1; j<num.length; j++) {
                int sum = num[i]+num[j];
                ArrayList<Integer> pair = new ArrayList<>(2);
                pair.add(i);
                pair.add(j);
                if (!dict.containsKey(sum)) {
                    ArrayList<ArrayList<Integer>> value = new ArrayList<>();
                    value.add(pair);
                    dict.put(sum, value);
                } else {
                    ArrayList<ArrayList<Integer>> value = dict.get(sum);
                    value.add(pair);
                }
            }
        }
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for (Integer sum:dict.keySet()) {
            ArrayList<ArrayList<Integer>> sumPair = dict.get(sum);
            if (dict.containsKey(target-sum)) {
                if (target-sum==sum && sumPair.size()==1) {
                    continue;
                }
                ArrayList<ArrayList<Integer>> pairs = dict.get(target-sum);
                for (ArrayList<Integer> pair1:sumPair) {
                    for (ArrayList<Integer> pair2:pairs) {
                        if (pair1==pair2) {
                            continue;
                        }
                        if (pair1.contains(pair2.get(0)) || pair1.contains(pair2.get(1))) {
                            continue;
                        }
                        ArrayList<Integer> tmpResult = new ArrayList<>(4);
                        tmpResult.add(num[pair1.get(0)]);
                        tmpResult.add(num[pair1.get(1)]);
                        tmpResult.add(num[pair2.get(0)]);
                        tmpResult.add(num[pair2.get(1)]);
                        Collections.sort(tmpResult);
                        set.add(tmpResult);
                    }
                }
            }
        }
        List<List<Integer>> ret = new LinkedList<>();
        ret.addAll(set);
        return ret;
    }
}