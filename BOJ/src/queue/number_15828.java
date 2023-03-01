package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class number_15828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> que = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		int size = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		while (num != -1) {
			if (num == 0)
				que.poll();
			else {
				if (size > que.size()) {
					que.offer(num);
				}
			}

			num = Integer.parseInt(br.readLine());
		}
		if (que.isEmpty()) {
			sb.append("empty");
		} else {
			for (int data : que) {
				sb.append(data + " ");
			}
		}
		System.out.println(sb);

	}

}
