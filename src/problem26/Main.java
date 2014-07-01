package problem26;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ComplexListNode node = new ComplexListNode();
		node.value = 1;
		ComplexListNode copy = Copy(node);
		copy.value = 2;
		assert node.value == 1;
		copy.value=1;
		while (copy != null) {
			System.out.print(copy.value + " ");
			if (copy.sibling != null) {
				System.out.print(copy.sibling.value + " ");
			} else {
				System.out.print("NULL ");
			}
			copy = copy.next;
		}
		System.out.println();

		ComplexListNode node1 = new ComplexListNode();
		node1.value = 1;
		ComplexListNode node2 = new ComplexListNode();
		node2.value = 2;
		ComplexListNode node3 = new ComplexListNode();
		node3.value = 3;
		ComplexListNode node4 = new ComplexListNode();
		node4.value = 4;
		ComplexListNode node5 = new ComplexListNode();
		node5.value = 5;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node1.sibling = node3;
		node2.sibling = node5;
		node4.sibling = node2;
		copy = Copy(node1);
		while (copy != null) {
			System.out.print(copy.value + " ");
			if (copy.sibling != null) {
				System.out.print(copy.sibling.value + " ");
			} else {
				System.out.print("NULL ");
			}
			copy = copy.next;
		}
		System.out.println();
	}

	public static ComplexListNode Copy(ComplexListNode head) {
		if (head == null) {
			return null;
		}
		ComplexListNode p = head;
		while (p != null) {
			ComplexListNode cp = new ComplexListNode();
			cp.value = p.value;
			cp.next = p.next;
			p.next = cp;
			p = p.next.next;
		}
		p = head;
		while (p != null) {
			if (p.sibling != null) {
				p.next.sibling = p.sibling.next;
			}
			p = p.next.next;
		}
		p = head;
		ComplexListNode copyHead = head.next;
		ComplexListNode q = copyHead;
		while (p != null) {
			p.next = q.next;
			if (p.next != null) {
				q.next = p.next.next;
			} else {
				q.next = null;
			}
			p = p.next;
			q = q.next;
		}
		return copyHead;
	}

	public static class ComplexListNode {
		int value;
		ComplexListNode next = null;
		ComplexListNode sibling = null;
	}
}
