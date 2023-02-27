package Level2;

public class CountryOf124Numbers {

	public String solution(int n) {
		String answer = "";
		String[] arr = { "4", "1", "2" };

		while (n > 0) {
			int remainder = n % 3;
			n /= 3;
			if (remainder == 0)
				n--;
			answer = arr[remainder] + answer;
		}
		return answer;
	}
}