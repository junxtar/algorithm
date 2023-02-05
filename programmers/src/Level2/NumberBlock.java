package Level2;

public class NumberBlock {
	// 숫자 블록
	public int[] solution(long begin, long end) {
		int s = (int) begin;
		int e = (int) end;
		int[] answer = new int[e - s + 1];
		for (int i = s; i <= e; i++) {
			answer[i - s] = find(i);
		}
		return answer;
	}

	// 에라토스테네스의 체 활용
	static int find(int n) {
		// 값이 1이면 소수가 아님
		if (n == 1)
			return 0;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0 && (n / i) <= 10000000) {
				return (n / i);
			}
		}
		return 1;
	}
}