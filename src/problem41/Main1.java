package problem41;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int k = sc.nextInt();
			if (k < 0) {
				break;
			}
			List<List<Integer>> result = SumK(k);
			if (result.size() == 0) {
				System.out.println("Pity!");
				System.out.println("#");
			} else {
				for (List<Integer> cur : result) {
					for (int i = cur.get(0); i < cur.get(1); i++) {
						System.out.print(i + " ");
					}
					System.out.println(cur.get(1));
				}
				System.out.println("#");
			}
		}
		sc.close();
	}

	public static List<List<Integer>> SumK(int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (k < 3) {
			return result;
		}
		int i = 1, j = 2;
		int sum = 3;
		while (i < (k + 1) / 2) {
			if (sum < k) {
				j++;
				sum += j;
			} else if (sum > k) {
				sum -= i;
				i++;
			} else {
				List<Integer> cur = new ArrayList<Integer>(2);
				result.add(cur);
				cur.add(i);
				cur.add(j);
				sum -= i;
				i++;
			}
		}
		return result;
	}
}
