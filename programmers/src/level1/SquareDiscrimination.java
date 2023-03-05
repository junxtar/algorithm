package level1;

public class SquareDiscrimination {

	public long solution(long n) {
		
		long answer = (int) Math.sqrt(n) + 1;
		return (Math.sqrt(n) % 1 == 0) ? (long) (Math.pow(answer, 2)) : -1;
	}
}