package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_11003 {

	static class Node {
		int value;
		int idx;

		Node(int value, int idx) {
			this.value = value;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Deque<Node> deque = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			while (!deque.isEmpty() && deque.peekLast().value > value) {
				deque.pollLast();
			}
			deque.offer(new Node(value, i));
			if (deque.peek().idx < i - (L - 1)) {
				deque.poll();
			}
			sb.append(deque.peek().value).append(" ");

		}
		System.out.println(sb.toString());
	}

}
