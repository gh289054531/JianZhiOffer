package problem6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] pre = new int[n];
			int[] in = new int[n];
			for (int i = 0; i < n; i++) {
				pre[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				in[i] = sc.nextInt();
			}
			Build(n, pre, in);
		}
		sc.close();
	}

	public static void Build(int num, int[] pre, int[] in) {
		if (num <= 0 || pre == null || in == null || pre.length != num || in.length != num) {
			System.out.println("No");
			return;
		}
		if (num == 1) {
			System.out.println(pre[0] + " ");
			return;
		}
		int preLeft = 0, preRight = num - 1, inLeft = 0, inRight = num - 1;
		Node root = null;
		try {
			root = RecursivelyBuild(pre, preLeft, preRight, in, inLeft, inRight);
		} catch (IllegalArgumentException e) {
			System.out.print("No");
			root = null;
		}
		PostOrderTraverse(root);
		System.out.println();
	}

	private static Node RecursivelyBuild(int[] pre, int preLeft, int preRight, int[] in, int inLeft, int inRight) {
		if (preLeft > preRight && inLeft > inRight) {
			return null;
		} else if (preLeft > preRight || inLeft > inRight) {
			throw new IllegalArgumentException();
		} else {
			Node node = new Node(pre[preLeft]);
			int position = inLeft;
			for (; position <= inRight; position++) {
				if (in[position] == node.value) {
					break;
				}
			}
			if (position == inRight + 1) {
				throw new IllegalArgumentException();
			}
			int leftLength = position - inLeft;
			if (leftLength > 0) {
				node.left = RecursivelyBuild(pre, preLeft + 1, preLeft + leftLength, in, inLeft, position - 1);
			}
			if (leftLength < preRight - preLeft) {
				node.right = RecursivelyBuild(pre, preLeft + leftLength + 1, preRight, in, position + 1, inRight);
			}
			return node;
		}
	}

	public static void PostOrderTraverse(Node head) {
		if (head == null) {
			return;
		}
		PostOrderTraverse(head.left);
		PostOrderTraverse(head.right);
		System.out.print(head.value + " ");
	}

	static class Node {
		int value;
		Node left = null, right = null;

		public Node(int value) {
			this.value = value;
		}
	}

}
