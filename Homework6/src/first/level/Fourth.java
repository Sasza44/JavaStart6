package first.level;

public class Fourth {

	public static void main(String[] args) {
		int[] array = {547, 54, 23, 81, 5, 57, 712, 7};
		int num = 81;
		System.out.println(searchNum(num, array));
	}
	static int searchNum(int n, int[] a) {
		int x = -1;
		for(int i = 0; i < a.length; i++) {
			if(a[i] == n && x == -1) { // пошук тільки першої зустрічі з даним числом
				x = i;
			}
		}
		return x;
	}
}