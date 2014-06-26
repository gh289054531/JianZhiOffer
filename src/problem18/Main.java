package problem18;

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

		Node<Integer> rootB = new Node<Integer>(8);
		rootB.left = new Node<Integer>(9);
		rootB.right = new Node<Integer>(2);
		System.out.println(Judge(root, rootB));

		rootB.right.right = new Node<Integer>(2);
		System.out.println(Judge(root, rootB));

		System.out.println(Judge(root, null));
		System.out.println(Judge(null, rootB));
		System.out.println(Judge(null, null));

		rootB.right = null;
		System.out.println(Judge(root, rootB));

		rootB.left = null;
		System.out.println(Judge(root, rootB));

	}

	public static <T extends Comparable<? super T>> boolean Judge(Node<T> A, Node<T> B) {
		if (B == null) {
			return true;
		}
		if (A == null) {
			return false;
		}
		return Recursively(A, B); // make sure B is not null
	}

	private static <T extends Comparable<? super T>> boolean Recursively(Node<T> subA, Node<T> B) {
		if (Same(subA, B)) {
			return true;
		} else {
			return Same(subA.left, B) || Same(subA.right, B);
		}
	}

	private static <T extends Comparable<? super T>> boolean Same(Node<T> subA, Node<T> B) {
		if (subA == null) {
			return false;
		}
		if (subA.value.compareTo(B.value) != 0) {
			return false;
		} else {
			boolean result = true;
			if (result && B.left != null) {
				result &= Same(subA.left, B.left);
			}
			if (result && B.right != null) {
				result &= Same(subA.right, B.right);
			}
			return result;
		}
	}

	static class Node<T extends Comparable<? super T>> {
		T value = null;
		Node<T> left = null;
		Node<T> right = null;

		Node(T value) {
			this.value = value;
		}
	}

}
