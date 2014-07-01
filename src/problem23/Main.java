package problem23;

import java.util.LinkedList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> root = new Node<Integer>(8);
		root.left = new Node<Integer>(8);
		root.right = new Node<Integer>(7);
		root.left.left = new Node<Integer>(9);
		root.left.right = new Node<Integer>(2);
		root.left.right.left = new Node<Integer>(4);
		root.left.right.right = new Node<Integer>(7);
		Travel(root);

		Node<Integer> rootB = new Node<Integer>(8);
		rootB.left = new Node<Integer>(9);
		rootB.right = new Node<Integer>(2);
		Travel(rootB);

		rootB.right.right = new Node<Integer>(2);
		Travel(rootB);

		rootB.right = null;
		Travel(rootB);

		rootB.left = null;
		Travel(rootB);
	}

	public static <T> void Travel(Node<T> head) {
		if (head == null) {
			return;
		}
		LinkedList<Node<T>> queue = new LinkedList<Node<T>>();
		queue.offer(head);
		while (queue.isEmpty() == false) {
			Node<T> node = queue.poll();
			System.out.print(node.value.toString() + " ");
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		System.out.println();
	}

	public static class Node<T> {
		T value = null;
		Node<T> left = null;
		Node<T> right = null;

		public Node(T value) {
			this.value = value;
		}
		
		
	}

}
