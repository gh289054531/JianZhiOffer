package problem34;

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
			System.out.println(UglyNumber(n));
		}
		sc.close();
	}

	public static long UglyNumber(int n) {
		if (n < 1) {
			return -1;
		}
		if (n == 1) {
			return 1;
		}
		List<Integer> num = new ArrayList<Integer>();
		num.add(1);
		int i2 = 0, i3 = 0, i5 = 0;
		while (num.size() < n) {
			int max2 = 0, max3 = 0, max5 = 0;
			while (i2 < num.size()) {
				if (num.get(i2) * 2 > num.get(num.size() - 1)) {
					max2 = num.get(i2) * 2;
					break;
				} else {
					i2++;
				}
			}
			while (i3 < num.size()) {
				if (num.get(i3) * 3 > num.get(num.size() - 1)) {
					max3 = num.get(i3) * 3;
					break;
				} else {
					i3++;
				}
			}
			while (i5 < num.size()) {
				if (num.get(i5) * 5 > num.get(num.size() - 1)) {
					max5 = num.get(i5) * 5;
					break;
				} else {
					i5++;
				}
			}
			num.add(Math.min(Math.min(max2, max3), max5));
		}
		return num.get(num.size() - 1);
	}

}
