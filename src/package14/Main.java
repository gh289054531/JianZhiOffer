package package14;

import java.util.Scanner;

public class Main {

	static interface Judge {
		boolean shouldPutLeft();
	}

	static <T extends Judge> void Reorder(T[] input) {
		if (input == null || input.length < 2) {
			return;
		}
		int left = 0;
		int right = input.length - 1;
		while (left < right) {
			while (left < right && input[left].shouldPutLeft()) {
				left++;
			}
			while (left < right && !input[right].shouldPutLeft()) {
				right--;
			}
			if (left < right) {
				T temp = input[left];
				input[left] = input[right];
				input[right] = temp;
			}
		}
	}

	static class Data implements Judge {
		int value;

		Data(int value) {
			this.value = value;
		}

		@Override
		public boolean shouldPutLeft() {
			return !((this.value & 1) == 0);
		}
		
		@Override
		public String toString(){
			return value+"";
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Data[] datas = new Data[n];
		for (int i = 0; i < n; i++) {
			datas[i] = new Data(sc.nextInt());
		}
		sc.close();
		Reorder(datas);
		for (Data d : datas) {
			System.out.print(d.value + " ");
		}
		System.out.println();
	}

}
