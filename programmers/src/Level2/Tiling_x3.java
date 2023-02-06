package Level2;

public class Tiling_x3 {

	// 3 * n 타일링
	public int solution(int n) {
		return dp(n);
	}

	static int dp(int n) {
		long[] dp = new long[n + 1];
		int mod = 1000000007;
		if (n < 2) {
			return 0;
		}
		if (n == 2) {
			return 3;
		}
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 3;
		for (int i = 4; i <= n; i++) {
			// 홀수 타일은 만들 수 있는 갯수 0개
			if (i % 2 == 1)
				continue;
			// dp[i - 4]와 dp[i - 2]의 관계를 알아야함
			// dp[i - 2]는 범위를 초과해서 음수가 될수 있음 따라서
			// 계산 후 한번더 mod를 더해준다.
			dp[i] = ((dp[i - 2] * 4 % mod) - (dp[i - 4] % mod) + mod) % mod;
		}
		return ((int) (dp[n] % mod));
	}
}