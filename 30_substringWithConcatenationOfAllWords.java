public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        if (S==null || S.length()==0 || L==null || L.length==0) {
            return res;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, Integer> found = new HashMap<String,Integer>();
        int cntL = 0;
        for (String str:L) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str)+1);
            } else {
                map.put(str, 1);
                cntL++;
            }
        }
        int wordLen = L[0].length();
        
        for (int i=0; i<=S.length()-L.length*wordLen; i++) {
            found.clear();
            int cnt = 0;
            for (int j=i; j<=S.length()-wordLen; j+=wordLen) {
                String temp = S.substring(j, j+wordLen);
                if (!map.containsKey(temp)) {
                    break;
                }
                if (found.containsKey(temp)) {
                    found.put(temp, found.get(temp)+1);
                } else {
                    found.put(temp, 1);
                }
                if (found.get(temp)>map.get(temp)) {
                    break;
                }
                cnt++;
                if (cnt==L.length) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}