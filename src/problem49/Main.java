package problem49;

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
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			String result = null;
			try {
				long num = Convert(s);
				result = num + "";
			} catch (Exception e) {
				result = "My God";
			}
			out.write(result);
			out.newLine();
			out.flush();
		}
		out.flush();
		sc.close();
	}

	private static long Convert(String s) {
		// TODO Auto-generated method stub
		if (s == null) {
			throw new IllegalArgumentException();
		}
		s = s.trim();
		if (s.length() == 0) {
			throw new IllegalArgumentException();
		}
		boolean negative = false;
		if (s.charAt(0) == '-') {
			negative = true;
			s = s.substring(1);
		} else if (s.charAt(0) == '+') {
			s = s.substring(1);
		}
		long result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < '0' || s.charAt(i) > '9') {
				throw new IllegalArgumentException();
			}
			result = result * 10 + s.charAt(i) - '0';
		}
		return negative ? -result : result;
	}

}
