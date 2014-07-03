package problem35;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.next();
			System.out.println(FistOnce(s));
		}
		sc.close();
	}

	public static int FistOnce(String s) {
		if (s == null || s.length() == 0) {
			return -1;
		}
		int[] count = new int[256];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i)] += 1;
		}
		for (int i = 0; i < s.length(); i++) {
			if (count[s.charAt(i)] == 1) {
				return i;
			}
		}
		return -1;
	}

}
