package Level2;

import java.util.HashSet;

public class FindPrimeNumber {

	private boolean[] visited;
	private HashSet<Integer> set = new HashSet<>();

	public int solution(String numbers) {
		visited = new boolean[numbers.length()];
		dfs(numbers, "", 0);
		return getCount();
	}

	private void dfs(String numbers, String s, int depth) {
		if (depth > numbers.length()) {
			return;
		}
		for (int i = 0; i < numbers.length(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				set.add(Integer.parseInt(s + numbers.charAt(i)));
				dfs(numbers, s + numbers.charAt(i), depth + 1);
				visited[i] = false;
			}
		}
	}

	private int getCount() {
		int answer = 0;
		for (int value : set) {
			if (isPrime(value)) {
				answer++;
			}
		}
		return answer;
	}

	private boolean isPrime(int number) {
		if (number < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}