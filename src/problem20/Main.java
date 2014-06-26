package problem20;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int[][] input = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					input[i][j] = sc.nextInt();
				}
			}
			int[] result = Print(input);
			StringBuilder sb = new StringBuilder(m * n);
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i] + " ");
			}
			System.out.println(sb.toString());
		}
		sc.close();
	}

	public static int[] Print(int[][] input) {
		if (input == null || input.length < 1 || input[0].length < 1) {
			return new int[0];
		}
		int row = input.length - 1;
		int col = input[0].length - 1;
		int[] result = new int[(row + 1) * (col + 1)];
		int index = 0;
		int m = 0, n = 0;
		while (m <= row - m && n <= col - n) {
			for (int i = n; i <= col - n; i++) {
				result[index++] = input[m][i];
			}
			index--;
			for (int i = m; i <= row - m; i++) {
				result[index++] = input[i][col - n];
			}
			index--;
			if (n < col - n && m < row - m) {
				for (int i = col - n; i >= n; i--) {
					result[index++] = input[row - m][i];
				}
				index--;
				for (int i = row - m; i > m; i--) {
					result[index++] = input[i][n];
				}
			}
			m++;
			n++;
		}
		return result;
	}

}
