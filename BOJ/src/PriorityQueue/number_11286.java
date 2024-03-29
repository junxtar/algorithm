package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class number_11286 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer>q = new PriorityQueue<>(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2))
					return o1 - o2;
				return Math.abs(o1) - Math.abs(o2);
			}
			
		});
		int N = Integer.parseInt(br.readLine());
		while(N-->0) {
			int x = Integer.parseInt(br.readLine());
			if(x==0) {
				sb.append(q.size() == 0 ? 0:q.poll()).append("\n");
			}else {
				q.add(x);
			}
		}
		System.out.println(sb);
		
	}

}
