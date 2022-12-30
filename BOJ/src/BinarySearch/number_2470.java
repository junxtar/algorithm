package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class number_2470 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[]data = new int[N];
		for(int i = 0; i<N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(data);
		int lo = 0;
		int hi = N - 1;
		
		int gap = Integer.MAX_VALUE;
		int first = 0;
		int two = 0;
		
		int sum = 0;
		int absSum = 0;
		while(lo < hi) {
			sum = data[lo] + data[hi];
			absSum = Math.abs(sum);
			if(gap > absSum) {
				gap = absSum;
				first = data[lo];
				two = data[hi];
			}
			if(sum > 0)	hi--;
			else lo++;
		}
		System.out.println(first+" "+two);
	}

}
