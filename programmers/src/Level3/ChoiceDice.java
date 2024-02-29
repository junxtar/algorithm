package Level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChoiceDice {

	private static int n;
	private static boolean[] visited;
	private static List<int[]> diceComb;

	public int[] solution(int[][] dice) {
		n = dice.length;
		int[] answer = new int[n / 2];

		visited = new boolean[n];
		diceComb = new ArrayList<>();

		generateDiceCombinations(new int[n / 2], 0, 0, dice);

		int max = Integer.MIN_VALUE;
		for (int[] combA : diceComb) {
			int[] combB = getOpponentCombination(combA);

			List<Integer> scoreA = calculateScores(combA, dice);
			List<Integer> scoreB = calculateScores(combB, dice);

			Collections.sort(scoreA);
			Collections.sort(scoreB);

			int totalWinCount = countWins(scoreA, scoreB);

			if (totalWinCount > max) {
				max = totalWinCount;
				answer = combA;
			}
		}

		return convertToHumanReadableIndex(answer);
	}

	private void generateDiceCombinations(int[] combination, int depth, int index, int[][] dice) {
		if (depth == n / 2) {
			diceComb.add(combination.clone());
			return;
		}
		for (int i = index; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combination[depth] = i;
				generateDiceCombinations(combination, depth + 1, i + 1, dice);
				visited[i] = false;
			}
		}
	}

	private int[] getOpponentCombination(int[] combA) {
		int[] combB = new int[n / 2];
		boolean[] other = new boolean[n];

		for (int choice : combA) {
			other[choice] = true;
		}

		int index = 0;
		for (int i = 0; i < other.length; i++) {
			if (!other[i]) {
				combB[index++] = i;
			}
		}
		return combB;
	}

	private List<Integer> calculateScores(int[] combination, int[][] dice) {
		List<Integer> scores = new ArrayList<>();
		calculateScoreRecursive(0, combination, dice, 0, scores);
		return scores;
	}

	private void calculateScoreRecursive(int index, int[] dices, int[][] originDices, int sum, List<Integer> team) {
		if (index == dices.length) {
			team.add(sum);
			return;
		}

		for (int i = 0; i < 6; i++) {
			calculateScoreRecursive(index + 1, dices, originDices, sum + originDices[dices[index]][i], team);
		}
	}

	private int countWins(List<Integer> scoreA, List<Integer> scoreB) {
		int totalWinCount = 0;

		for (int a : scoreA) {
			int left = 0;
			int right = scoreB.size();

			while (left + 1 < right) {
				int mid = (left + right) / 2;

				if (a > scoreB.get(mid)) {
					left = mid;
					continue;
				}
				right = mid;
			}
			totalWinCount += left;
		}
		return totalWinCount;
	}

	private int[] convertToHumanReadableIndex(int[] array) {
		int[] humanReadable = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			humanReadable[i] = array[i] + 1;
		}
		return humanReadable;
	}
}
