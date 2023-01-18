package Level2;

public class Teleportation {
	// top-down 방식으로 문제를 위에서 아래로 해결하였다.
	public int solution(int n) {
		int answer = 0;
		while (n > 0) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n -= 1;
				answer++;
			}
		}
		return answer;
	}
}
