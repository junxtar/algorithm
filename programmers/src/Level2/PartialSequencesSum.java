package Level2;

public class PartialSequencesSum {

	public int[] solution(int[] sequence, int k) {
		int left = 0;
		int right = 0;
		int answerL = 0;
		int answerR = 0;
		int sum = 0;
		int distance = Integer.MAX_VALUE;

		for (right = 0; right < sequence.length; right++) {
			sum += sequence[right];

			while (sum > k) {
				sum -= sequence[left++];
			}

			if (sum == k) {
				if (right - left < distance) {
					distance = right - left;
					answerR = right;
					answerL = left;
				}
			}
		}

		return new int[] { answerL, answerR };
	}
}
