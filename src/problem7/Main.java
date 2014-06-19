package problem7;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue queue = new Queue();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String op = sc.nextLine();
			if (op.startsWith("PUSH")) {
				Integer num = Integer.parseInt(op.split(" ")[1]);
				queue.offer(num);
			} else {
				try {
					Integer num = (Integer) queue.poll();
					System.out.println(num);
				} catch (NoSuchElementException e) {
					System.out.println(-1);
				}
			}
		}
	}

	static class Queue<T> {
		Stack<T> s1 = new Stack<T>();
		Stack<T> s2 = new Stack<T>();

		public void offer(T e) {
			s1.push(e);
		}

		public T poll() {
			if (s2.isEmpty() == true) {
				if (s1.isEmpty() == true) {
					throw new NoSuchElementException("╤сапн╙©у");
				} else {
					while (s1.isEmpty() == false) {
						s2.push(s1.pop());
					}
				}
			}
			return s2.pop();
		}
	}

}
