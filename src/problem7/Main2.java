package problem7;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * 两个队列实现栈
 */
public class Main2 {
	static class Stack<T> {
		Queue<T> q1 = new LinkedList<T>();
		Queue<T> q2 = new LinkedList<T>();

		public void push(T e) {
			if (q1.isEmpty() == false) {// 保证q1是空的
				Queue<T> temp = q1;
				q1 = q2;
				q2 = temp;
			}
			q2.offer(e);
		}

		public T pop() {
			if (q2.size() == 0) {
				throw new NoSuchElementException("空栈");
			}
			while (q2.size() != 1) {
				q1.offer(q2.poll());
			}
			Queue<T> temp = q1;
			q1 = q2;
			q2 = temp;
			return q1 .poll();
		}
	}
}
