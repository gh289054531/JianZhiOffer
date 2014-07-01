package problem24;

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
			if (Judge(num, 0, num.length - 1)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
		sc.close();
	}

	public static boolean Judge(int[] num, int left, int right) {
		if (left == right) {
			return true;
		}
		int root = num[right];
		int i = left;
		for (; i < right; i++) {
			if (num[i] > root) {
				break;
			}
		}
		int j = i;
		for (; j < right; j++) {
			if (num[j] <= root) {
				return false;
			}
		}
		boolean result = true;
		if (result && left <= i - 1) {
			result = result && Judge(num, left, i - 1);
		}
		if (result && i <= right - 1) {
			result = result && Judge(num, i, right - 1);
		}
		return result;
	}

}
