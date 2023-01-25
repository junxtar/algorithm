package Level2;

import java.util.ArrayList;

//주식 가격
public class StockPrice {
	// List를 이용하여 구현
	public int[] solution(int[] prices) {
		ArrayList<Integer> list = new ArrayList<>();
		// 마지막 인덱스는 어떤 값이 나와도 0이므로 배열길이 - 1 까지 반복
		for (int i = 0; i < prices.length - 1; i++) {
			int value = prices[i];
			int count = 0;
			// 해당 i의 다은 인덱스 부터 i를 기점으로 크면 break 아니면 count를 1씩 증가
			for (int j = i + 1; j < prices.length; j++) {
				count++;
				if (value > prices[j]) {
					break;
				}
			}
			// count값을 list에 추가
			list.add(count);
		}
		// 마지막 인덱스에 0추가
		list.add(0);
		// stream을 이용하여 배열로 변환후 리턴
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}