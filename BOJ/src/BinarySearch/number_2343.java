package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_2343 {
	static int N;
	static int M;
	static int min,max = 0;
	static int[] data;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			max += data[i];
			min = Math.max(min, data[i]);
		}
		System.out.println(binarySearch());
	}
	static int binarySearch() {
		
		while(min <= max) {
			int mid = (min + max) / 2;
			if(getCount(mid) > M) {
				min = mid + 1;
			}else {
				max = mid - 1;
			}
		}
		return min;
		
	}
	static int getCount(int limitSum) {
		int count = 0;
		int sum = 0;
		for(int i = 0; i<N; i++) {
			if(sum + data[i] > limitSum) {
				sum = 0;
				count++;
			}
			sum+=data[i];
		}
		if(sum!=0)    count++;
		return count;
	}

}
