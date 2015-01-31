public class TwoSum {
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
	public void add(int number) {
	    map.put(number, map.containsKey(number)?map.get(number)+1:1);
	}

	public boolean find(int value) {
	    for (int key : map.keySet()) {
	        int x = value-key;
	        if (x==key&&map.get(key)>1 || x!=key&&map.containsKey(x)) {
	            return true;
	        }
	    }
	    return false;
	}
}