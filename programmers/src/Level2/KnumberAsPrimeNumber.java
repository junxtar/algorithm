package Level2;

public class KnumberAsPrimeNumber {

	public int solution(int n, int k) {
		int primeCount = 0;
		long currentValue = 0;
		String kNumber = Integer.toString(n, k);
		for (int i = 0; i < kNumber.length(); i++) {
			char digit = kNumber.charAt(i);
			if (digit == '0') {
				primeCount += isPrime(currentValue);
				currentValue = 0;
			} else {
				currentValue = currentValue * 10 + digit - '0';
			}
		}
		primeCount += isPrime(currentValue);
		return primeCount;
	}

	private int isPrime(long number) {
		if (number < 2) {
			return 0;
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return 0;
			}
		}
		return 1;
	}
}
