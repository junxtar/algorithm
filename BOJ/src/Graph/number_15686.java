package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class number_15686 {

	static class Node {
		int x;
		int y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N;
	static int M;
	static int min = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] chickenVisited;
	static ArrayList<Node>chicken = new ArrayList<>();
	static ArrayList<Node>house = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					house.add(new Node(i,j));
				}else if(map[i][j] == 2) {
					chicken.add(new Node(i,j));
				}
			}
		}
		chickenVisited = new boolean[chicken.size()];
		backtracking(0,0);
		System.out.println(min);
		
		
	}

	static void backtracking(int index, int depth) {
		if(depth == M) {
			int total = 0;
			for(int i = 0; i<house.size(); i++) {
				int sum = Integer.MAX_VALUE;
				for(int j = 0; j<chicken.size(); j++) {
					if(chickenVisited[j]) {
						int dist = Math.abs(house.get(i).x - chicken.get(j).x)
							+ Math.abs(house.get(i).y - chicken.get(j).y);
						sum = Math.min(sum, dist);
					}
				}
				total += sum;
			}
			min = Math.min(min, total);
			return;
		}
		
		for(int i = index; i<chicken.size(); i++) {
			if(!chickenVisited[i]) {
				chickenVisited[i] = true;
				backtracking(i+1, depth+1);
				chickenVisited[i] = false;
			}
		}
	}
}
