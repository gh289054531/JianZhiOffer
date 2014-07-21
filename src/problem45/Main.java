package problem45;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * http://www.cnblogs.com/EricYang/archive/2009/09/04/1560478.html
 * 
 * @author root
 * 
 */
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
			int m = sc.nextInt();
			int result = Cal(n, m);
			out.write(result + 1 + "");
			out.newLine();
			out.flush();
		}
		out.flush();
		sc.close();
	}

	private static int Cal(int n, int m) {
		// TODO Auto-generated method stub
		if (n < 1 || m < 1) {
			throw new IllegalArgumentException();
		}
		int result = 0;
		for (int i = 2; i <= n; i++) {
			result = (result + m) % i;
		}
		return result;
	}

}
