package problem40;

import java.util.ArrayList;
import java.util.List;
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
			List<Integer> result = FindTwoOnce(num);
			System.out.println(result.get(0) + " " + result.get(1));
		}
		sc.close();
	}

	public static ArrayList<Integer> FindTwoOnce(int[] num) {
		ArrayList<Integer> result = new ArrayList<Integer>(2);
		if (num == null || num.length < 2) {
			return result;
		}
		int xor = 0;
		for (int i = 0; i < num.length; i++) {
			xor ^= num[i];
		}
		int temp = xor & (xor - 1);
		temp = xor - temp;
		int xor1 = 0, xor2 = 0;
		for (int i = 0; i < num.length; i++) {
			if ((num[i] & temp) != 0) {
				xor1 ^= num[i];
			} else {
				xor2 ^= num[i];
			}
		}
		result.add(xor1 < xor2 ? xor1 : xor2);
		result.add(xor1 < xor2 ? xor2 : xor1);
		return result;
	}
}
