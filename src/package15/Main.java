package package15;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			Node<Integer> virtual = new Node<Integer>(-1);
			Node<Integer> p = virtual;
			for (int i = 0; i < n; i++) {
				p.next = new Node<Integer>(sc.nextInt());
				p = p.next;
			}
			Integer t = get(virtual.next, k);
			if (t == null) {
				System.out.println("NULL");
			} else {
				System.out.println(t);
			}
		}
		sc.close();
	}

	public static <T> T get(Node<T> head, int k) {
		if (head == null || k < 1) {
			return null;
		}
		Node<T> p = head;
		for (int i = 0; i < k - 1; i++) {
			if (p.next == null) {
				return null;
			} else {
				p = p.next;
			}
		}
		Node<T> q = head;
		while (p.next != null) {
			p = p.next;
			q = q.next;
		}
		return q.value;
	}

	static class Node<T> {
		T value = null;
		Node<T> next = null;

		Node(T value) {
			this.value = value;
		}
	}

}
