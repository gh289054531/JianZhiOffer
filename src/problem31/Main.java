package problem31;

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
			if (n == 0) {
				break;
			}
			int[] num = new int[n];
			for (int i = 0; i < n; i++) {
				num[i] = sc.nextInt();
			}
			Sum(num);
		}
		sc.close();
	}

	public static void Sum(int[] num) {
		if (num == null || num.length == 0) {
			System.out.println("0 0 0");
			return;
		}
		long curSum = 0;
		long maxSum = Long.MIN_VALUE;
		int curLeft = 0;
		int maxLeft = 0, maxRight = 0;
		for (int i = 0; i < num.length; i++) {
			if (curSum < 0) {
				curSum = num[i];
				curLeft = i;
			} else {
				curSum += num[i];
			}
			if (curSum > maxSum) {
				maxSum = curSum;
				maxLeft = curLeft;
				maxRight = i;
			}
		}
		System.out.println(maxSum + " " + maxLeft + " " + maxRight);
	}
}
