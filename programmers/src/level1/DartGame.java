package level1;

import java.util.Stack;

public class DartGame {

	class Solution {
	    static Stack<Integer>s = new Stack<>();
	    
	    public int solution(String dartResult) {
	        for (int i = 0; i < dartResult.length(); i++) {
	            //숫자 처리 로직
	            if (dartResult.charAt(i) - '0' >= 0 && dartResult.charAt(i) - '0' <= 10) {
	                if(dartResult.charAt(i) - '0' == 1 && dartResult.charAt(i+1) - '0' == 0){
	                    s.push(getNumber(dartResult, i+1, 10));
	                    i+=2;
	                    continue;
	                }
	                s.push(getNumber(dartResult, i, dartResult.charAt(i) - '0'));
	                i++;
	                continue;
	            }
	            //스타상 처리 로직
	            if (dartResult.charAt(i) == '*') {
	                getStar(dartResult);
	                continue;
	            }
	            //아차상 처리 로직
	            s.push(s.pop() * -1);
	        }
	        
	        int answer = 0;
	        while(!s.isEmpty()) {
	            answer += s.pop();
	        }
	        return answer;
	    }
	    static int getNumber(String dartResult, int index, int num) {
	        char bonus = dartResult.charAt(index + 1);
	        if (bonus == 'S')
	            return num;
	        if (bonus == 'D')
	            return num * num;
	        return (int)Math.pow(num, 3);
	    }
	    
	    static void getStar(String dartResult) {
	        if (s.size() < 2) {
	            s.push(s.pop() * 2);
	            return;
	        }
	        int num1 = s.pop() * 2;
	        int num2 = s.pop() * 2;
	        s.push(num2);
	        s.push(num1);
	    }
	}