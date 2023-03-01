package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class number_10866 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer>deque = new LinkedList<>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		while(n-->0) {
			
			String command = br.readLine();
			int num = 0;
			if(command.startsWith("push")) {
				st = new StringTokenizer(command);
				command = st.nextToken();
				num = Integer.parseInt(st.nextToken());
			}
			switch(command) {
			case "push_back":
				deque.offerLast(num);
				break;
			case "push_front":
				deque.offerFirst(num); 
				break;
			case "front":
				if(!deque.isEmpty()) 
					sb.append(deque.peekFirst()).append("\n");
				else
					sb.append(-1+"\n"); 
				break;
			case "back":
				if(!deque.isEmpty()) 
					sb.append(deque.peekLast()).append("\n");
				else
					sb.append(-1+"\n"); 
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				if(!deque.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(1).append("\n");
				break;
			case "pop_front":
				if(!deque.isEmpty())
					sb.append(deque.pollFirst()).append("\n");
				else
					sb.append(-1).append("\n");
				break;
			case "pop_back":
				if(!deque.isEmpty())
					sb.append(deque.pollLast()).append("\n");
				else
					sb.append(-1).append("\n");
				break;
			}
			
		}
		System.out.println(sb);
	}

}
