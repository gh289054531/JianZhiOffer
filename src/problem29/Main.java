package problem29;

import java.util.NoSuchElementException;
import java.util.Random;
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
			int[] num = new int[n];
			for (int i = 0; i < n; i++) {
				num[i] = sc.nextInt();
			}
			try {
				int result1 = MoreThanHalfTimes1(num);
				int result2 = MoreThanHalfTimes2(num);
				System.out.println(result1);
				assert result1 == result2;
			} catch (NoSuchElementException e) {
				System.out.println(-1);
			}
		}
		sc.close();
	}

	public static Integer MoreThanHalfTimes2(int[] num) throws IllegalArgumentException, NoSuchElementException {
		if (num == null || num.length == 0) {
			throw new IllegalArgumentException();
		}
		int digit = num[0];
		int times = 1;
		for (int i = 1; i < num.length; i++) {
			if (digit == num[i]) {
				times++;
			} else {
				times--;
				if (times == 0) {
					if (i + 1 < num.length) {
						digit = num[i + 1];
						times = 1;
						i++;
					}
				}
			}
		}
		times = 0;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == digit) {
				times++;
			}
		}
		if (times > (num.length / 2.0)) {
			return digit;
		} else {
			throw new NoSuchElementException();
		}
	}

	public static Integer MoreThanHalfTimes1(int[] num) throws IllegalArgumentException, NoSuchElementException {
		if (num == null || num.length == 0) {
			throw new IllegalArgumentException();
		}
		int median = Median(num);
		int times = 0;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == median) {
				times++;
			}
		}
		if (times > (num.length / 2.0)) {
			return median;
		} else {
			throw new NoSuchElementException();
		}
	}

	private static int Median(int[] num) throws IllegalArgumentException {
		if (num == null || num.length == 0) {
			throw new IllegalArgumentException();
		}
		int left = 0, right = num.length - 1;
		int mid = num.length >>> 1;
		int pivotIndex = Partition(num, left, right);
		while (pivotIndex != mid) {
			if (pivotIndex < mid) {
				left = pivotIndex + 1;
				pivotIndex = Partition(num, left, right);
			} else {
				right = pivotIndex - 1;
				pivotIndex = Partition(num, left, right);
			}
		}
		return num[pivotIndex];
	}

	private static int Partition(int[] num, int start, int end) {
		assert start <= end;
		int random = new Random().nextInt(end - start + 1) + start;
		Swap(num, start, random);
		int pivotValue = num[start];
		int i = start, j = end;
		while (i < j) {
			while (i < j && num[j] >= pivotValue)
				j--;
			if (i < j)
				num[i] = num[j];
			while (i < j && num[i] <= pivotValue)
				i++;
			if (i < j)
				num[j] = num[i];
		}
		num[i] = pivotValue;
		return i;
	}

	private static void Swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

}
