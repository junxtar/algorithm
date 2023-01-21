package Level2;

import java.util.Arrays;

public class Boat {
	// 그리디 문제
	// 투 포인터
	// 최대 두명씩 탈 수 있기에 가능한 풀이
	public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		int pl = 0;
		int pr = people.length - 1;
		while (pl <= pr) {
			if (people[pl] + people[pr] > limit) {
				pr--;
				answer++;
			} else {
				pl++;
				pr--;
				answer++;
			}
		}
		return answer;
	}
}
