package problem27;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> root = new Node<Integer>(10);
		root.left = new Node<Integer>(6);
		root.right = new Node<Integer>(14);
		root.left.left = new Node<Integer>(4);
		root.left.right = new Node<Integer>(8);
		root.right.left = new Node<Integer>(12);
		root.right.right = new Node<Integer>(16);
		Convert(root);
		while (root.left != null) {
			root = root.left;
		}
		while (root != null) {
			System.out.print(root.value + " ");
			root = root.right;
		}
		System.out.println();
		System.out.println("-----------------------------------------------------");

		root = new Node<Integer>(10);
		Convert(root);
		while (root.left != null) {
			root = root.left;
		}
		while (root != null) {
			System.out.print(root.value + " ");
			root = root.right;
		}
		System.out.println();
		System.out.println("-----------------------------------------------------");

		root = new Node<Integer>(10);
		root.left = new Node<Integer>(6);
		root.left.left = new Node<Integer>(4);
		Convert(root);
		while (root.left != null) {
			root = root.left;
		}
		while (root != null) {
			System.out.print(root.value + " ");
			root = root.right;
		}
		System.out.println();
	}

	public static <T> void Convert(Node<T> node) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			return;
		} else if (node.left == null && node.right != null) {
			Convert(node.right);
			Node<T> temp = node.right;
			while (temp.left != null) {
				temp = temp.left;
			}
			node.right = temp;
			temp.left = node;
		} else if (node.left != null && node.right == null) {
			Convert(node.left);
			Node<T> temp = node.left;
			while (temp.right != null) {
				temp = temp.right;
			}
			node.left = temp;
			temp.right = node;
		} else {
			Convert(node.left);
			Convert(node.right);
			Node<T> temp = node.right;
			while (temp.left != null) {
				temp = temp.left;
			}
			node.right = temp;
			temp.left = node;
			temp = node.left;
			while (temp.right != null) {
				temp = temp.right;
			}
			node.left = temp;
			temp.right = node;
		}
	}

	public static class Node<T> {
		T value = null;
		Node<T> left = null;
		Node<T> right = null;

		public Node(T value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value.toString();
		}
	}

}
