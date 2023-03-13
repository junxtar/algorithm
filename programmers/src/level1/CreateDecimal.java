package level1;

public class CreateDecimal {

	public int solution(int[] nums) {
		// 1000 + 999 + 998 = 2997
		int answer = 0;
		
		boolean[] prime = new boolean[2998];
		prime[0] = prime[1] = true;
		for (int i = 2; i * i < prime.length; i++) {
			if (!prime[i]) {
				for (int j = i * i; j < prime.length; j += i) {
					prime[j] = true;
				}
			}
		}
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (!prime[nums[i] + nums[j] + nums[k]])
						answer++;
				}
			}
		}
		return answer;
	}
}