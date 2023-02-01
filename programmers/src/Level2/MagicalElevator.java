package Level2;

public class MagicalElevator {
	public int solution(int storey) {
		int answer = 0;
		while (storey != 0) {
			int upperNumber = (storey % 100) / 10; // 현재 + 1자릿 수
			int number = storey % 10; // 현재 자릿 수
			// 현재 자릿 수가 5보다 크거나 같고 현재 + 1 자릿 수가 5보다 크거나 같으면 숫자를 10c형태로 만들어줌
			if (number > 5 || number == 5 && upperNumber >= 5) {
				storey += 10;
				answer += (10 - number);
			//아닐 경우에는 0으로 만들어줌 
			} else {
				answer += number;
			}
			storey = storey / 10;
		}
		return answer;
	}
}