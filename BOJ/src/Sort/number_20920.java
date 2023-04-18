package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class number_20920 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();
		
		int T = Integer.parseInt(st.nextToken());
		int wordLength = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		while(T --> 0) {
			String word = br.readLine();
			if (word.length() >= wordLength) {
				map.put(word, map.getOrDefault(word, 0) + 1);
			}
		}
		List<String> keySet = new ArrayList<>(map.keySet());
		keySet.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (map.get(o1) == map.get(o2)) {
					if (o1.length() == o2.length()) {
						return o1.compareTo(o2); 
					}
					return o2.length() - o1.length();
				}
				return map.get(o2) - map.get(o1);
			}
		});
		for (String data : keySet) {
			sb.append(data).append("\n");
		}
		System.out.println(sb.toString());

	}

}
