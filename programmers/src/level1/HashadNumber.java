package level1;

public class HashadNumber {
	public boolean solution(int x) {
		String values = String.valueOf(x);
		int value = 0;
		
		for (int i = 0; i < values.length(); i++) {
			value += values.charAt(i) - '0';
		}
		
		return x % value == 0;
	}
}
