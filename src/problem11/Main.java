package problem11;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

	static BigDecimal Pow(double m, int n) {
		if (DoubleEqual(m, 0.0)) {
			if (n <= 0)
				throw new IllegalArgumentException();
			else
				return BigDecimal.ZERO;
		}
		boolean flag = false;
		if (n < 0) {
			flag = true;
			n = -n;
		}
		BigDecimal result = RecursivlyCal(m, n);
		if (flag) {
			result = BigDecimal.ONE.divide(result);
		}
		return result;
	}

	static BigDecimal RecursivlyCal(double m, int n) {
		if (n == 0) {
			return BigDecimal.ONE;
		}
		if (n == 1) {
			return BigDecimal.valueOf(m);
		}
		BigDecimal temp = RecursivlyCal(m, n >> 1);
		temp = temp.multiply(temp);
		if ((n & 0x01) == 0) {
			return temp;
		} else {
			return temp.multiply(BigDecimal.valueOf(m));
		}
	}

	static boolean DoubleEqual(double a, double b) {
		if (Math.abs(a - b) < 0.00000000001) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			try {
				BigDecimal d = Pow(sc.nextDouble(), sc.nextInt());
				System.out.printf("%.2ef\n", d);
			} catch (IllegalArgumentException e) {
				System.out.println("INF");
			} finally {
				t--;
			}
		}
		sc.close();
	}

}
