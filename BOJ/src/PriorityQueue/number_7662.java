package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class number_7662 {

	static TreeMap<Integer, Integer> tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (T-- > 0) {
			int K = Integer.parseInt(br.readLine());

			tree = new TreeMap<>();
			while (K-- > 0) {
				st = new StringTokenizer(br.readLine());
				char command = st.nextToken().charAt(0);
				int value = Integer.parseInt(st.nextToken());

				solution(command, value);
			}
			if (tree.size() == 0) {
				sb.append("EMPTY").append("\n");
			} else {
				sb.append(tree.lastKey() + " " + tree.firstKey()).append("\n");
			}
		}
		System.out.println(sb.toString());

	}

	static void solution(char command, int value) {
		if (command == 'I') {
			tree.put(value, tree.getOrDefault(value, 0) + 1);
			return;
		}
		if (tree.size() < 1) {
			return;
		}
		if (value == 1) {
			if (tree.get(tree.lastKey()) == 1) {
				tree.remove(tree.lastKey());
			} else {
				tree.put(tree.lastKey(), tree.get(tree.lastKey()) - 1);
			}
		} else {
			if (tree.get(tree.firstKey()) == 1) {
				tree.remove(tree.firstKey());
			} else {
				tree.put(tree.firstKey(), tree.get(tree.firstKey()) - 1);
			}
		}
	}
}
