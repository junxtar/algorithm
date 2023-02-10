package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class number_1655 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer>maxHip = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer>minHip = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		while(N-->0) {
			int x = Integer.parseInt(br.readLine());
			if(maxHip.size() == 0) {
				maxHip.add(x);
				sb.append(x).append("\n");
			}else if(maxHip.size() != minHip.size()){
				int temp = maxHip.peek();
				if(temp > x) {
					maxHip.poll();
					maxHip.add(x);
					minHip.add(temp);
					sb.append(maxHip.peek()).append("\n");
				}else {
					minHip.add(x);
					sb.append(maxHip.peek()).append("\n");
				}
			}else if(maxHip.size() == minHip.size()) {
				int temp = minHip.peek();
				if(temp < x) {
					minHip.poll();
					minHip.add(x);
					maxHip.add(temp);
					sb.append(maxHip.peek()).append("\n");
				}else {
					maxHip.add(x);
					sb.append(maxHip.peek()).append("\n");
				}
			}
		}
		System.out.println(sb);
	}

}
