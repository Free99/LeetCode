/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> ret = new ArrayList<Interval>();
		if (intervals.size() == 0) {
			return ret;
		}

		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		Interval merged = new Interval(intervals.get(0).start, intervals.get(0).end);
		for (int i = 1; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (cur.start <= merged.end) {
				merged = new Interval(Math.min(merged.start, cur.start), Math.max(merged.end, cur.end));
			} else {
				ret.add(merged);
				merged = cur;
			}
		}
		ret.add(merged);
		return ret;
	}
}