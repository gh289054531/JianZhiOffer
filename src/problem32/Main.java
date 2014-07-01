package problem32;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			long resulta = NumberOf1Between1ToN(a - 1);
			long resultb = NumberOf1Between1ToN(b);
			System.out.println(resultb - resulta);
		}
		sc.close();
	}

	public static long NumberOf1Between1ToN(int n) {
		if (n < 1) {
			return 0;
		} else {
			return Cal(n + "");
		}
	}

	private static long Cal(String s) {// 保证传入的数要>=1
		if (s.length() == 1) {
			if (s.charAt(0) == '0') {
				return 0;
			} else {
				return 1;
			}
		}
		long numberOf1 = 0;
		if (s.charAt(0) == '0') {
			return Cal(s.substring(1));
		}
		if (s.charAt(0) == '1') {
			numberOf1 = Integer.valueOf(s.substring(1)) + 1;
		} else {
			numberOf1 = (int) Math.pow(10, s.length() - 1);
		}
		numberOf1 += (s.charAt(0) - '0') * (s.length() - 1) * ((int) Math.pow(10, s.length() - 1 - 1));
		return numberOf1 += Cal(s.substring(1));
	}
}
