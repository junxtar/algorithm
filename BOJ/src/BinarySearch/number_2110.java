package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class number_2110 {
	
	static int N;
	static int C;	
	static int[] house;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		house = new int[N];
		
		for(int i = 0; i<N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);
		
		int lo = 1;
		int hi = house[N-1] - house[0] + 1;
		
		while(lo < hi) {
			int mid = (lo + hi) / 2;
			if(canInstall(mid) < C) {
				hi = mid;
			}else {
				lo = mid + 1;
			}
				
		}
		System.out.println(lo - 1);
		
	}
	static int canInstall(int distance) {
		int count = 1;
		int lastPoint = house[0];
		for(int i = 1; i<house.length; i++) {
			int point = house[i];
			if(point - lastPoint < distance) {
				continue;
			}
			count++;  lastPoint = point; 
		}
		return count;
	}
}
