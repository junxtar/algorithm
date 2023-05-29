package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class number_2493 {
	
	static class Node {
		int value;
		int index;
		
		Node (int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Node> values = new Stack<>();
		Stack<Integer> result = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			int value = Integer.parseInt(st.nextToken());
			values.push(new Node(value, i));
		}
		int flag = values.pop().value;
		
		while (!values.isEmpty()) {
			Node cur = values.pop();
			cnt+=1;
			if (flag < cur.value) {
				flag = cur.value;
				for (int i = 0 ; i < cnt; i ++) {
					result.push(cur.index);
				}
				cnt = 0;
				continue;
			}
		}
		for (int i = 0; i <= cnt; i++) {
			result.push(0);
		}
		
		while (!result.isEmpty()) {
			sb.append(result.pop()).append(" ");
		}
		System.out.println(sb.toString());
	}
}
