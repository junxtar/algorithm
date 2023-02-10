package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class number_1927 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer>q = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(N-->0) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				sb.append(q.size() == 0 ? 0 : q.poll()).append("\n");
			}else {
				q.add(x);
			}
		}
		System.out.println(sb);
		
	}

}
