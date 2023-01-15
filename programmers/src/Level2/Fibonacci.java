package Level2;

public class Fibonacci {
    static int[]dp;
    
    public int solution(int n) {
    	return fibonacci(n);
        
    }
    
    //점화식을 이용한 dp문제 
    public static int fibonacci(int n){
        dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i<=n; i++){
            dp[i] = dp[i - 1] % 1234567 + dp[i - 2] % 1234567; 
        }
        return dp[n] % 1234567;
    }
}


