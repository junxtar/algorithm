package level1;

public class SumOfTwoIntegers {
	
	public long solution(int a, int b) {
		
		long max = Math.max(a, b);
		long min = Math.min(a, b);
		
		return ((max - min + 1) * (max + min)) / 2;
	}
}