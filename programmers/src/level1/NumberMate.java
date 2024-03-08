package level1;

public class NumberMate {

	static int[] x = new int[10];
	static int[] y = new int[10];

	public String solution(String X, String Y) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < X.length(); i++) {
			x[Character.getNumericValue(X.charAt(i))]++;
		}
		for (int i = 0; i < Y.length(); i++) {
			y[Character.getNumericValue(Y.charAt(i))]++;
		}

		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < Math.min(x[i], y[i]); j++) {
				sb.append(i);
			}
		}

		if (sb.length() == 0) {
			return "-1";
		}

		return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
	}
}
