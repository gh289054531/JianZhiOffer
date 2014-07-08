package problem38;

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
			int[] num = new int[n];
			for (int i = 0; i < n; i++) {
				num[i] = sc.nextInt();
			}
			int m = sc.nextInt();
			for (int i = 0; i < m; i++) {
				int x = sc.nextInt();
				System.out.println(Count(num, x));
			}
		}
		sc.close();
	}

	public static int Count(int[] num, int x) {
		if (num == null || num.length == 0) {
			return 0;
		}
		int left = 0, right = num.length - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (num[middle] < x) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		if (left < 0 || left > num.length - 1 || num[left] != x) {
			return 0;
		}
		int leftIndex = left;
		right = num.length - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (num[middle] == x) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return left - leftIndex;
	}
}
