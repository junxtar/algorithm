package Level2;

public class TargetNumber {
	// 타겟 넘버
	public int solution(int[] numbers, int target) {
		return dfs(0, 0, numbers, target);
	}

	static int dfs(int depth, int sum, int[] numbers, int target) {
		if (depth == numbers.length) {
			if (sum == target) {
				return 1;
			}
			return 0;
		}
		return dfs(depth + 1, sum - numbers[depth], numbers, target)
				+ dfs(depth + 1, sum + numbers[depth], numbers, target);
	}
}