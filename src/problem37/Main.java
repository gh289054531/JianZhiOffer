package problem37;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			Node<Integer> virtualHead1 = new Node<Integer>(-1);
			Node<Integer> virtualHead2 = new Node<Integer>(-1);
			Node<Integer> p1 = virtualHead1;
			Node<Integer> p2 = virtualHead2;
			for (int i = 0; i < m; i++) {
				p1.next = new Node<Integer>(sc.nextInt());
				p1 = p1.next;
			}
			for (int i = 0; i < n; i++) {
				p2.next = new Node<Integer>(sc.nextInt());
				p2 = p2.next;
			}
			Integer common = FirstCommomNode(virtualHead1.next, virtualHead2.next);
			if (common == null) {
				System.out.println("My God");
			} else {
				System.out.println(common);
			}
		}
		sc.close();
	}

	public static <T> T FirstCommomNode(Node<T> head1, Node<T> head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		int count1 = 0, count2 = 0;
		Node<T> p1 = head1, p2 = head2;
		while (p1 != null) {
			count1++;
			p1 = p1.next;
		}
		while (p2 != null) {
			count2++;
			p2 = p2.next;
		}
		if (count1 < count2) {
			Node<T> temp = head1;
			head1 = head2;
			head2 = temp;
		}
		for (int i = 0; i < Math.abs(count1 - count2); i++) {
			head1 = head1.next;
		}
		while (head1 != null && head2 != null && !head1.value.equals(head2.value)) {
			head1 = head1.next;
			head2 = head2.next;
		}
		if (head1 != null && head2 != null) {
			return head1.value;
		} else {
			return null;
		}
	}

	static class Node<T> {
		T value = null;
		Node<T> next = null;

		public Node(T v) {
			this.value = v;
		}
	}
}
