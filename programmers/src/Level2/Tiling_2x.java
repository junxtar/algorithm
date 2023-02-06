package Level2;

public class Tiling_2x {

	// 2 x n 타일링
	public int solution(int n) {
		return dp(n);
	}

	// dp
	static int dp(int n) {
		int[] dp = new int[n + 1];
		// n이 2보다 작으면 1리턴
		if (n < 2) {
			return 1;
		}
		// 점화식 dp[i] = dp[i - 1] + dp[i - 2]
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] % 1000000007 + dp[i - 2] % 1000000007;
		}
		return dp[n] % 1000000007;
	}
}