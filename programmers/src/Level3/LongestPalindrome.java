package Level3;

import java.util.Arrays;
import java.util.Stack;

public class LongestPalindrome {

	// 가장 긴 펠린드롬
	public int solution(String s) {
		// 문자열을 새로 정의 할 것이다.
		// why? ->
		// 1) a b a 같은 경우는 앞뒤로 판별가능
		// 2) a b b a 같은 경우 짝수개이므로 앞뒤 판별 불가능
		// 그러한 이유로 양옆으로 임의의 기호 추가 --- ex) #, *, $, @ 
		// 홀수와 짝수의 가장 큰 차이는 홀수에 짝수를 더하면 홀수이고 짝수에 홀수를 더하면 홀수이다.
		// #을 추가하면
		// 1) # a # b # a # -> 홀수
		// 2) # a # b # b # a # -> 홀수
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			str += "#";
			str += s.charAt(i);
		}
		str += "#";
		// 정수형 배열 선언 크기는 새로운 정의한 문자열의 길이
		int[] arr = new int[str.length()];
		// 만약에 앞뒤로 문자열이 같다면 펠린드롬이 가능한 것이므로 1로 초기화
		for (int i = 1; i < arr.length - 1; i++) {
			if (str.charAt(i - 1) == str.charAt(i + 1)) {
				arr[i] = 1;
			}
		}
		// 배열의 값이 1이면 search()
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i] == 1) {
				arr[i] = search(i, str);
			}
		}
		return Arrays.stream(arr).max().getAsInt();
	}

	// 정수를 반환하는 search메서드 정의
	static int search(int index, String str) {
		Stack<Character> stack = new Stack<>();
		int count = 0;
		// 0부터 index(arr[index]==1인 index)까지 stack에 push
		for (int i = 0; i < index; i++) {
			stack.push(str.charAt(i));
		}
		// index+1 부터 길이 까지 돌면서 stack에 pop의 value와 다음 문자열이 같은지 파악
		for (int i = index + 1; i < str.length(); i++) {
			if (stack.isEmpty()) {
				break;
			}
			if (stack.pop() != str.charAt(i)) {
				break;
			}
			// 값이 같으면 count++
			count++;
		}
		return count;

	}
}
