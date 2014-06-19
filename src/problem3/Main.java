package problem3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int t = sc.nextInt();
			if (m <= 0 || n <= 0 || m > 1000 || n > 1000 || t < 1 || t > 1000000) {
				System.out.println("No");
			} else {
				int[][] matrix = new int[m][n];
				for (int i = 0; i < m; i++) {
					for (int j = 0; j < n; j++) {
						matrix[i][j] = sc.nextInt();
					}
				}
				boolean result = Find(matrix, m, n, t);
				if (result) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
		}
		sc.close();
	}

	public static boolean Find(int[][] matrix, int row, int col, int target) {
		if (matrix == null || row <= 0 || col <= 0) {
			return false;
		}
		int i = 0, j = col - 1;
		while (i < row && j >= 0) {
			if (matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] > target) {
				j--;
			} else {
				i++;
			}
		}
		return false;
	}

}
