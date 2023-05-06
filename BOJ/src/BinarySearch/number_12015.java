package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_12015 {

	static int N;
	static int lengthOfLIS = 1;
	static int[] seq;
	static int[] LIS;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		seq = new int[N];
		LIS = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		search();
		System.out.println(lengthOfLIS);
		
		
	}
	static void search() {
		LIS[0] = seq[0];
		for (int i = 1; i < N; i++) {
			int key = seq[i];
			
			if(LIS[lengthOfLIS - 1] < key) {
				lengthOfLIS++;
				LIS[lengthOfLIS - 1] = key;
				continue;
			}
			int start = 0;
			int end = lengthOfLIS;
			while (start < end) {
				int mid = (start + end) / 2;
				
				if (LIS[mid] < key) {
					start = mid + 1;
				} else {
					end = mid;
				}
			}
			LIS[start] = key;
		}
	}

}
