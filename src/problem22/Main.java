package problem22;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] in = new int[n];
			int[] out = new int[n];
			for (int i = 0; i < n; i++) {
				in[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				out[i] = sc.nextInt();
			}
			if (Judge(in, out)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
		sc.close();
	}

	public static boolean Judge(int[] in, int[] out) {
		if (in == null || out == null || in.length != out.length) {
			return false;
		}
		if (in.length == 0 && out.length == 0) {
			return true;
		}
		LinkedList<Integer> stack = new LinkedList<Integer>();
		boolean[] visited = new boolean[in.length];
		for (int i = 0; i < out.length; i++) {
			int j = 0;
			for (; in[j] != out[i]; j++) {
				if (visited[j] == false) {
					stack.push(in[j]);
					visited[j] = true;
				}
			}
			if (visited[j] == false) {
				stack.push(in[j]);
				visited[j] = true;
			}
			if (out[i] == stack.peek()) {
				stack.pop();
			} else {
				return false;
			}
		}
		return true;
	}

}
