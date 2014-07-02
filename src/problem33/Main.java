package problem33;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int m = sc.nextInt();
			Integer[] num = new Integer[m];
			for (int i = 0; i < m; i++) {
				num[i] = sc.nextInt();
			}
			System.out.println(Min(num));
		}
		sc.close();
	}

	public static String Min(Integer[] num) {
		if (num == null || num.length == 0) {
			return "";
		} else {
			Arrays.sort(num, new MyComparator());
			StringBuilder sb = new StringBuilder();
			for (Integer i : num) {
				sb.append(i);
			}
			return sb.toString();
		}
	}

	static class MyComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			String s1 = o1 + "" + o2;
			String s2 = o2 + "" + o1;
			return s1.compareTo(s2);
		}
	}

}
