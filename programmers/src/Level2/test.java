package Level2;

import java.util.HashMap;

public class test {

	public static void main(String[] args) {
		HashMap<String, Integer>map = new HashMap<>();
		map.put("aa", 3);
		map.put("aa", map.get("aa") - 1);
		
		System.out.print(map.get("aa"));
		
	}
	//ab ba ab
	//ba ab ba
	//ab ba 2
	//4 
}
