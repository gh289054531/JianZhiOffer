package problem41;

import java.util.ArrayList;
import java.util.Collections;
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
			int k = sc.nextInt();
			int[] num = new int[n];
			for (int i = 0; i < n; i++) {
				num[i] = sc.nextInt();
			}
			List<Integer> result = TwoSum(num, k);
			System.out.println(result.get(0) + " " + result.get(1));
		}
		sc.close();
	}

	public static List<Integer> TwoSum(int[] num, int k) {
		List<Integer> result = new ArrayList<Integer>(2);
		if (num == null || num.length < 2) {
			result.add(-1);
			result.add(-1);
			return result;
		}
		int i = 0, j = num.length - 1;
		int first = -1, second = -1;
		long multiply = Long.MAX_VALUE;
		while (i < j) {
			long temp = 0;
			temp += num[i];
			temp += num[j];
			if (temp < k) {
				i++;
			} else if (temp > k) {
				j--;
			} else {
				long multiply_temp = num[i] * num[j];
				if (multiply_temp < multiply) {
					multiply = multiply_temp;
					first = num[i];
					second = num[j];
				}
				i++;
				j--;
			}
		}
		result.add(first);
		result.add(second);
		Collections.sort(result);
		return result;
	}
}
