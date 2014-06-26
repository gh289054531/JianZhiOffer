package problem19;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> root = new Node<Integer>(1);
		Swap(root);
		root.left = new Node<Integer>(2);
		Swap(root);
		root.right.right = new Node<Integer>(3);
		Swap(root);
		root.right = new Node<Integer>(4);
		Swap(root);
	}

	static <T> void Swap(Node<T> node) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			return;
		} else if (node.left == null && node.right != null) {
			node.left = node.right;
			node.right = null;
		} else if (node.left != null && node.right == null) {
			node.right = node.left;
			node.left = null;
		} else {
			Node<T> temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
		Swap(node.left);
		Swap(node.right);
	}

	static class Node<T> {
		T value = null;
		Node<T> left = null;
		Node<T> right = null;

		Node(T value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value.toString();
		}
	}
}
