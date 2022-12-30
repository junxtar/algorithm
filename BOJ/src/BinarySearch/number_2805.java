package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_2805 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[]arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		int min = 0;
		int mid = 0;
		min++;
		while(min < max) {
			mid = (min + max) / 2; 
			long length = 0;
			for(int i = 0; i<N; i++) {
				long temp = arr[i]-mid;
				if(temp > 0)
					length+=temp;
			}
			if(length < M) {
				max = mid;
			}else {
				min = mid+1;
			}
				
		}
		System.out.println(min-1);
	}

}
