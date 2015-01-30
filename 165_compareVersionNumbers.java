public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i=0, j=0;
        for (; i<v1.length&&j<v2.length; i++,j++) {
            if (Integer.parseInt(v1[i])>Integer.parseInt(v2[j])) {
                return 1;
            } else if (Integer.parseInt(v1[i])<Integer.parseInt(v2[j])) {
                return -1;
            }
        }
        for (; i<v1.length; i++) {
            if (Integer.parseInt(v1[i])!=0) {
                return 1;
            }
        }
        for (; i<v2.length; i++) {
            if (Integer.parseInt(v2[i])!=0) {
                return -1;
            }
        }
        return 0;
    }
}