package Level2;

import java.util.Arrays;
import java.util.StringTokenizer;

public class MaxMin {
	
	// s에 들어있는 문자열 요소를 담을 정수형 배열을 선언 
	static int[] arr;

	public String solution(String s) {
		split(s);
		Arrays.sort(arr);
		return arr[0] + " " + arr[arr.length - 1];
	}

	//StringTokenizer를 이용하여 분리한 후 배열에 저장 
	public void split(String s) {
		StringTokenizer st = new StringTokenizer(s);
		arr = new int[st.countTokens()];
		int index = 0;
		while (st.hasMoreTokens()) {
			arr[index] = Integer.parseInt(st.nextToken());
			index++;
		}
	}
}
