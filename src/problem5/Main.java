package problem5;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		Node head = new Node();
		Node cur = head;
		while ((num = sc.nextInt()) != -1) {
			cur.next = new Node(num);
			cur = cur.next;
		}
		sc.close();
		ReversePrint(head.next);
	}

	public static void ReversePrint(Node p) {
		if (p == null) {
			System.out.println();
			return;
		}
		Stack<Integer> values = new Stack<Integer>();
		while (p != null) {
			values.push(p.value);
			p = p.next;
		}
		while (values.isEmpty() == false) {
			System.out.println(values.pop());
		}
	}

	static class Node {
		int value = -1;
		Node next = null;

		public Node() {

		}

		public Node(int value) {
			this.value = value;
		}
	}
}
