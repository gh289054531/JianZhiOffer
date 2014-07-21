package problem47;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
			int m = sc.nextInt();
			int result = Cal(n, m);
			out.write(result + "");
			out.newLine();
			out.flush();
		}
		out.flush();
		sc.close();
	}

	private static int Cal(int n, int m) {
		// TODO Auto-generated method stub
		int sum = 0, jinwei = 0;
		do {
			sum = n ^ m;
			jinwei = (n & m) << 1;
			n = sum;
			m = jinwei;
		} while (jinwei != 0);
		return sum;
	}
}
