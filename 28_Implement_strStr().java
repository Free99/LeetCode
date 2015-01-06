public class Soution {
	public String strStr(String haystack, String needle) {
		if (haystack == null || needle == null || needle.length() > haystack.length()) {
			return null;
		}
		int i = 0, j = 0;
		for (i = 0; i <= haystack.length() - needle.length(); i++) {
			for (j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
			}
			if (j == needle.length()) {
				return haystack.substring(i);
			}
		}
		return null;
	}	
}