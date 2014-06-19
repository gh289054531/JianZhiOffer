package problem4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] temp = sc.nextLine().toCharArray();
		char[] s = new char[temp.length * 3];
		System.arraycopy(temp, 0, s, 0, temp.length);
		int newLength = Convert(s, temp.length);
		for (int i = 0; i < newLength; i++) {
			System.out.print(s[i]);
		}
		sc.close();
	}

	public static int Convert(char[] c, int oldLength) {
		assert c != null;
		if (oldLength == 0) {
			return 0;
		}
		int spaceCount = 0;
		for (int i = 0; i < oldLength; i++) {
			if (c[i] == ' ') {
				spaceCount++;
			}
		}
		if (spaceCount == 0) {
			return oldLength;
		}
		int newLength = oldLength + spaceCount * 2;
		int i = oldLength - 1, j = newLength - 1;
		while (i >= 0) {
			if (c[i] != ' ') {
				c[j--] = c[i--];
			} else {
				c[j--] = '0';
				c[j--] = '2';
				c[j--] = '%';
				i--;
			}
		}
		return newLength;
	}
}
