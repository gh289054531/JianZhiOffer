package problem9;

import java.util.Scanner;

public class Main {

	public static long Cal(int n) {
		if (n < 0) {
			return -1;
		}
		if (n < 2) {
			return n;
		}
		int i = 2;
		long value = -1;
		long pre1 = 1;
		long pre2 = 0;
		while (i++ <= n) {
			value = pre1 + pre2;
			pre2 = pre1;
			pre1 = value;
		}
		return value;
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
