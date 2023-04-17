package palindrom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number_13275 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(solution(str));
	}

	static int solution(String s) {
		for (int i = s.length(); i > 0; i--) {
			for (int j = 0; j + i <= s.length(); j++) {
				if (isPalindrome(s, j, j + i - 1))
					return i;
			}
		}
		return 0;
	}
	static boolean isPalindrome(String s, int start, int end) {
		while (start <= end) {
			if (s.charAt(start++) != s.charAt(end--))
				return false;
		}
		return true;
	}
}

//import java.util.*;
//
//class Solution{
//    public int solution(String s){
//        String str = "";
//        for(int i = 0; i<s.length(); i++){
//            str+="#";
//            str+=s.charAt(i);
//        }
//        str+="#";
//        int[]arr = new int[str.length()];
//        for(int i = 1; i<arr.length-1; i++){
//            if(str.charAt(i-1) == str.charAt(i+1)){
//                arr[i] = 1;
//            }
//        }
//        for(int i = 1; i<arr.length - 1; i++){
//            if(arr[i] == 1){
//                arr[i] = search(i, str);
//            }
//        }
//        return Arrays.stream(arr).max().getAsInt();
//    }
//    static int search(int index, String str){
//        Stack<Character>stack = new Stack<>();
//        int count = 0;
//        for(int i = 0; i<index; i++){
//            stack.push(str.charAt(i));
//        }
//        for(int i = index+1; i<str.length(); i++){
//            if(stack.isEmpty()){
//                break;
//            }
//            if(stack.pop() != str.charAt(i)){
//                break;
//            }
//            count++;
//        }
//        return count;
//        
//    }
//}
//
