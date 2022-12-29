package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class number_1744 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int tieSum = 0;
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
			sum += num[i];
		}
		Arrays.sort(num);
		if (N > 1) {
			int negativeNumber = 0;
			int postiveNumber = 0;
			for (int i = 0; i < N; i++) {
				if (num[i] <= 0)
					negativeNumber++;
				else if (num[i] > 1) {
					postiveNumber++;
				}else if (num[i] == 1) {
					tieSum += 1;
				}
			}
			if (negativeNumber % 2 == 0) {
				for (int i = 0; i < negativeNumber; i += 2) {
					tieSum += (num[i] * num[i + 1]);
				}
			} else {
				for (int i = 0; i < negativeNumber - 1; i += 2) {
					tieSum += (num[i] * num[i + 1]);
				}
				tieSum += num[negativeNumber - 1];
			}
			if (postiveNumber % 2 == 0) {
				for (int i = N - 1; i > N-postiveNumber; i -= 2) {
					tieSum += (num[i] * num[i - 1]);
				}
			} else {
				for (int i = N - 1; i > N - postiveNumber; i -= 2) {
					tieSum += (num[i] * num[i - 1]);
				}
				tieSum += num[N-postiveNumber];
			}
			System.out.println(Math.max(tieSum, sum));
		} else {
			System.out.println(sum);
		}
	}

}