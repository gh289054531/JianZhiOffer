package problem17;

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
			int m = sc.nextInt();
			Node<Integer> virtual1 = new Node<Integer>(-1);
			Node<Integer> p = virtual1;
			for (int i = 0; i < n; i++) {
				p.next = new Node<Integer>(sc.nextInt());
				p = p.next;
			}
			Node<Integer> virtual2 = new Node<Integer>(-1);
			p = virtual2;
			for (int i = 0; i < m; i++) {
				p.next = new Node<Integer>(sc.nextInt());
				p = p.next;
			}
			Node<Integer> newHead = Merge(virtual1.next, virtual2.next);
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

	public static <T extends Comparable<? super T>> Node<T> Merge(Node<T> head1, Node<T> head2) {
		if (head1 == null && head2 == null) {
			return null;
		} else if (head1 == null && head2 != null) {
			return head2;
		} else if (head2 == null && head1 != null) {
			return head1;
		} else {
			Node<T> newHead = new Node<T>(null);
			Node<T> p = newHead;
			while (head1 != null && head2 != null) {
				if (head1.value.compareTo(head2.value) < 0) {
					p.next = head1;
					head1 = head1.next;
				} else {
					p.next = head2;
					head2 = head2.next;
				}
				p = p.next;
			}
			if (head1 == null) {
				p.next = head2;
			}
			if (head2 == null) {
				p.next = head1;
			}
			return newHead.next;
		}
	}

	static class Node<T extends Comparable<? super T>> {
		T value = null;
		Node<T> next = null;

		Node(T value) {
			this.value = value;
		}
	}

}
