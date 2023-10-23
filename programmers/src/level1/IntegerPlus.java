package level1;

public class IntegerPlus {
	public int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		for (int i = 0; i < absolutes.length; i++) {
			int value = absolutes[i];
			answer += signs[i] ? value : -1 * value;
		}
		return answer;
	}
}
