package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class number_21276 {

	static int N, M;
	static int[] seq;
	static String[] human;
	static ArrayList<ArrayList<Integer>> grapgh;
	static HashMap<String, Integer> people;
	static TreeMap<String, ArrayList<Integer>> result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		seq = new int[N];
		human = new String[N];
		grapgh = new ArrayList<>();
		people = new HashMap<>();
		result = new TreeMap<>();

		for (int i = 0; i < N; i++) {
			String name = st.nextToken();
			human[i] = name;
			grapgh.add(new ArrayList<>());
		}
		Arrays.sort(human);
		for (int i = 0; i < N; i++) {
			people.put(human[i], i);
			result.put(human[i], new ArrayList<>());
		}
		M = Integer.parseInt(br.readLine());

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			String u = st.nextToken();
			String v = st.nextToken();

			int uIdx = people.get(u);
			int vIdx = people.get(v);
			
			seq[uIdx]++;
			grapgh.get(vIdx).add(uIdx);
		}

		topological();
	}

	static void topological() {
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> root = new ArrayList<>();
		
		for (int i = 0; i < seq.length; i++) {
			if (seq[i] == 0) {
				q.offer(i);
				root.add(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : grapgh.get(cur)) {
				seq[next]--;

				if (seq[next] == 0) {
					q.offer(next);
					result.get(human[cur]).add(next);
				}
			}
		}
		
		sb.append(root.size()).append("\n");
		for (int idx : root) {
			sb.append(human[idx]).append(" ");
		}
		sb.append("\n");
		for (String name : result.keySet()) {
			sb.append(name).append(" ").append(result.get(name).size()).append(" ");
			result.get(name).sort(null);
			for (int child : result.get(name)) {
				sb.append(human[child]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
