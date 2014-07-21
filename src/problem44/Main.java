package problem44;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		while (sc.hasNext()) {
			int n = sc.nextInt();
			if (n == 0) {
				break;
			}
			int[] num = new int[n];
			for (int i = 0; i < n; i++) {
				num[i] = sc.nextInt();
			}
			boolean result = IsContinue(num);
			out.write(result ? "So Lucky!" : "Oh My God!");
			out.newLine();
		}
		out.flush();
		sc.close();
	}

	public static boolean IsContinue(int[] number) {
		if (number == null || number.length < 1) {
			return false;
		}
		Arrays.sort(number);
		int len = number.length;
		int zero = 0, gap = 0;
		for (int i = 0; i < len; i++) {
			if (number[i] == 0) {
				zero++;
			} else {
				if (i < len - 1) {
					if (number[i] == number[i + 1]) {
						return false;
					} else {
						gap += number[i + 1] - number[i] - 1;
					}
				}
			}
		}
		if (gap > zero) {
			return false;
		} else {
			return true;
		}
	}
}
