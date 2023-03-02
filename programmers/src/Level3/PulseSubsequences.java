package Level3;

public class PulseSubsequences {

	static long answer;
	static long[] temp;

	public long solution(int[] sequence) {

		temp = compose(sequence, true);
		answer = temp[0];
		search();
		temp = compose(sequence, false);
		answer = Math.max(answer, temp[0]);
		search();

		return answer;
	}

	static long[] compose(int[] sequence, boolean flag) {
		long[] seq = new long[sequence.length];
		int number = flag ? 1 : -1;
		for (int i = 0; i < sequence.length; i++) {
			seq[i] = sequence[i] * number;
			number *= -1;
		}
		return seq;
	}

	static void search() {
		for (int i = 1; i < temp.length; i++) {
			temp[i] = Math.max(temp[i], temp[i] + temp[i - 1]);
			answer = Math.max(temp[i], answer);
		}
	}
}
