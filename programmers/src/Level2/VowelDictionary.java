package Level2;

import java.util.ArrayList;
import java.util.List;

public class VowelDictionary {

	private char[] alp = { 'A', 'E', 'I', 'O', 'U' };
	private List<String> list = new ArrayList<>();

	public int solution(String word) {
		dfs("", 0);
		return list.indexOf(word);
	}

	private void dfs(String word, int depth) {
		list.add(word);
		if (depth == alp.length) {
			return;
		}
		for (int i = 0; i < alp.length; i++) {
			dfs(word + alp[i], depth + 1);
		}
	}
}
