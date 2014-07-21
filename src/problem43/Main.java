package problem43;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cal(1, 6);
		System.out.println("----------------------------------------");
		Cal(2, 6);
		System.out.println("----------------------------------------");
		Cal(3, 6);
		System.out.println("----------------------------------------");
		Cal(4, 6);
		System.out.println("----------------------------------------");
		Cal(1, 7);
		System.out.println("----------------------------------------");
		Cal(2, 7);
		System.out.println("----------------------------------------");
		Cal(1, 1);
		System.out.println("----------------------------------------");
		Cal(2, 1);
		System.out.println("----------------------------------------");
		Cal(3, 1);
		System.out.println("----------------------------------------");
	}

	public static void Cal(int n, int m) {
		if (n < 1) {
			return;
		}
		int len = m * n + 1;
		int[] num1 = new int[len];
		int[] num2 = new int[len];
		Xunhuan(n, m, num1, num2);
	}

	/*
	 * 时间复杂度O(n*n*m*m) 空间复杂度O(n*m)
	 */
	private static void Xunhuan(int n, int m, int[] num1, int[] num2) {
		for (int i = 1; i <= m; i++) {// n==1
			num2[i] = 1;
		}
		for (int i = 2; i <= n; i++) {
			for (int j = i; j <= i * m; j++) {
				for (int k = 1; k <= m; k++) {
					if (j - k > 0) {
						num1[j] += num2[j - k];
					}
				}
			}
			int[] temp = num1;
			num1 = num2;
			num2 = temp;
		}
		double all = Math.pow(m, n);
		double sum = 0.0;
		for (int i = n; i <= n * m; i++) {
			System.out.println(i + ": " + (double) num2[i] / all);
			sum += (double) num2[i] / all;
		}
		assert sum == 1.0;
	}
}
