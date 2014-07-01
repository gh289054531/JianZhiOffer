package problem30;

import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] num = new int[n];
			for (int i = 0; i < n; i++) {
				num[i] = sc.nextInt();
			}
			try {
				// GetLeastKNumber1(num, k);
				GetLeastKNumber2(num, k);
			} catch (NoSuchElementException e) {
				System.out.println(-1);
			}
		}
		sc.close();
	}

	public static void GetLeastKNumber2(int[] num, int k) throws IllegalArgumentException {
		if (num == null || num.length == 0 || k <= 0 || k > num.length) {
			throw new IllegalArgumentException();
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, Collections.reverseOrder());
		for (int i = 0; i < num.length; i++) {
			if (i < k) {
				pq.offer(num[i]);
			} else {
				if (num[i] < pq.peek()) {
					pq.poll();
					pq.offer(num[i]);
				}
			}
		}
		LinkedList<Integer> stack = new LinkedList<Integer>();
		while (pq.isEmpty() == false) {
			stack.push(pq.poll());
		}
		while (stack.size()!=1) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println(stack.pop());
	}

	public static void GetLeastKNumber1(int[] num, int k) throws IllegalArgumentException {
		if (num == null || num.length == 0 || k <= 0 || k > num.length) {
			throw new IllegalArgumentException();
		}
		int start = 0, end = num.length - 1;
		int pivotIndex = Partition(num, start, end);
		while (pivotIndex != k - 1) {
			if (pivotIndex < k - 1) {
				start = pivotIndex + 1;
				pivotIndex = Partition(num, start, end);
			} else {
				end = pivotIndex - 1;
				pivotIndex = Partition(num, start, end);
			}
		}
		for (int i = 0; i < k; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}

	private static int Partition(int[] num, int start, int end) {
		int random = new Random().nextInt(end - start + 1) + start;
		Swap(num, start, random);
		int i = start, j = end;
		int pivotValue = num[i];
		while (i < j) {
			while (i < j && num[j] >= pivotValue) {
				j--;
			}
			if (i < j) {
				num[i] = num[j];
			}
			while (i < j && num[i] <= pivotValue) {
				i++;
			}
			if (i < j) {
				num[j] = num[i];
			}
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
