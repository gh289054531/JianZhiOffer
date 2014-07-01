package problem28;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		AllPermutation(s.toCharArray(), 0);
	}

	public static void AllPermutation(char[] chars, int depth) {
		if (chars == null || chars.length == 0) {
			return;
		}
		if (depth == chars.length - 1) {
			System.out.println(chars);
			return;
		}
		for (int i = depth; i < chars.length; i++) {
			Swap(chars, 0, i);
			AllPermutation(chars, depth + 1);
			Swap(chars, 0, i);
		}
	}

	private static void Swap(char[] chars, int left, int right) {
		char temp = chars[left];
		chars[left] = chars[right];
		chars[right] = temp;
	}
}
