package Level2;

import java.util.Arrays;

//정렬과 문자열 함수 startsWidh를 활용
public class PhoneBookList {
	
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		Arrays.sort(phone_book);

		for (int i = 0; i < phone_book.length - 1; i++) {
			String str = phone_book[i];
			if (phone_book[i + 1].startsWith(str)) {
				return false;
			}
		}
		return answer;
	}
}