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

		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Stack<Node> values = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		Node[] arr = new Node[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int value = Integer.parseInt(st.nextToken());
			arr[i - 1] = new Node(value, i);
		}

		for (int i = 0; i < N; i++) {
			while (!values.isEmpty() && values.peek().value < arr[i].value) {
				values.pop();
			}
			if (values.isEmpty()) {
				values.push(arr[i]);
				sb.append(0).append(" ");
				continue;
			}
			sb.append(values.peek().index).append(" ");
			values.push(arr[i]);

		}
		System.out.println(sb.toString());
	}
}
