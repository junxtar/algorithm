package Level3;

import java.util.Arrays;
//정수 삼각형 
public class IntTriangle {

	public int solution(int[][] triangle) {
		for (int i = 1; i < triangle.length; i++) {
			//첫번째 인덱스는 무조건 같은 열에 있는 전의 행 값을 더한 값이다.
			triangle[i][0] += triangle[i - 1][0];
			//i값이 서로 같은 인덱스는 무조건 전의 열에 있는 전의 행 값을 더한 값이다.
			triangle[i][i] += triangle[i - 1][i - 1];
			//그 밖의 인덱스들은 더 큰값으로 비교 
			for (int j = 1; j < i; j++)
				triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
		}
		//최대값은 항상 마지막 행에 있으므로 마지막 행에 있는 최댓값을리턴 
		return Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
	}
}