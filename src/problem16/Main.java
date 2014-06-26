package problem16;

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
			Node<Integer> virtual = new Node<Integer>(-1);
			Node<Integer> p = virtual;
			for (int i = 0; i < n; i++) {
				p.next = new Node<Integer>(sc.nextInt());
				p = p.next;
			}
			Node<Integer> newHead = Reverse(virtual.next);
			if (newHead == null) {
				System.out.println("NULL");
			} else {
				while (newHead != null) {
					if (newHead.next == null) {
						System.out.print(newHead.value);
					} else {
						System.out.print(newHead.value + " ");
					}
					newHead = newHead.next;
				}
				System.out.println();
			}
		}
		sc.close();
	}

	public static <T> Node<T> Reverse(Node<T> head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node<T> newHead = head;
		while (head.next != null) {
			Node<T> p = head.next;
			head.next = p.next;
			p.next = newHead;
			newHead = p;
		}
		return newHead;
	}

	static class Node<T> {
		T value = null;
		Node<T> next = null;

		Node(T value) {
			this.value = value;
		}
	}

}
