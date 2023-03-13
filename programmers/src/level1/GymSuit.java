package level1;

import java.util.Arrays;

public class GymSuit {

	public int solution(int n, int[] lost, int[] reserve) {
		
		int[] arr = new int[n];
		Arrays.fill(arr, 1);
		for (int i = 0; i < lost.length; i++) {
			arr[lost[i] - 1]--;
		}
		for (int i = 0; i < reserve.length; i++) {
			arr[reserve[i] - 1]++;
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] == 2) {
				if (i != 0 && arr[i - 1] == 0) {
					arr[i - 1] += 1;
					continue;
				}
				if (i != n - 1 && arr[i + 1] == 0) {
					arr[i + 1] += 1;
				}
			}
		}
		return (int) Arrays.stream(arr).filter(m -> m != 0).count();
	}

}