package package13;

public class Main {

	static void Delete(Node head, Node target) {
		if (head == null || target == null) {
			return;
		}
		if (head.next == null) {
			head = null;
			return;
		}
		if (target.next == null) {
			Node p = head;
			while (p.next.next != null) {
				p = p.next;
			}
			p.next = null;
			return;
		}
		target.val = target.next.val;
		target.next = target.next.next;
	}

	public static void main(String[] args) {
		Node<Integer> n1 = new Node<Integer>(1);
		Delete(n1, n1);
		assert n1 == null;
		n1 = new Node<Integer>(1);
		Node<Integer> n2 = new Node<Integer>(2);
		n1.next = n2;
		Delete(n1, n2);
		assert n1.val == 1;
		assert n1.next == null;
		n2 = new Node<Integer>(2);
		n1.next = n2;
		Delete(n1, n1);
		assert n1.val == 2;
		assert n1.val == null;
	}

	static class Node<T> {
		T val;
		Node<T> next = null;

		public Node(T val) {
			this.val = val;
		}
	}

}
