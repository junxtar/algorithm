package level1;

public class NewIDRecommendation {

	public String solution(String new_id) {
		String answer = "";
		// 1
		answer = new_id.toLowerCase();
		// 2
		answer = answer.replaceAll("[^0-9a-z-_.]", "");
		// 3
		answer = answer.replaceAll("\\.{2,}", ".");
		// 4
		answer = answer.replaceAll("^[.]|[.]$", "");
		// 5
		answer = answer.equals("") ? "a" : answer;
		// 6-1
		answer = answer.length() >= 16 ? answer.substring(0, 15) : answer;
		// 6-2
		answer = answer.replaceAll("[.]$", "");
		// 7
		char lastCh = answer.charAt(answer.length() - 1);
		if (answer.length() <= 2) {
			while (answer.length() < 3) {
				answer += lastCh;
			}
		}

		return answer;
	}
}