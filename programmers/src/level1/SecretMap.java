package level1;

import java.util.Arrays;

public class SecretMap {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		char[][] visited = new char[n][n];
		for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], ' ');
        }
		
		searchMap(arr1, visited);
		searchMap(arr2, visited);
		
		for (int i = 0; i < answer.length; i++) {
			String temp = "";
			for (char c : visited[i]) {
				temp += c;
			}
			answer[i] = temp;
		}
		return answer;
	}

	static char[][] searchMap(int[] arr, char[][] visited) {
		for (int i = 0; i < arr.length; i++) {
			String value = fillBlank(binaryScale(arr[i]), arr.length);
			System.out.println(value);
			for (int j = 0; j < value.length(); j++) {
				if (visited[i][j] == ' ' && value.charAt(j) == '1')
					visited[i][j] = '#';
			}
		}
		return visited;
	}

	static String binaryScale(int number) {
		String answer = "";
		while (number > 0) {
			answer += "" + number % 2;
			number /= 2;
		}
		return answer;
	}

	static String fillBlank(String number, int length) {
		StringBuilder sb = new StringBuilder();
		sb.append(number);
		for (int i = 0; i < length - number.length(); i++) {
			sb.append("0");
		}
		sb.reverse();
		return sb.toString();
	}
	
}