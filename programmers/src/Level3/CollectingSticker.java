package Level3;

import java.util.Arrays;

public class CollectingSticker {
	// 스티커 모으기 (DP)
	public int solution(int sticker[]) {
		// 배열의 크기가 3이하이면 그중 가장 큰 값 리턴
		if (sticker.length < 4)
			return Arrays.stream(sticker).max().getAsInt();
		// 첫번째 스티커를 기준으로 떼지 않는 경우와 떼는 경우로 메소드 호출한 후 둘 중 큰 수를 리턴
		return Math.max(dp(sticker.length - 1, sticker), dp(sticker.length, sticker));
	}

	static int dp(int end, int[] sticker) {
		int[] dp = new int[sticker.length];
		// 첫번째 스티커를 떼지않으면 배열의 마지막 요소포함 O
		if (end == sticker.length) {
			dp[1] = sticker[1];
		} // 첫번째 스티커를 떼면 배열의 마지막 요소포함 x
		else {
			dp[0] = sticker[0];
			dp[1] = sticker[0];
		}
		for (int i = 2; i < end; i++) {
			dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
		}
		return Arrays.stream(dp).max().getAsInt();
	}
}