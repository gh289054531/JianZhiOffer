package problem36;

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
			int[] num = new int[m];
			for (int i = 0; i < m; i++) {
				num[i] = sc.nextInt();
			}
			System.out.println(MergeSort(num, 0, num.length - 1, new int[m]));
		}
		sc.close();
	}

	public static long MergeSort(int[] num, int left, int right, int[] temp) {
		if (num == null || num.length == 0) {
			return 0;
		}
		if (left >= right) {
			return 0;
		}
		int mid = (left + right) / 2;
		long count = 0;
		count += MergeSort(num, left, mid, temp);
		count += MergeSort(num, mid + 1, right, temp);
		count += Merge(num, left, mid, right, temp);
		return count;
	}

	private static long Merge(int[] num, int left, int mid, int right, int[] temp) {
		long count = 0;
		int i = left, j = mid + 1;
		int index = left;
		while (i <= mid && j <= right) {
			if (num[i] <= num[j]) {
				temp[index++] = num[i++];
			} else {
				count += mid - i + 1;
				temp[index++] = num[j++];
			}
		}
		while (i <= mid) {
			temp[index++] = num[i];
			i++;
		}
		while (j <= right) {
			temp[index++] = num[j];
			j++;
		}
		for (i = left; i <= right; i++) {
			num[i] = temp[i];
		}
		return count;
	}
}
