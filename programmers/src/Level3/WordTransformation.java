package Level3;

import java.util.LinkedList;
import java.util.Queue;

//단어 변환 
public class WordTransformation {
	static class Node {
		String str;
		int z;

		Node(String str, int z) {
			this.str = str;
			this.z = z;
		}
	}

	static boolean[] visited;

	public int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];
		return bfs(begin, target, words);

	}

	static int bfs(String begin, String target, String[] words) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(begin, 0));

		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (cur.str.equals(target)) {
				return cur.z;
			}
			for (int i = 0; i < words.length; i++) {
				int count = 0;
				if (!visited[i]) {
					for (int j = 0; j < words[i].length(); j++) {
						if (cur.str.charAt(j) == words[i].charAt(j)) {
							count++;
						}
					}
					if (count == words[i].length() - 1) {
						q.offer(new Node(words[i], cur.z + 1));
						visited[i] = true;
					}
				}
			}
		}
		return 0;
	}
}