package Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class OpenChatRoom {

	// 오픈채팅방
	// key: id ,value: name으로 받을 HashMap선언
	static HashMap<String, String> map = new HashMap<>();
	// id+문장값으로 받을 List선언
	static ArrayList<String> list = new ArrayList<>();

	public String[] solution(String[] record) {
		// 문자열 구분을 위한 StringTokenizer선언
		StringTokenizer st;
		for (int i = 0; i < record.length; i++) {
			st = new StringTokenizer(record[i]);
			// command에 따라서 메소드 따로 구현
			String command = st.nextToken();
			if (command.equals("Enter")) {
				String id = st.nextToken();
				String name = st.nextToken();
				Enter(id, name);
			} else if (command.equals("Leave")) {
				String id = st.nextToken();
				Leave(id);
			} else {
				String id = st.nextToken();
				String name = st.nextToken();
				Change(id, name);
			}
		}
		// 결과 값을 파싱해줄 answer 배열 선언
		// list로 받은 id+문장을 map의 get()를 이용하여 값 변환
		String[] answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			st = new StringTokenizer(list.get(i));

			String id = st.nextToken();
			String mid = st.nextToken();
			String last = st.nextToken();
			id = id.replaceAll(id, map.get(id));
			answer[i] = id + mid + " " + last;
		}
		return answer;
	}

	static void Enter(String id, String name) {
		map.put(id, name);
		list.add(id + " 님이 들어왔습니다.");
	}

	static void Leave(String id) {
		list.add(id + " 님이 나갔습니다.");
	}

	static void Change(String id, String name) {
		map.replace(id, map.get(id), name);
	}
}
