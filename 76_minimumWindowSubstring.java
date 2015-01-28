public class Solution {
    public String minWindow(String S, String T) {
        if (S.length()==0 || T.length()==0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String mins = "";
        int min = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int[] tofind = new int[256];
        int[] found = new int[256];
        for (int i=0; i<T.length(); i++) {
            tofind[T.charAt(i)]++;
        }
        int count = 0;
        for(; right<S.length(); right++) {
            if (tofind[S.charAt(right)]==0) {
                continue;
            }
            char c = S.charAt(right);
            found[c]++;
            if (found[c]<=tofind[c]) {
                count++;
            }
            if (count==T.length()) {
                while(tofind[S.charAt(left)]==0 || found[S.charAt(left)]>tofind[S.charAt(left)]) {
                    if (found[S.charAt(left)]>tofind[S.charAt(left)]) {
                        found[S.charAt(left)]--;
                    }
                    left++;
                }
                if (right-left+1<min) {
                    min = right-left+1;
                    mins = S.substring(left, right+1);
                }
            }
        }
        return mins;
    }
}