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
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> ret = new ArrayList<Interval>();

		for (int i = 0; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (newInterval.start <= cur.start) {
				if (cur.start <= newInterval.end) {
					newInterval = new Interval(Math.min(newInterval.start, cur.start), Math.max(newInterval.end, cur.end));
				} else {
					ret.add(newInterval);
					newInterval = cur;
				}
			} else {
				if(newInterval.start <= cur.end) {
					newInterval = new Interval(Math.min(newInterval.start, cur.start), Math.max(newInterval.end, cur.end));
				} else {
					ret.add(cur);
				}
			}
		}

		ret.add(newInterval);
		return ret;
	}
}