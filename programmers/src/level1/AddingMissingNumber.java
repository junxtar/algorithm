package level1;

public class AddingMissingNumber {
	public int solution(int[] numbers) {
		int answer = 45; // 1 ~ 9의 합
		for (int number : numbers) {
			answer -= number;
		}
		return answer;
	}
}
