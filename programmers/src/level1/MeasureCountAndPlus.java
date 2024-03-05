package level1;

public class MeasureCountAndPlus {
	public int solution(int left, int right) {
		int answer = 0;
		for (int i = left; i <= right; i++) {
			if (Math.sqrt(i) % 1 == 0) {
				answer -= i;
				continue;
			}
			answer += i;
		}
		return answer;
	}
}
