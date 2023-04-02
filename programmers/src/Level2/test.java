package Level2;

import java.util.Deque;
import java.util.LinkedList;

public class test {

	public static void main(String[] args) {
		Deque<Integer>q = new LinkedList<>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offerFirst(5);
		System.out.println(q.poll());
		
		
	}
}

