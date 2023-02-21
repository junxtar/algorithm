package Level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BestAlbum {
	
	static class Sing {
		int play;
		int num;

		Sing(int play, int num) {
			this.play = play;
			this.num = num;
		}
	}

	public int[] solution(String[] genres, int[] plays) {
		int[] answer;
		//총 장르별 스트리밍 총합을 담을 map 
		HashMap<String, Integer> value = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			value.put(genres[i], value.getOrDefault(genres[i], 0) + plays[i]);
		}
		//list에는 스트리밍 총합에 대해서 내림차순 정렬 값을 선언  
		ArrayList<String> list = selectGenre(value);
		ArrayList<Sing> result = new ArrayList<>();
		for (String data : list) {
			ArrayList<Sing> s = new ArrayList<>();
			for (int i = 0; i < genres.length; i++) {
				if (genres[i].equals(data)) {
					s.add(new Sing(plays[i], i));
				}
			}
			Collections.sort(s, (o1, o2) -> o2.play - o1.play);
			result.add(s.get(0));
			if (s.size() != 1) {
				result.add(s.get(1));
			}
		}
		answer = new int[result.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i).num;
		}
		return answer;
	}

	public static ArrayList<String> selectGenre(HashMap<String, Integer> map) {
		ArrayList<String> list = new ArrayList<>();
		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
		entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		for (Map.Entry<String, Integer> entry : entryList) {
			list.add(entry.getKey());
		}
		return list;
	}
}
