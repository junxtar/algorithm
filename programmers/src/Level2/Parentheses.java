package Level2;

//괄호판별 문제 
public class Parentheses {

	boolean solution(String s) {
		boolean answer = false;
		//count 라는 변수를 이용하여 문제를 해결 
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			//괄호가 열리면 count 증가 
			if(c == '(') {
				count++;
			}
			//괄호가 닫히면 count 감소 
			if(c == ')') {
				count--;
			}
			//열린 괄호보다 닫힌 괄호의 갯수가 많다면 break 
			if(count < 0) {
				break;
			}
		}
		//반복문이 지난 후 count의 갯수가 0이라면 올바른 괄호 
		if(count == 0) {
			answer = true;
		}
		return answer;
	}
}
