package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class number_18258 {
	
	static void push(Deque<Integer>queue, int a) {
		queue.offer(a);
	}
	static int front(Deque<Integer>queue) {
		if(queue.isEmpty())
			return -1;
		return queue.peekFirst();
	}
	static int size(Deque<Integer>queue) {
		return queue.size();
	}
	static int empty(Deque<Integer>queue) {
		if(!queue.isEmpty())
			return 0;
		return 1;
	}
	static int back(Deque<Integer>queue) {
		if(queue.isEmpty()) {
			return -1;
		}else{
			
			return queue.peekLast();
		}
		
	}
	static int pop(Deque<Integer>queue) {
		if(!queue.isEmpty())
			return queue.poll();
		return -1;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer>queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		while(N-->0) {
			String command = br.readLine();
			if(command.startsWith("push")) {
				StringTokenizer st = new StringTokenizer(command);
				st.nextToken();
				push(queue, Integer.parseInt(st.nextToken()));
			}else if(command.equals("front")) 
				sb.append(front(queue)+"\n");
			else if(command.equals("back"))
				sb.append(back(queue)+"\n");
			else if(command.equals("size"))
				sb.append(size(queue)+"\n");
			else if(command.equals("empty"))
				sb.append(empty(queue)+"\n");
			else if(command.equals("pop"))
				sb.append(pop(queue)+"\n");
		}
		System.out.println(sb);
	}

}
