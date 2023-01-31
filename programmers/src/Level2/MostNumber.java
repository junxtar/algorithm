package Level2;

import java.util.Arrays;
import java.util.Comparator;

public class MostNumber {
	// 가장 큰수
	public String solution(int[] numbers) {
		String answer = "";
		// 문자열 배열로 변환
		String[] strnumbers = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
		// 문자열로 변환한 숫자의 값이 큰 값을 기준으로 내림차순
		Arrays.sort(strnumbers, new Comparator<String>() {
			// @override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});
		// 결과값을 answer에 담기
		for (int i = 0; i < strnumbers.length; i++) {
			answer += strnumbers[i];
		}
		// 0, 0 으로 이루어졌다고 가정하면 결과값은 00이므로 이는 0으로 치환
		return answer.charAt(0) == '0' ? "0" : answer;
	}
}