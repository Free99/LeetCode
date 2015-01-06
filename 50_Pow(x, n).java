public class Solution {
	public double pow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		boolean neg = false;
		if (n < 0) {
			neg = true;
			n = -n;
		}
		double half = pow (x, n/2);
		double ret = 0;
		if ((n & 1) == 0) {
			ret = half * half;
		} else {
			ret = half * half * x;
		}

		if (neg) {
			ret = 1.0 / ret;
		}
		return ret;
	}
}