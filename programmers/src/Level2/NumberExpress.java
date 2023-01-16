package Level2;

public class NumberExpress {
		//연속된 자연수의 합
	
    public int solution(int n) {
        int answer = 0;
      //연속된 자연수의 합은 그 값을 홀수로 나누었을 때, 즉 홀수의 약수의 갯수와 같다.
        for(int i = 1; i<=n; i+=2){	
            if(n % i == 0){
                answer++;
            }
        }
        return answer;
    }
}