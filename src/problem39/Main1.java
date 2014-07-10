package problem39;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntHelper depth = new IntHelper();
		Node<Integer> root = new Node<Integer>(10);
		System.out.println(IsBalance(root, depth));

		depth = new IntHelper();
		root.left = new Node<Integer>(5);
		System.out.println(IsBalance(root, depth));

		depth = new IntHelper();
		root.left.left = new Node<Integer>(4);
		System.out.println(IsBalance(root, depth));

		depth = new IntHelper();
		root.right = new Node<Integer>(12);
		System.out.println(IsBalance(root, depth));

		depth = new IntHelper();
		root.left.right = new Node<Integer>(7);
		System.out.println(IsBalance(root, depth));

	}

	public static <T> boolean IsBalance(Node<T> root, IntHelper depth) {
		if (root == null) {
			depth.value = 0;
			return true;
		}
		IntHelper left = new IntHelper(), right = new IntHelper();
		boolean leftBalance = IsBalance(root.left, left);
		boolean rightBalance = IsBalance(root.right, right);
		if (!leftBalance || !rightBalance || Math.abs(left.value - right.value) > 1) {
			return false;
		} else {
			depth.value = Math.max(left.value, right.value) + 1;
			return true;
		}
	}

	private static class IntHelper {
		int value = 0;
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
