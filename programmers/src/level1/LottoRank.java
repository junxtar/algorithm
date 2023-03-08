package level1;

public class LottoRank {

	public int[] solution(int[] lottos, int[] win_nums) {
		
		int zeroCount = 0;
		int targetCount = 0;
		
		for (int i = 0; i < lottos.length; i++) {
			int lotto = lottos[i];
			if (lotto == 0) {
				zeroCount++;
				continue;
			}
			for (int j = 0; j < win_nums.length; j++) {
				if (lotto == win_nums[j]) {
					targetCount++;
					break;
				}
			}
		}
		int bestRank = targetCount + zeroCount == 0 || targetCount + zeroCount == 1 ? 6 : 7 - (targetCount + zeroCount);
		int worstRank = targetCount == 0 || targetCount == 1 ? 6 : 7 - targetCount;
		return new int[] { bestRank, worstRank };
	}
}