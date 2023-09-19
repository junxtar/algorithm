package Level2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RotateParentheses {
	static HashMap<Character, Character> map = new HashMap<>();
	static Queue<Character> q = new LinkedList<>();

	public int solution(String s) {
		int answer = 0;
		settingMap();
		settingQueue(s);

		for (int i = 0; i < s.length(); i++) {
			if (isProperBracket()) {
				answer++;
			}
			q.offer(q.poll());
		}
		return answer;

	}

	static void settingMap() {
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
	}

	static void settingQueue(String s) {
		for (char c : s.toCharArray()) {
			q.offer(c);
		}
	}

	static boolean isProperBracket() {
		Stack<Character> stack = new Stack<>();
		for (Character c : q) {
			if (map.containsKey(c)) {
				stack.push(c);
				continue;
			}
			if (stack.isEmpty() || map.get(stack.pop()) != c) {
				return false;
			}
		}
		return stack.isEmpty();
	}
}