package Level2;

public class NextLargeNumber {
	public int solution(int n) {
		// Integer 1비트의 갯수를 리턴해주는 bitCount를 사용
		int count = Integer.bitCount(n);
		// 최대 범위는 2배가 넘을 수 없음
		// ex) 2 4 8 16 32
		// 1과 다른 나머지는 0으로 이루어진 이진수는 0을 추가해줘야 하므로 최대 두배 이하이다.
		for (int i = n + 1; i <= n * 2; i++) {
			int bitCount = Integer.bitCount(i);
			if (bitCount == count)
				return i;
		}
		return -1;
	}
}