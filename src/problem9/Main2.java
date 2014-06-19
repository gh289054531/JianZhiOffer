package problem9;

import java.util.Scanner;

public class Main2 {

	public static long Cal(int n) {
		if (n < 0) {
			return -1;
		}
		return (long) Math.pow(2, n - 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			System.out.println(Cal(sc.nextInt()));
		}
		sc.close();
	}
}
