package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class number_2164 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer>queue = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i<=N; i++) {
			queue.offer(i);
		}
		int result = 0;
		while(true) {
			if(queue.size()==1) {
				result = queue.peek();
				break;
			}
			queue.poll();
			int num = queue.poll();
			queue.offer(num);
			
		}
		System.out.println(result);
	}

}
