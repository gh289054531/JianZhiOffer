package problem21;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			StackWithMin<Integer> stack = new StackWithMin<Integer>();
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				String op = sc.next();
				if ("s".equals(op)) {
					stack.push(sc.nextInt());
				} else {
					try {
						stack.pop();
					} catch (NoSuchElementException e) {
					}
				}
				try {
					Integer m = stack.min();
					System.out.println(m);
				} catch (NoSuchElementException e) {
					System.out.println("NULL");
				}
			}

		}
		sc.close();
	}
}

class StackWithMin<T extends Comparable<? super T>> {
	LinkedList<T> dataStack = new LinkedList<T>();
	LinkedList<T> minStack = new LinkedList<T>();

	public void push(T t) {
		dataStack.push(t);
		if (dataStack.size() == 1) {
			minStack.push(t);
		} else {
			if (t.compareTo(minStack.peek()) > 0) {
				minStack.push(minStack.peek());
			} else {
				minStack.push(t);
			}
		}
	}

	public T pop() throws NoSuchElementException {
		if (dataStack.isEmpty()) {
			throw new NoSuchElementException();
		}
		minStack.pop();
		return dataStack.pop();
	}

	public T min() throws NoSuchElementException {
		if (dataStack.isEmpty()) {
			throw new NoSuchElementException();
		}
		return minStack.peek();
	}
}
