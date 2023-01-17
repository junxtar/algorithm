package Level2;

import java.util.HashSet;

public class WorldRelay {
    public int[] solution(int n, String[] words) {
        
        //중복 단어 체크를 위한 HashSet 활용
        HashSet<String>set = new HashSet<>();
        int[] answer = new int[2];
        
        //첫번째 단어의 마지막 문자
        char ch = words[0].charAt(words[0].length() - 1);
        set.add(words[0]);  
        
        for(int i = 1; i<words.length; i++){
            //끝말잇기가 해당되지 않거나 중복되는 단어일 경우
            if(ch != words[i].charAt(0) || !set.add(words[i])){
                //번호는 인덱스를 인원수로 나눈 나머지 + 1
                answer[0] = (i % n) + 1;
                //차례는 인덱스를 인원수로 나눈 수 + 1
                answer[1] = (i / n) + 1;
                break;
            }
            //끝말잇기가 성공했다면 단어의 마지막 문자를 초기화
            ch = words[i].charAt(words[i].length()-1);
        }
        return answer;
      }
 }


