package problem25;

import java.util.ArrayList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(10);
		root.left = new Node<Integer>(5);
		root.right = new Node<Integer>(12);
		root.left.left = new Node<Integer>(4);
		root.left.right = new Node<Integer>(7);
		ArrayList<Integer> path = new ArrayList<Integer>();
		Sum(root, 0, path, 22);
		assert path.size() == 0;
		root = new Node<Integer>(10);
		Sum(root, 0, path, 10);
	}

	public static void Sum(Node<Integer> node, int sum, ArrayList<Integer> path, int target) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			if (sum + node.value == target) {
				path.add(node.value);
				System.out.println(path.toString());
				path.remove(path.size() - 1);
			} else {
				return;
			}
		} else {
			if (node.left == null) {
				path.add(node.value);
				Sum(node.right, sum + node.value, path, target);
				path.remove(path.size() - 1);
			} else if (node.right == null) {
				path.add(node.value);
				Sum(node.left, sum + node.value, path, target);
				path.remove(path.size() - 1);
			} else {
				path.add(node.value);
				Sum(node.right, sum + node.value, path, target);
				path.remove(path.size() - 1);
				path.add(node.value);
				Sum(node.left, sum + node.value, path, target);
				path.remove(path.size() - 1);
			}
		}
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
