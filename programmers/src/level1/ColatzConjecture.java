package level1;

public class ColatzConjecture {

	public int solution(int num) {
		int answer = 0;
		
		while (num != 1) {
			if (answer == 500)
				return -1;
			answer++;
			num = num % 2 == 1 ? num * 3 + 1 : num / 2;
		}
		
		return answer;
	}
}