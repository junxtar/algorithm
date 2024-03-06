package level1;

public class AddressingStrings {

	public boolean solution(String s) {
		if (s.length() != 4 && s.length() != 6) {
			return false;
		}
		String regex = "[^a-zA-Z]";
		s = s.replaceAll(regex, "");
		System.out.println(s);
		return s.length() == 0 ? true : false;
	}
}