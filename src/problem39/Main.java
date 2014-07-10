package problem39;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> root = new Node<Integer>(10);
		System.out.println(Deep(root,0));
		
		root.left = new Node<Integer>(5);
		System.out.println(Deep(root,0));

		root.left.left = new Node<Integer>(4);
		System.out.println(Deep(root,0));
		
		root.right = new Node<Integer>(12);
		System.out.println(Deep(root,0));

		root.left.right = new Node<Integer>(7);
		System.out.println(Deep(root,0));

	}

	public static <T> int Deep(Node<T> root, int depth) {
		if (root == null) {
			return depth;
		}
		int left = Deep(root.left, depth + 1);
		int right = Deep(root.right, depth + 1);
		return Math.max(left, right);
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
