package problem8;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			int[] input = new int[n];
			for (int i = 0; i < n; i++) {
				input[i] = sc.nextInt();
			}
			System.out.println(Min(input));
		}
		sc.close();
	}

	public static int Min(int[] input) {
		if (input == null || input.length == 0) {
			throw new IllegalArgumentException();
		}
		if (input.length == 1 || input[0] < input[input.length - 1]) {
			return input[0];
		}
		int left = 0, right = input.length - 1;
		while (true) {
			if (right - left == 1) {
				return input[right];
			}
			int middle = (left + right) / 2;
			if (input[middle] > input[left]) {
				left = middle;
			} else if (input[middle] < input[left]) {
				right = middle;
			} else {
				if (input[middle] == input[right]) {
					int min = input[left];
					for (int i = left + 1; i < right; i++) {
						min = min < input[i] ? min : input[i];
					}
					return min;
				} else if (input[middle] < input[right]) {
					return input[middle];
				} else {
					left = middle;
				}
			}
		}
	}

}
