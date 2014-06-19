package problem10;

import java.util.Scanner;

public class Main {

	static int NumberOf1(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			System.out.println(NumberOf1(sc.nextInt()));
			t--;
		}
		sc.close();
	}

}
