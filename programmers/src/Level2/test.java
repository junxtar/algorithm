package Level2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class test {

	public static void main(String[] args) throws IOException {
		String[] arr = { "9912", "9921", "1299" };

		String answer = "01:02";
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(5);
		System.out.println(Collections.binarySearch(list, 4));
		
		Arrays.sort(arr);
		String hour = answer.substring(0, 2);
		String min = answer.substring(3, 5);
		System.out.println(hour + " " + min);
	}

}
