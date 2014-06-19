package package12;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Print(sc.nextInt());
		sc.close();
	}

	private static void Print(int n) {
		if (n < 1) {
			return;
		}
		char[] number = new char[n];
		Arrays.fill(number, '0');
		while (Inc(number, n))
			;
	}

	private static boolean Inc(char[] num, int len) {
		for (int i = 0; i < len; i++) {
			if (num[i] - '0' + 1 <= 9) {
				num[i] += 1;
				System.out.println(Convert(num, len));
				return true;
			} else {
				num[i] = '0';
			}
		}
		return false;
	}

	private static String Convert(char[] num, int len) {
		StringBuilder sb = new StringBuilder();
		boolean meetFirstOne = false;
		for (int i = len - 1; i >= 0; i--) {
			if (num[i] != '0' && meetFirstOne == false) {
				meetFirstOne = true;
			}
			if (meetFirstOne) {
				sb.append(num[i]);
			}
		}
		return sb.toString();
	}

}
