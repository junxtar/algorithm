package level1;

public class CaesarPassword {

	public String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == ' ') {
				sb.append(" ");
				continue;
			}
			int diff = Character.isUpperCase(ch) ? 'A' : 'a';

			ch = (char) (((ch + n) - diff) % 26 + diff);
			sb.append(ch);
		}
		return sb.toString();
	}
}
