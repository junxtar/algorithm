package Level2;


// 이문제의 핵심은 두 배열의 최대공약수를 구하는 것입니다. 
// 각각의 배열에서 최대 공약수를 구한 뒤 구한 값으로 또 다른 배열에서 그 값이 나눠지는지 체크를 하였습니다. 

public class NumberCardDiv {

	    public int solution(int[] arrayA, int[] arrayB) {
	        int answer = 0;
	        int tempA = arrayA[0];
	        //유클리드 호제법을 이용하여 배열A의 최대공약수를 구합니다.
	        for(int i = 1; i<arrayA.length; i++){
	            tempA = GCD(tempA, arrayA[i]);
	        }
	       // 유클리드 호제법을 이용하여 배열B의 최대공약수를 구합니다.
	        int tempB = arrayB[0];
	        for(int i = 1; i<arrayB.length; i++){
	            tempB = GCD(tempB, arrayB[i]);
	        }
	        //배열A의 최대공약수가 배열B의 모든 요소가 나누어 떨어지지 않는지 체크 
	        if(Check(tempA, arrayB)){
	            answer = tempA;
	        }
	        //배열B의 최대공약수가 배열A의 모든 요소가 나누어 떨어지지 않는지 체크  
	        if(Check(tempB, arrayA)){
	        	//위에 배열A에서 나누어 떨어졌었더라면 answer = 0이고 
	        	//나누어 떨어지지 않았더라면 A의 최대공약수가 있을 것이고 
	        	//배열B의 최대공약수와 비교해서 더 큰 값을 출력  
	            answer = Math.max(answer, tempB);
	        }
	        return answer;
	    }
	    
	    static int GCD(int a, int b){
	        if(b == 0)
	            return a;
	        return GCD(b, a%b);
	    }
	    static boolean Check(int a, int[]arr){
	        for(int i = 0; i<arr.length; i++){
	            if(arr[i] % a == 0){
	                return false;
	            }
	        }
	        return true;
	    }
}
