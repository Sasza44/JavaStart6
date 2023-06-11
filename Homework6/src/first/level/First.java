package first.level;

public class First {

	public static void main(String[] args) {
		int[] arr = {67, 37, 26, 670, 37, 123, 473, 85};
		System.out.println(maxNumber(arr));
	}
	
	static int maxNumber(int... a) {
		int x = a[0];
		for(int i = 1; i < a.length; i++) {
			if(a[i] > x) {
				x = a[i];
			}
		}
		return x;
	}
}