package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class number_5635 {

	static class Person implements Comparable<Person> {
		
		String name;
		int year;
		int month;
		int day;

		public Person(String name, int year, int month, int day) {
			this.name = name;
			this.year = year;
			this.month = month;
			this.day = day;
		}

		@Override
		public int compareTo(Person o) {
			if (year == o.year) {
				if (month == o.month) {
					return o.day - day;
				}
				return o.month - month;
			}
			return o.year - year;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Person> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			
			list.add(new Person(name, year, month, day));
		}
		Collections.sort(list);
		System.out.println(list.get(0).name);
		System.out.println(list.get(N-1).name);

	}

}
