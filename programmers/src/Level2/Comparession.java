package Level2;

import java.util.ArrayList;

//압축 
public class Comparession {

	public int[] solution(String msg) {
		ArrayList<Integer> result = new ArrayList<>();
		ArrayList<String> values = init();

		for (int i = 0; i < msg.length(); i++) {
			StringBuilder w = new StringBuilder(String.valueOf(msg.charAt(i)));

			if (i == msg.length() - 1) {
				result.add(values.indexOf(w.toString()));
				break;
			}
			String c = String.valueOf(msg.charAt(i + 1));
			while (values.contains(w + c)) {
				w.append(c);
				i++;
				if (i == msg.length() - 1 || c.equals("")) {
					c = "";
					break;
				}
				c = String.valueOf(msg.charAt(i + 1));
			}
			if (!values.contains(w + c)) {
				values.add(w + c);
			}

			int idx = values.indexOf(w.toString());
			result.add(idx);

			if (i == msg.length() - 1 && !c.equals("")) {
				result.add(values.indexOf(c));
			}
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}

	static ArrayList<String> init() {
		ArrayList<String> list = new ArrayList<>();
		list.add("");
		for (char i = 'A'; i <= 'Z'; i++) {
			list.add(String.valueOf(i));
		}
		return list;
	}
}
