package Level2;

//이진 변환 반복하기 
public class BinaryConversion {

	public int[] solution(String s) {
		int zeroCount = 0;
		int count = 0;
		
		while (!s.equals("1")) {
			count++;
			String value = "";
			
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '1') {
					value += s.charAt(i);
				} else {
					zeroCount++;
				}
			}
			s = Integer.toBinaryString(value.length());
		}
		return new int[] { count, zeroCount };

	}
}