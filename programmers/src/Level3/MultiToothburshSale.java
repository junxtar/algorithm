package Level3;

import java.util.HashMap;

public class MultiToothburshSale {

	// 각 사람의 포인트를 저장
	// ex) "jun" : "400"
	static HashMap<String, Integer> map = new HashMap<>();

	// 각 사람의 부모가 누군지 저장
	// ex) "jun" : "temp"
	static HashMap<String, String> connectMap = new HashMap<>();

	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		init(enroll);
		connect(enroll, referral);
		calculator(seller, amount);

		return result(enroll);
	}

	// 각 멤버의 포인트 값을 0으로 초기화
	// enroll 배열에는 최상위 부모 "-" 가 주어지지 않으므로 임의로 만들어 놓음
	private static void init(String[] enroll) {
		map.put("-", 0);
		for (int i = 0; i < enroll.length; i++) {
			String name = enroll[i];
			map.put(name, 0);
		}
	}

	// 주어진 배열에 따라 부모 연결
	private static void connect(String[] enroll, String[] referral) {
		for (int i = 0; i < enroll.length; i++) {
			String name = enroll[i];
			String parent = referral[i];

			connectMap.put(name, parent);
		}
	}

	// seller, amount 배열을 하나씩 순회해서 값을 대입
	private void calculator(String[] seller, int[] amount) {
		for (int i = 0; i < seller.length; i++) {
			String sellerName = seller[i];
			int value = amount[i] * 100;

			// connectMap에 value 값이 "-" 이면 종료
			// connectMap value 값이 "-"이 최종 부모이므로 탐색할 이유 x
			while (!sellerName.equals("-")) {
				int restValue = value / 10;
				value -= restValue;
				map.put(sellerName, map.get(sellerName) + value);
				value = restValue;
				// restValue 가 0이 되는 순간 종료
				// 10% 가 0으로 떨어지기 때문에 더 이상의 탐색은 시간 낭비로 이어짐
				// 해당 조건 없으면 [시간 초과]
				if (restValue == 0) {
					break;
				}
				sellerName = connectMap.get(sellerName);
			}
		}
	}

	private int[] result(String[] enroll) {
		int[] answer = new int[enroll.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = map.get(enroll[i]);
		}
		return answer;
	}
}
